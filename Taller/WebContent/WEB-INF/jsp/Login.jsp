<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Inicio de Sesión</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"> </script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<!-- Custom styles for this template -->
<link rel="stylesheet" href="style/css/custom/signin.css" />

</head>
<body>
  <div class="form">
    <form class="form-signin" method="post" action="LoginServlet" >
      <img class="mb-4" src="style/assets/images/repair-logo-png-1.png" alt="TallerApp" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Inicio de Sesión</h1>
      <input type="hidden" name="accion" value="login">
      <label for="inputUsername" class="sr-only">Usuario</label>
      <input type="text" id="inputUsername" class="form-control" placeholder="Nombre de Usuario" name="username" required autofocus>
      <label for="inputPassword" class="sr-only">Contraseña</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" name="password" required>
      <input type="submit" class="btn btn-lg btn-primary btn-block" value="Entrar">
      <p class="message">¿No está registrado? <a href="#">Crear una cuenta</a></p>
    </form>
    <form class="form-signin" id="form-register" method="post" action="LoginServlet" >
      <img class="mb-4" src="style/assets/images/repair-logo-png-1.png" alt="TallerApp" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Registro de Usuario</h1>
      <input type="hidden" name="accion" value="registro">
      <label for="inputUsername" class="sr-only">Email</label>
      <input type="text" id="inputUsername" class="form-control" placeholder="Email" name="email" required autofocus>
      <label for="inputUsername" class="sr-only">Nombre de Usuario</label>
      <input type="text" id="inputUsername" class="form-control" placeholder="Nombre de Usuario" name="username" required autofocus>
      <label for="inputPassword" class="sr-only">Contraseña</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" name="password" required>
      <label for="inputPassword2" class="sr-only">Vuelva a ingresar la Contraseña</label>
      <input type="password" id="inputPassword2" class="form-control" placeholder="Contraseña" name="password2" required>
      <input type="submit" class="btn btn-lg btn-success btn-block" value="Registrar">
      <p class="message">¿Ya tiene una cuenta? <a href="#">Ingresar al sistema</a></p>
    </form>
   </div>
   <script src="style/js/custom/signin.js"></script>
</body>
</html>