<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<!--JQUERY-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!-- Los iconos tipo Solid de Fontawesome-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

<!-- Nuestro css-->
<link rel="stylesheet" type="text/css" href="CSS/Estilo.css"
	th:href="@{/css/index.css}">

<title>Login</title>

</head>
<body>

	<div class="modal-dialog text-center">
		<div class="col-sm-8 main-section">
			<div class="modal-content">
				<div class="col-12 user-img">
					<img src="img/user.png" th:src="@{/img/user.png}" />
				</div>
				<form class="col-12" th:action="@{/login}" action="ServletListaUsuarios" method="post">
					<div class="form-group" id="user-group">
						<input type="text" class="form-control"
							placeholder="Nombre de usuario" name="username" />
					</div>
					<div class="form-group" id="contrasena-group">
						<input type="password" class="form-control"
							placeholder="Contrasena" name="password" />
					</div>
					<button type="submit" class="btn btn-primary">
						<i class="fas fa-sign-in-alt"></i> Ingresar
					</button>
				</form>
				<div class="col-12 forgot">
					<a href="#">Recordar contrasena?</a>
				</div>
				<div class="col-12 forgot">
					<p>
						�No tienes cuenta? <a href="RegistroUsuario.jsp">Registrate aqui</a>
					</p>
				</div>
			</div>
		</div>
	</div>

</body>
</html>