package paqueteServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Paso3_datosBancarios")
public class Paso3_datosBancarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PASO_ACTIVO = "3";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// se comprueba si hay variables de sesión y, de ser así, se recuperan 
		String cuentaCorriente= "";

		//se comprueba si se reciben parámetros => se viene del PASO 1 => hay que guardarlos en la sesión		
		// se recupera la sesión
		HttpSession laSesion= request.getSession(false);  //carga la sessión si existe, devuelve null sino
		if(laSesion != null) {
			if (request.getParameter("departamento") != null) {
				laSesion.setAttribute("departamento", request.getParameter("departamento"));
			}
			if (request.getParameter("salario") != null) {
				laSesion.setAttribute("salario", request.getParameter("salario"));
			}			
			if (request.getParameter("comentarios") != null) {
				laSesion.setAttribute("comentarios", request.getParameter("comentarios"));
			}

			// se comprueba que haya variables de sesión y, de ser así, se recupera su valor
			if (laSesion.getAttribute("cuentaCorriente") != null) {
				cuentaCorriente = (String) laSesion.getAttribute("cuentaCorriente");
			}
		}
		
		// se pasan los atributos al JSP
		request.setAttribute("pasoActivo", PASO_ACTIVO);
		request.setAttribute("cuentaCorriente", cuentaCorriente);
		
		// enruta a la vista 
		String vista = "/Paso3_datosBancarios.jsp";  // la ruta debe comenzar por /
		// el destino puede ser un servlet, un jsp, un html
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}