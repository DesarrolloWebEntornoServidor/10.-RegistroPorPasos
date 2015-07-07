<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="paqueteClases.Scriptlets, paqueteClases.Datos"%>

<%-- Se reciben los atributos pasados por el servlet--%>
<%
	String pasoActivo = (String) request.getAttribute("pasoActivo");
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
	<legend>Datos bancarios</legend>		
	Cuenta corriente <input name="cuentaCorriente" id="cuentaCorriente" value="<%= cuentaCorriente %>" /> <br />
	<input type="submit" value="Grabar información e ir al resumen final" />
</fieldset>
</form>

</body>
</html>