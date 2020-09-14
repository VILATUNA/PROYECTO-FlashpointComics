<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import="ec.epn.edu.controlador.Encabezados" %> 
<%@ page import="java.util.Date" %>  

<DIV ALIGN=center><img src="img/Flashpoint.jpg"  width="200" height="75" /></DIV>
   <%Encabezados mc=new Encabezados();
   String p=mc.nombre();
   %>
<H3><font style="color:black;"><DIV ALIGN=center><%=p %> </DIV></font></H3>
<font style="color:blue;"><DIV ALIGN=center> <%=new Date()%></DIV></font>
<DIV ALIGN=center><HR WIDTH="100%"></HR></DIV> 