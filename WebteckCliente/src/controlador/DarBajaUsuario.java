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

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/DarBajaUsuario")
public class DarBajaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	SesionesEjb sesionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Principal.jsp");

		try {
			// Variable que recibe el email
			String emailUsuario = usuario.getEmailUsuario();
			// Llamo al ejb del usuario y al metodo que elimina ese usuario con el correo

			usuarioEjb.eliminarUsuarios(emailUsuario);

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
