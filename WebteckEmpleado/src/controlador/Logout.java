package controlador;

import java.io.IOException;

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


/**
 * Clase que permite hacer logout a los usuarios
 * 
 * @author daw
 *
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	SesionEjb sesionesEjb;

	/**
	 * Método que trata las peticiones GET que llegan al servlet.
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Si la sesion no es nula cierro la session
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Pagina.jsp");
		if (session != null) {

			sesionesEjb.logoutUsuario(session);
			loggerNormal.debug("Cerrada la sesion con exito del usuario");
		}

		rs.forward(request, response);

	}

}
