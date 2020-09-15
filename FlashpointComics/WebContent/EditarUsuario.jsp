<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<htmllang ="en" xmlns:th="http://www.thymeleaf.org">
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
<link rel="stylesheet" type="text/css" href="CSS/EstiloEditar.css"
	th:href="@{/css/index.css}">

<title>Editar Usuario</title>
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
				<div class="col-12">
					<p><%=obtieneAtributo(request, "valError")%></p>
					<H1>Editar Usuario</H1>
				</div>
				<form class="col-12" th:action="@{/login}"
					action="ServletActualizarUsuario" method="post">
					<div class="form-group" id="id-group">
						<input type="text" readonly="readonly" class="form-control" name="id"
							value="<%=obtieneAtributo(request, "valId")%>" />
					</div>
					<div class="form-group" id="user-group">
						<input type="text"  class="form-control" name="nombre"
							value="<%=obtieneAtributo(request, "valUser")%>" />
					</div>
					<div class="form-group" id="email-group">
						<input type="text" class="form-control" name="email"
							value="<%=obtieneAtributo(request, "valEmail")%>" />
					</div>
					<div class="form-group" id="contrasena-group">
						<input type="password" class="form-control" name="contraseña"
							value="<%=obtieneAtributo(request, "valContraseña")%>" />
					</div>
					<button type="submit" class="btn btn-primary">
						<i class="fas fa-sign-in-alt"></i> Actualizar
					</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>