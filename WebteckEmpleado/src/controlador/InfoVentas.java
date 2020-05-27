package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.Ejb.SesionEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Ejb.VentasEjb;
import modelo.Pojo.UsuarioPojo;
import modelo.Pojo.VentasPojo;


@WebServlet("/InfoVentas")
public class InfoVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;

	@EJB
	VentasEjb ventaEjb;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupero la session
		HttpSession session = request.getSession();
		//creos la estancia de la parametro error
		String error = request.getParameter("error");
		//Recupero la session asociada al usuario
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/infoVentas.jsp");
		//Recojo los atributos creados 
		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		
		//y envio a la pagina 
		rs.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// creo la variable inico y fin para las fecha
		String inicio = request.getParameter("inicio");
		String fin = request.getParameter("fin");
		//creo la variable error
		String error = null;
		//Recupero la session asociada al usuario
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		// dispache para la pagina
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/infoVentas.jsp");

		try {
			// el arraylist de las estadisticas del ejb con las fecha pasadas
			ArrayList<VentasPojo> ventas = ventaEjb.leerProductosporFecha(inicio, fin);

			// recogo los atributos de las estancias que he creado
			request.setAttribute("ventas", ventas);
			request.setAttribute("error", error);
			request.setAttribute("usuario", usuario);
			request.setAttribute("inicio", inicio);
			request.setAttribute("fin", fin);
		} catch (Exception e) {
			loggerError.error( e.getMessage()+ "Error al realizar la consultas por fechas");
		}

		// los datos que le paso no son nulos pues redirigo a la pagina con los datos
		if (inicio != null && fin != null) {
			rs.forward(request, response);
			loggerNormal.debug(" Realizando la consultas sin fallos");

		} else {
			// sino dirigo con el error
			response.sendRedirect("PaginaPrincipal?error=hay fechas Incorrectas");

			
		}

	}

}
