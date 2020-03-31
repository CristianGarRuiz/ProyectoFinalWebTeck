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
import modelo.Ejb.UsuarioEjb;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/DarBajaEmpleado")
public class DarBajaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Pagina.jsp");

		try {
			// Variable que recibe el email
			String emailUsuario = request.getParameter("emailUsuario");
			// Llamo al ejb del usuario y al metodo que elimina ese usuario con el correo
			usuarioEjb.eliminarEmpleado(emailUsuario);

			// cunado el usuario esta eliminado le cierro la sesion
			sesionesEjb.logoutUsuario(session);

			// recojo la request de la variable instanciada
			request.setAttribute("emailUsuario", emailUsuario);

		} catch (Exception e) {
			loggerError.error(e.getMessage() + "Error al eliminar un usuario con el email propio");
			

		}
		loggerNormal.debug("Eliminado Correctamente");
		rs.forward(request, response);

	}

}
