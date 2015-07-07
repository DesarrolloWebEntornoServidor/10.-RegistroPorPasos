<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="paqueteClases.Scriptlets, paqueteClases.Datos"%>

<%-- Se reciben los atributos pasados por el servlet--%>
<%
	String pasoActivo = (String) request.getAttribute("pasoActivo");
	String departamento = (String) request.getAttribute("departamento");
	String salario = (String) request.getAttribute("salario");
	String comentarios = (String) request.getAttribute("comentarios");

%>
<!doctype html>
<html>
<head>
<meta charset='utf-8' />
<title>Registro por pasos - Datos profesionales</title>
</head>
<body>

<jsp:include page="navegacion.jsp">
	  <jsp:param name="pasoActivo" value="<%=pasoActivo%>"/>
</jsp:include>

<form action="Paso3_datosBancarios">
<fieldset>
	<legend>Datos profesionales</legend>		
	Departamento 
	<%=Scriptlets.generaSelectSimple("departamento", Datos.arrayDepartamentos, departamento) %>
	Salario <input name="salario" id="salario" value="<%=salario %>" /> <br />
	Comentarios 
	<textarea name="comentarios" cols="40" rows="5"><%=comentarios %></textarea> <br />
	<input type="submit" value="Grabar información e ir al paso 3 - Datos bancarios" />
	</fieldset>
</form>

</body>
</html>