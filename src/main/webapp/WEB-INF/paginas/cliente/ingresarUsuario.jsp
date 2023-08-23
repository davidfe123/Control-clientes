
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/f358be9cea.js" crossorigin="anonymous"></script>
        <title>Control de clientes</title>
    </head>
    <body>
        
        <!-- cabecero-->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        <h1> Registro de usuarios </h1>
    <div class="container">
        <form class="py-4 was-validated" action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
              method="POST">

            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" name="nombre" required>
            </div>
            <div class="form-group">
                <label  for="apellido">Apellido</label>
                <input  type="text" class="form-control" name="apellido" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email" required>
            </div>
            <div class="form-group">
                <label for="telefono">Telefono</label>
                <input type="tel" class="form-control" name="telefono" required>
            </div>
            <div class="form-group">
                <label for="saldo">Saldo</label>
                <input type="number" class="form-control" name="saldo" required step="any">
            </div>

            <div>
                <input class="btn btn-primary" type="submit" value="Guardar" />
            </div>


        </form>
    </div>           
        <!-- Pie de pagina -->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>



    </body>
</html>
