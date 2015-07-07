package paqueteServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Paso1_datosPersonales")
public class Paso1_datosPersonales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PASO_ACTIVO = "1";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// se comprueba si hay variables de sesi�n y, de ser as�, se recuperan 
		String nombre= "";
		String apellidos= "";
		String genero= "M";
		String fechaNacimiento= "";
		String casado= "";
		String hijos= "";
		String[] nacionalidades= new String[0];
		
		// se recupera la sesi�n
		HttpSession laSesion= request.getSession(false);  //carga la sessi�n si existe, devuelve null sino
		if(laSesion != null) {
			if (request.getParameter("empezar") != null) {  // se ha recibido el par�metro empezar
				laSesion.invalidate();  // se inactiva la sesi�n
			} else {
				if (laSesion.getAttribute("nombre") != null) {
					nombre = (String) laSesion.getAttribute("nombre");
				}
				if (laSesion.getAttribute("apellidos") != null) {
					apellidos = (String) laSesion.getAttribute("apellidos");
				}
				if (laSesion.getAttribute("genero") != null) {
					genero = (String) laSesion.getAttribute("genero");
				}
				if (laSesion.getAttribute("casado") != null) {
					casado = "checked=\"checked\"";
				}
				if (laSesion.getAttribute("hijos") != null) {
					hijos = (String) laSesion.getAttribute("hijos");
				}
				if (laSesion.getAttribute("fechaNacimiento") != null) {
					fechaNacimiento = (String) laSesion.getAttribute("fechaNacimiento");
				}
				if (laSesion.getAttribute("nacionalidad") != null) {
					nacionalidades = (String[]) laSesion.getAttribute("nacionalidad");
				}
			}
		}
		
		// se pasan los atributos al JSP
		request.setAttribute("pasoActivo", PASO_ACTIVO);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("genero", genero);
		request.setAttribute("casado", casado);
		request.setAttribute("hijos", hijos);
		request.setAttribute("fechaNacimiento", fechaNacimiento);
		request.setAttribute("nacionalidades", nacionalidades);
		
		// enruta a la vist+a 
		String vista = "/Paso1_datosPersonales.jsp";  // la ruta debe comenzar por /
		// el destino puede ser un servlet, un jsp, un html
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}