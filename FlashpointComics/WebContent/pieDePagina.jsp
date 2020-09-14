<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ec.epn.edu.controlador.Encabezados" %> 
   <%
    	Encabezados mc=new Encabezados();
       String r=mc.informacionEscritura();
       String s=mc.informacionLlamadas();
       String t=mc.informacionUbicacion();
    %>
<DIV ALIGN=center><HR WIDTH="100%"></HR></DIV> 
<font style="color:blue;"><pre><%=r+s+t%></pre></font>