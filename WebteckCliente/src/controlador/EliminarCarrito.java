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
import modelo.Ejb.CarritosEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/EliminarCarrito")
public class EliminarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	// EJBS utilizados
	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productoEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero la sesion
		HttpSession session = request.getSession();
		// asocio la session al usuario logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// estancio la variable error
		String error = request.getParameter("error");
		// recupero el email de usuario
		String emailUsuario = usuario.getEmailUsuario();
		// estancio la variable id que recupero
		String id = request.getParameter("id");
		// La paso a integer
		Integer idProducto = Integer.valueOf(id);

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emailUsuario", emailUsuario);

		try {

			// Elimino el porducto del carro por las id y email de usuario
			carritoEjb.eliminarProductoCarro(idProducto, emailUsuario);
		} catch (Exception e) {
			loggerError.error(e.getMessage() + "Error al eliminar una direccion de un usuario con el email propio");

		}
		loggerNormal.debug("Eliminado Correctamente");
		response.sendRedirect("VerCarrito");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
