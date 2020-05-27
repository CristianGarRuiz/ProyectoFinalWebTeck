package controlador;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.Ejb.DireccionesEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/EliminarDireccion")
public class EliminarDireccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	@EJB
	DireccionesEjb direccionEjb;

	@EJB
	SesionesEjb sesionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero la sesion
		HttpSession session = request.getSession();
		// Asocio la sesion al usuario logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Estancio la variable error
		String error = request.getParameter("error");
		// recupero el email de usuario
		String emailUsuario = usuario.getEmailUsuario();

		// Paso la request de las variable que utilizo
		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emailUsuario", emailUsuario);

		try {

			// Elimino la direccion por el email de usuario
			direccionEjb.eliminarDireccion(emailUsuario);
		} catch (Exception e) {
			loggerError.error(e.getMessage() + "Error al eliminar una direccion de un usuario con el email propio");

		}
		loggerNormal.debug("Eliminado Correctamente");
		response.sendRedirect("Principal");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
