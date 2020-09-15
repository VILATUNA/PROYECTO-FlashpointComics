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
<title>Registro Usuario</title>
</head>
<body>
	<%!public String obtieneAtributo(HttpServletRequest request, String Dato) {
		String valor = (String) request.getAttribute(Dato);
		if (valor == null) {
			valor = "";
		}
		return valor;
	}%>

	<p><%=obtieneAtributo(request, "valError")%></p>

	<div class="modal-dialog text-center">
		<div class="col-sm-8 main-section">
			<div class="modal-content">
				<div class="col-12 user-img">
					<img src="img/user.png" th:src="@{img/user.png}" />
				</div>
				<form class="col-12" action="ServletRegistroUsuario" method="post">
					<div class="form-group" id="user-group">
						<input type="text" class="form-control"
							placeholder="Nombre de usuario" name="username"
							value="<%=obtieneAtributo(request, "valUser")%>" />
					</div>
					<div class="form-group" id="email-group">
						<input type="text" class="form-control" placeholder="Email"
							name="Email" value="<%=obtieneAtributo(request, "valEmail")%>" />
					</div>
					<div class="form-group" id="contrasena-group">
						<input type="password" class="form-control"
							placeholder="Contraseña" name="password"
							value="<%=obtieneAtributo(request, "valContraseña")%>" />
					</div>
					<div class="form-group" id="contrasena-group">
						<input type="password" class="form-control"
							placeholder="Repite Contraseña" name="Repitepassword"
							value="<%=obtieneAtributo(request, "valRepiteContraseña")%>" />
					</div>
					<button type="submit" class="btn btn-primary">
						<i class="fas fa-sign-in-alt"> </i> Registrar
					</button>
				</form>

			</div>
		</div>
	</div>

</body>
</html>