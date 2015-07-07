<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="paqueteClases.Scriptlets, paqueteClases.Datos"%>

<%-- Se reciben los atributos pasados por el servlet--%>
<%
	String pasoActivo = (String) request.getAttribute("pasoActivo");
	String nombre = (String) request.getAttribute("nombre");
	String apellidos = (String) request.getAttribute("apellidos");
	String fechaNacimiento = (String) request.getAttribute("fechaNacimiento");
	String genero = (String) request.getAttribute("genero");
	String casado = (String) request.getAttribute("casado");
	String hijos = (String) request.getAttribute("hijos");
	String[] nacionalidades = (String[]) request.getAttribute("nacionalidades");
%>
<!doctype html>
<html>
<head>
<meta charset='utf-8' />
<title>Registro por pasos - Datos personales</title>
</head>
<body>

<jsp:include page="navegacion.jsp">
	  <jsp:param name="pasoActivo" value="<%=pasoActivo%>"/>
</jsp:include>

<form action="Paso2_datosProfesionales">
<fieldset>
	<legend>Datos personales</legend>		
	Nombre <input name="nombre" id="nombre" value="<%=nombre %>" />
	Apellidos <input name="apellidos" id="apellidos" value="<%=apellidos %>" /> <br />
	Fecha de nacimiento <input type="date" name="fechaNacimiento" value="<%=fechaNacimiento %>" /> <br />
	Género
	<%=Scriptlets.generaBotonesRadio("genero", Datos.arrayGeneros, genero) %>  
	<br />
	Casado o Pareja de hecho 
	<%="<input type=\"checkbox\" name=\"casado\" id=\"casado\" value=\"CPH\"" + casado + "/>" %>
	Hijos 
	<%="<input type=\"checkbox\" name=\"hijos\" id=\"hijos\" value=\"HJS\"" + hijos + "/>" %>	
	<br />
	Nacionalidades
	 <%=Scriptlets.generaSelectMultiple("nacionalidad", Datos.arrayPaises, nacionalidades, 4) %>
	<br />
	<input type="submit" value="Grabar información e ir al paso 2 - Datos profesionales" />
	</fieldset>
</form>

</body>
</html>


