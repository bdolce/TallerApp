<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Inicio de Sesión</title>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<!-- Custom styles for this template -->
<link rel="stylesheet" href="style/css/custom/signin.css" />

</head>

<body>
    <form class="form-signin" action="LoginServlet">
      <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Inicio de Sesión</h1>
      <label for="inputUsername" class="sr-only">Usuario</label>
      <input type="text" id="inputUsername" class="form-control" placeholder="Nombre de Usuario" name="username" required autofocus>
      <label for="inputPassword" class="sr-only">Contraseña</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
      <input type="submit" class="btn btn-lg btn-primary btn-block" value="Entrar">
      <p class="mt-5 mb-3 text-muted">&copy; BD</p>
    </form>
</body>
</html>