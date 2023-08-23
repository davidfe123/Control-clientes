package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "ingresar":
                    this.ingresarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente saldoCliente : clientes) {

            saldoTotal += saldoCliente.getSaldo();
        }

        return saldoTotal;
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int ideCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(ideCliente));
        request.setAttribute("Cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    private void ingresarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ingresarCliente = "/WEB-INF/paginas/cliente/ingresarUsuario.jsp";
        request.getRequestDispatcher(ingresarCliente).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;

                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // recuperamos datos
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldo)) {
            saldo = Double.parseDouble(saldoString);
        }
        // creamo el objeto de cliente (modelo)  
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        // Insertar en la base de datos

        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registros modificados = " + registrosModificados);

        //  redirigimos hacia accion por default
        this.accionDefault(request, response);

    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // recuperamos datos   
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldo)) {
            saldo = Double.parseDouble(saldoString);
        }
        // creamo el objeto de cliente (modelo)  
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        // Insertar en la base de datos

        int registrosModificados = new ClienteDaoJDBC().isertar(cliente);
        System.out.println("registros modificados = " + registrosModificados);

        //  redirigimos hacia accion por default
        this.accionDefault(request, response);

    }
}
