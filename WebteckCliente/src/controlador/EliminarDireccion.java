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

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String error = request.getParameter("error");
		String emailUsuario = usuario.getEmailUsuario();

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emailUsuario", emailUsuario);
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Principal.jsp");

		try {

			direccionEjb.eliminarDireccion(emailUsuario);
		} catch (Exception e) {
			loggerError.error(e.getMessage() + "Error al eliminar una direccion de un usuario con el email propio");

		}
		loggerNormal.debug("Eliminado Correctamente");
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
