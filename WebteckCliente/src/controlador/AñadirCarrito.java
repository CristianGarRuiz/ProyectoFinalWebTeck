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
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/AñadirCarrito")
public class AñadirCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	// EJBS utilizados en este servlet
	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recupero la session
		HttpSession session = request.getSession();
		// Asocio la sesion al usuario logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// estancion la variable error
		String error = request.getParameter("error");
		// estancion la variable id
		String id = request.getParameter("id");
		// le value of para pasarla a entero
		Integer indentificador = Integer.valueOf(id);

		// Creo la variable int id de la variable identificador
		int idProducto = indentificador;
		// recupero el email del usuario
		String emailUsuario = usuario.getEmailUsuario();

		// paso las instancias utilizadas
		request.setAttribute("error", error);
		request.setAttribute("idProducto", idProducto);
		request.setAttribute("emailUsuario", emailUsuario);

		// Compruebo que no sean nulos
		if (id != null && emailUsuario != null) {

			CarritosPojo car = new CarritosPojo();

			car.setEmailUsuario(emailUsuario);
			car.setIdProducto(idProducto);

			// Añado el producto al carro
			carritoEjb.añadirProductoCarro(car);

			response.sendRedirect("Principal");
			loggerNormal.debug("Se añadido el producto al carro sin problema");

		} else {

			response.sendRedirect("error?Hay");
			loggerError.error("error añadir al carrito");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
