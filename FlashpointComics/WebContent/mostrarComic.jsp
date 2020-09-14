<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="ec.epn.edu.modelo.Comic" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Comic</title>
</head>
<body>
<jsp:include page="encabezado.jsp"></jsp:include>   <H1>Listado de Comics</H1>

   <a href="registrarComic.jsp">Crear Comic</a>
   
    
   
  <DIV ALIGN=center> 
  <table border="1">
      <tr>
      	<th>ID</th>
      	<th>Titulo</th>
      	<th>Autor</th>
      	<th>Resumen</th>
      	<th>Idioma</th>
      	<th>Imagen</th>
      	<th>Leer</th>
      	<th>Editar</th>
      	<th>Eliminar</th>     	
      </tr>
      <%
      List<Comic> comic;
      comic= (List<Comic>)request.getAttribute("comic");
      
      for (Comic l:comic) {
      %>
      <tr>
      	<td><%= l.getId_comic() %></td>
      	<td><%= l.getCmc_titulo() %></td>
      	<td><%= l.getCmc_autor() %></td>
      	<td><%= l.getCmc_resumen() %></td>
      	<td><%= l.getCmc_idioma() %></td>
      	<th> <img src="IMG_COMICS\<%=l.getCmc_imagen()%>.jpg"  width="100" height="150" /></th>
      	<td><a href="MuestraComic?id=<%=l.getId_comic()%>">Leer Comic</a></td>
      	<td><a href="EditaComic?id=<%=l.getId_comic()%>">Editar</a></td>
      	<td><a href="EliminaComic?id=<%=l.getId_comic()%>">Eliminar</a></td>
      </tr>      	
      <% 
      }
      %>   

   </table>
   </DIV>
 <jsp:include page="pieDePagina.jsp"></jsp:include>
</body>
</html>