package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.Ejb.ImagenesEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/cambiarImagenUsuario")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class cambiarImagenUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	ImagenesEjb imagenesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero la session
		HttpSession session = request.getSession();
		// creo la estancia error
		String error = request.getParameter("error");
		// asocio al usuario logeado con la session
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recupera el valora de pantalla de la session
		String pantalla = sesionesEjb.getPantalla(session);
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/cambiarImagen.jsp");

		// paso las estancias utilizadas
		request.setAttribute("error", error);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("usuario", usuario);

		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero la session
		HttpSession session = request.getSession();
		// asocion la session al usuario logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		ServletContext context = getServletContext();
		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Principal.jsp");

		// recupero el email de usuario
		String emailUsuario = usuario.getEmailUsuario();

		// compruebo que no sea nulo
		if (emailUsuario != null) {
			UsuariosPojo usu = new UsuariosPojo();
			// le paso le usuario asociado al cambio
			usu.setEmailUsuario(emailUsuario);
			// y modifico la imagen de usuario
			usu.setFoto(imagenesEjb.guardarImagen(request, context));
			usuarioEjb.updateFoto(usu);
			rsPagina.forward(request, response);
			loggerNormal.debug("se ha cambiado la imagen del usuario correctamente");
		} else {

			response.sendRedirect("error?Hay");
			loggerError.error("No se ha podido cambiar la imagen del usuario");

		}
	}

}
