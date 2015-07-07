<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedHashMap, java.util.Iterator"%>

<div id="navegacion">
<%
  LinkedHashMap<String,String[]> datosNavegacion = new LinkedHashMap<String,String[]>() {{
	put("1", new String[]{"Paso1_datosPersonales", "Number-1-icon.png", "Datos personales"});
	put("2", new String[]{"Paso2_datosProfesionales", "Number-2-icon.png", "Datos profesionales"});
	put("3", new String[]{"Paso3_datosBancarios", "Number-3-icon.png", "Datos bancarios"});	
	put("4", new String[]{"Resumen", "checkered-flag-icon.png", "Resumen"});
}};
  String pasoActivo = (String) request.getParameter("pasoActivo");
  String salida= "";
  Iterator<String> iteradorConjuntoClaves = datosNavegacion.keySet().iterator();
  String contextPath = request.getContextPath();
  while (iteradorConjuntoClaves.hasNext()){
		String clave = iteradorConjuntoClaves.next();
		String[] valor = datosNavegacion.get(clave);
  		if (clave.equals(pasoActivo)) {
  	    	salida += "<a href=\"" + valor[0] + "\"><img src=\"" + contextPath + "/img/" + valor[1] + "\" title=\"" + valor[2] + "\" width=\"40\" height=\"40\" /></a>" + "\n";  	    	
  		} else {
  			salida += "<a href=\"" + valor[0] + "\"><img src=\"" + contextPath + "/img/" + valor[1] + "\" title=\"" + valor[2] + "\" width=\"40\" height=\"40\" style=\"opacity:0.4;\" /></a>" + "\n";
  		}
  }
  out.print(salida);
%>  
</div>