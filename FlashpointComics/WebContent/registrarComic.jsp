<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Comic</title>
</head>
<body>
<jsp:include page="encabezado.jsp"></jsp:include>

<h1> Pantalla Para Registrar Comics</h1>

<a href="Loguin.jsp">Ventana de Login de Usuario</a>
<br> <a href="ListadoComic">Ver Lista de Comics</a>

<%! public String obtenerAtributo(HttpServletRequest request, String nombre){
	String valor = (String) request.getAttribute(nombre);
	if(valor == null){
		valor = "";
	}	
	return valor;
} %>


<p><font style="color:red;"><%=obtenerAtributo(request,"valError")%></font></p>

  <DIV ALIGN=center> 
<table>
<form action = "RegistroComic">
<tr>
<td> Titulo:</td>
<td><input type="text" name="titulo" value="<%=obtenerAtributo(request,"valTitulo")%>"/></td>
</tr>
<tr>
<td> Autor:</td>
<td><input type="text" name="autor" value="<%=obtenerAtributo(request,"valAutor")%>"/></td>
</tr>
<tr>
<td> Resumen:</td>
<td><input type="text" name="resumen" value="<%=obtenerAtributo(request,"valResumen")%>"/></td>
</tr>
<tr>
<td> Edicion:</td>
<td><input type="text" name="edicion" value="<%=obtenerAtributo(request,"valEdicion")%>"/></td>
</tr>
<tr>
<td> Idioma:</td>
<td><input type="text" name="idioma" value="<%=obtenerAtributo(request,"valIdioma")%>"/></td>
</tr>
<tr>
<td> Fecha de publicacion:</td>
<td><input type="text" name="fechaPubli" value="<%=obtenerAtributo(request,"valFechaPublic")%>"/></td>
</tr>
<tr>
<td> No. Paginas:</td>
<td><input type="text" name="numPag" value="<%=obtenerAtributo(request,"valNumPag")%>"/></td>
</tr>
<tr>
<td> Imagen:</td>
<td><input type="text" name="imagen" value="<%=obtenerAtributo(request,"valImagen")%>"/></td>
</tr>
<tr>
<td> Comic:</td>
<td><input type="text" name="comic" value="<%=obtenerAtributo(request,"valComic")%>"/></td>
</tr>
<td><input type="submit" value="Guardar"/></td>
</form> 
</table>
</DIV>
 <jsp:include page="pieDePagina.jsp"></jsp:include>
</body>
</html>