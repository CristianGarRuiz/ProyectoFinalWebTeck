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
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.DireccionesPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/InsertarDireccion")
public class InsertarDireccion extends HttpServlet {
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
	DireccionesEjb direccionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero la sesion
		HttpSession session = request.getSession();
		// Asocio el usuario logeado a la sesion
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recupero el valor de pantalla de la sesion
		String pantalla = sesionesEjb.getPantalla(session);
		// estancion la variable error
		String error = request.getParameter("error");

		// Recojo del formulario los valores
		String emailUsuario = usuario.getEmailUsuario();
		String direccion = request.getParameter("direccion");
		String vivienda = request.getParameter("vivienda");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String codigo = request.getParameter("codigoPostal");
		Integer codigoPostal = Integer.valueOf(codigo);

		// Paso los atributos
		request.setAttribute("error", error);
		request.setAttribute("emailUsuario", emailUsuario);
		request.setAttribute("vivienda", vivienda);
		request.setAttribute("direccion", direccion);
		request.setAttribute("localidad", localidad);
		request.setAttribute("provincia", provincia);
		request.setAttribute("codigoPostal", codigoPostal);
		request.setAttribute("pantalla", pantalla);

		// Comprueblos que los valores no sea nulos
		if (codigo != null && emailUsuario != null && localidad != null && provincia != null && vivienda != null
				&& direccion != null) {

			DireccionesPojo d = new DireccionesPojo();

			d.setCodigoPostal(codigoPostal);
			d.setDireccion(direccion);
			d.setEmailUsuario(emailUsuario);
			d.setLocalidad(localidad);
			d.setProvincia(provincia);
			d.setVivienda(vivienda);

			// Añado la direcion
			direccionesEjb.añadirDireccion(d);

			response.sendRedirect("Principal");
			loggerNormal.debug("Añadida direccion correctamente");

			// Comentar

		} else {
			response.sendRedirect("error?Hay");
			loggerError.error("Fallo al añadir la direccion");
		}
	}

}
