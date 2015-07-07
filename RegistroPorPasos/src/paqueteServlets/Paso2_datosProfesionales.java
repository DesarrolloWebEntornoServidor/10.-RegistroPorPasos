package paqueteServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Paso2_datosProfesionales")
public class Paso2_datosProfesionales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PASO_ACTIVO = "2";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// se comprueba si hay variables de sesión y, de ser así, se recuperan 
		String departamento= "";
		String salario= "";
		String comentarios= "";

		//se comprueba si se reciben parámetros => se viene del PASO 1 => hay que guardarlos en la sesión		
		// se recupera la sesión
		HttpSession laSesion= request.getSession(false);  //carga la sessión si existe, devuelve null sino
		if(laSesion != null) {
			if (request.getParameter("nombre") != null) {
				laSesion.setAttribute("nombre", request.getParameter("nombre"));
			}
			if (request.getParameter("apellidos") != null) {
				laSesion.setAttribute("apellidos", request.getParameter("apellidos"));
			}			
			if (request.getParameter("genero") != null) {
				laSesion.setAttribute("genero", request.getParameter("genero"));
			}
			if (request.getParameter("casado") != null) {
				laSesion.setAttribute("casado", "checked=\"checked\"");
			} else {
				laSesion.removeAttribute("casado");
			}
			if (request.getParameter("hijos") != null) {
				laSesion.setAttribute("hijos", "checked=\"checked\"");
			} else {
				 laSesion.removeAttribute("hijos");
			}
			if (request.getParameter("fechaNacimiento") != null) {
				laSesion.setAttribute("fechaNacimiento", request.getParameter("fechaNacimiento"));
			}
			String[] nacionalidad = (String[]) request.getParameterValues("nacionalidad");
			if (nacionalidad != null) {
				laSesion.setAttribute("nacionalidad", nacionalidad);
			}

			// se comprueba que haya variables de sesión y, de ser así, se recupera su valor
			if (laSesion.getAttribute("departamento") != null) {
				departamento = (String) laSesion.getAttribute("departamento");
			}
			if (laSesion.getAttribute("salario") != null) {
				salario = (String) laSesion.getAttribute("salario");
			}
			if (laSesion.getAttribute("comentarios") != null) {
				comentarios = (String) laSesion.getAttribute("comentarios");
			}			
		}
		
		// se pasan los atributos al JSP
		request.setAttribute("pasoActivo", PASO_ACTIVO);
		request.setAttribute("departamento", departamento);
		request.setAttribute("salario", salario);
		request.setAttribute("comentarios", comentarios);
		
		// enruta a la vista 
		String vista = "/Paso2_datosProfesionales.jsp";  // la ruta debe comenzar por /
		// el destino puede ser un servlet, un jsp, un html
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}