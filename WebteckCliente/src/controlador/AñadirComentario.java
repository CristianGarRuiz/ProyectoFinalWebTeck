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
import modelo.Ejb.ValoracionesEjb;
import modelo.Pojo.UsuariosPojo;
import modelo.Pojo.ValorcionesPojo;

@WebServlet("/AñadirComentario")
public class AñadirComentario extends HttpServlet {
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
	ValoracionesEjb valoracionesEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recupero la sesion
		HttpSession session = request.getSession();
		// asocio la sesion con el usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recogo el valor de pantalla de la session
		String pantalla = sesionesEjb.getPantalla(session);
		// Creo la estancia de la variable erro que recojo
		String error = request.getParameter("error");
		// Creo la estancia de la variable id que recojo
		String id = request.getParameter("id");
		// Paso la variable id a integer
		Integer indentificador = Integer.valueOf(id);
		// creo una estancia nueva para pasar el identificador
		int idProducto = indentificador;

		// recupero el valor de email
		String emailUsuario = usuario.getEmailUsuario();

		// recupero el comentario
		String comentario = request.getParameter("comentario");

		// Paso los atributos
		request.setAttribute("error", error);
		request.setAttribute("idProducto", idProducto);
		request.setAttribute("emailUsuario", emailUsuario);
		request.setAttribute("comentario", comentario);
		request.setAttribute("pantalla", pantalla);

		if (comentario != null) {

			ValorcionesPojo v = new ValorcionesPojo();

			v.setComentarios(comentario);
			v.setEmailUsuario(emailUsuario);
			v.setIdProducto(idProducto);

			// añado el comentario
			valoracionesEjb.añadirComentario(v);
			response.sendRedirect("Principal");
			loggerNormal.debug("SE ha comentado correctamente el producto");

			// Comentar

		} else {
			response.sendRedirect("error?Hay");
			loggerError.error("No se ha podido comentar el producto");
		}
	}

}
