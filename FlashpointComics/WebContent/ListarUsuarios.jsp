<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="ec.epn.edu.modelo.Usuario"%>
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
<link rel="stylesheet" type="text/css" href="CSS/EstiloLista.css"
	th:href="@{/css/index.css}">
<title>Lista de Usuarios</title>
</head>
<body>

	<div class="modal-dialog text-center">
		<div class="main-section center-block">
			<div class="modal-content">
				<div>
					<H1>Listado de Usuarios</H1>
					<a href="RegistroUsuario.jsp">Crear Nuevo Usuario</a>
				</div>
				<div>
				<table class="table table-responsive table-striped">
					<tr>
						<th>ID</th>
						<th>Nombre de Usuario</th>
						<th>Email</th>
						<th>Contraseña</th>
						<th>Editar</th>
						<th>Eliminar</th>
					</tr>
					<%
						List<Usuario> Usuarios;
						Usuarios = (List<Usuario>) request.getAttribute("Usuarios");

						for (Usuario U : Usuarios) {
					%>
					<tr>
						<td><%=U.getId()%></td>
						<td><%=U.getNombre()%></td>
						<td><%=U.getEmail()%></td>
						<td><%=U.getContraseña()%></td>
						<td><a href="ServletEditarUsuario?id=<%=U.getId()%>">Editar</a></td>
						<td><a href="ServletEliminarUsuario?id=<%=U.getId()%>">Eliminar</a></td>
					</tr>
					<%
						}
					%>
				</table>
				<a href="registrarComic.jsp">Registro De Comic</a>
				</div>
			</div>
		</div>
	</div>


</body>
</html>