package paqueteClases;

import java.util.LinkedHashMap;

public class Datos {

	public static LinkedHashMap<String,String> arrayPaises = new LinkedHashMap<String,String>() {
		
		private static final long serialVersionUID = 1L;

	{
		put("ES", "España");
		put("FR", "Francia");
		put("IT", "Italia");
		put("PT", "Portugal");		
	}};
	
	public static LinkedHashMap<String,String> arrayGeneros = new LinkedHashMap<String,String>() {
		 
		private static final long serialVersionUID = 1L;

	{
		put("H", "Hombre");
		put("M", "Mujer");
		put("O", "Otro");
	}};

	public static LinkedHashMap<String,String> arrayDepartamentos = new LinkedHashMap<String,String>() {
		private static final long serialVersionUID = 1L;

	{
		put("10", "Ventas");
		put("20", "Marketing");
		put("30", "IT");
	}};

}
