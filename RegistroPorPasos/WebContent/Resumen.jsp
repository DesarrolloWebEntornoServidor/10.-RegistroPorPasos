<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="paqueteClases.Scriptlets, paqueteClases.Datos"%>

<%-- Se reciben los atributos pasados por el servlet--%>
<%
	String pasoActivo = (String) request.getAttribute("pasoActivo");
	String nombre = (String) request.getAttribute("nombre");
	String apellidos = (String) request.getAttribute("apellidos");
	String fechaNacimiento = (String) request.getAttribute("fechaNacimiento");
	String genero = (String) request.getAttribute("genero");
	String[] nacionalidad = (String[]) request.getAttribute("nacionalidad");
	String departamento = (String) request.getAttribute("departamento");
	String salario = (String) request.getAttribute("salario");
	String comentarios = (String) request.getAttribute("comentarios");
	String cuentaCorriente = (String) request.getAttribute("cuentaCorriente");

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

<form action="Resumen">
<fieldset>
	<legend>Datos personales</legend>		
	Nombre: <b><%=nombre%></b> <br />
	Apellidos: <b><%=apellidos%></b> <br />
	Fecha de nacimiento: <b><%=fechaNacimiento%></b> <br />
	Género: <b><%= (genero.equals("")) ? "" : Datos.arrayGeneros.get(genero) %></b> <br />
	Nacionalidades: <b><% for (String s: nacionalidad) { out.print(Datos.arrayPaises.get(s) + " "); } %></b> <br />
</fieldset>
<fieldset>
	<legend>Datos profesionales</legend>		
	Departamento: <b><%= (departamento.equals("")) ? "" : Datos.arrayDepartamentos.get(departamento) %></b> <br />
	Salario: <b><%=salario %></b> <br />
	Comentarios: <b><%=comentarios%></b> <br />
</fieldset>
<fieldset>
	<legend>Datos bancarios</legend>		
	Cuenta corriente: <b><%=cuentaCorriente%></b> <br />
</fieldset>
<a href="Paso1_datosPersonales?empezar">Volver al principio</a>
</form>

</body>
</html>