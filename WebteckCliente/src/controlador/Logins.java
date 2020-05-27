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
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/Logins")
public class Logins extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	UsuariosEjb usuariosEJB;

	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	SesionesEjb sesionesEJB;

	/**
	 * Método que trata las peticiones GET que llegan al servlet
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Principal.jsp");
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Login.jsp");
		// Intentamos obtener el usuario de la sesión
		UsuariosPojo usuario = sesionesEJB.usuariosLogeado(session);

		if (usuario != null) {
			// Ya está logeado, lo redirigimos a la principal
			rsPagina.forward(request, response);

		} else {
			// No está logeado, mostramos página de login
			request.setAttribute("usuario", usuario);
			request.setAttribute("error", error);

			rs.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// recojo la request del valor del formulario
		// Luego compruebo que no sea nula
		String nombre = request.getParameter("usuario");
		String pass = request.getParameter("password");

		if (session != null) {
			// Si tenemos sesión, miramos si tenemos usuario en la sesión
			UsuariosPojo usuario = null;

			usuario = usuariosEJB.leerDato(nombre, pass);
			
			
			
			
			
			// Si no tenemos usuario, es una sesión no válida y la invalidamos
			if (usuario == null || usuario.getActivado().equals("n")  || usuario.getActivado().equals("N")) {
				sesionesEJB.logoutUsuario(session);
				response.sendRedirect("Logins?error=hay");
				loggerError.error("Error al al Logearse " + usuario);
			} else {
				// Añadimos el usuario a la sesión
				session = request.getSession(true);
				sesionesEJB.loginUsuario(session, usuario);
				// Lo redirigimos a la página principal
				loggerNormal.debug("Entramos sin problemas con el  usuario");
				response.sendRedirect("Principal");

			}
		}
	}

}
