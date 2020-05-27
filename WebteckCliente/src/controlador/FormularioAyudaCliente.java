package controlador;

import java.io.IOException;
import java.util.ArrayList;
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
import modelo.Ejb.CarritosEjb;
import modelo.Ejb.MailsEjb;
import modelo.Ejb.PreguntasEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/FormularioAyudaCliente")
public class FormularioAyudaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	// EJBS utlizados

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	PreguntasEjb preguntasEjb;

	@EJB
	CarritosEjb carritoEjb;
	@EJB
	MailsEjb mailEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recupero la sesion
		HttpSession session = request.getSession();
		// Asocio la sesion al usuario logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);

		// Recupero el valor de pantalla de la sesion
		String pantalla = sesionesEjb.getPantalla(session);
		// recupero el valor de email de la sesion
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// Estancio la variable error
		String error = request.getParameter("error");

		// Compruebo que el email no sea nulo

		if (emailUsuario == null) {

			// Recupero los porductos
			ArrayList<ProductosTiendaPojo> productosTienda = productosEjb.leerTotalProductos();
			// Recupero la categorias
			ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
			// Recupero las marcas
			ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
			// Recupero la media de productos
			ArrayList<ProductosTiendaPojo> productosMedia = productosEjb.leerTotalProductosMedia();

			// Dispacher para redirigir a una o otra pagina
			RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/formClienteMensaje.jsp");
			RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/formClienteMensajeNocturna.jsp");

			request.setAttribute("usuario", usuario);
			request.setAttribute("pantalla", pantalla);
			request.setAttribute("productosTienda", productosTienda);
			request.setAttribute("productosMedia", productosMedia);
			request.setAttribute("categorias", categorias);
			request.setAttribute("marcas", marcas);
			request.setAttribute("error", error);

			if (pantalla == null || pantalla.equals("D")) {
				rsPagina.forward(request, response);
			} else {
				rsNocturna.forward(request, response);
			}

		} else {
			// Recupero los porductos
			ArrayList<ProductosTiendaPojo> productosTienda = productosEjb.leerTotalProductos();
			// Recupero la categorias
			ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
			// Recupero las marcas

			ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
			// Recupero la media de productos
			ArrayList<ProductosTiendaPojo> productosMedia = productosEjb.leerTotalProductosMedia();

			// Cuento los productos del carro
			CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

			// los dispacher de la redireccion
			RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Principal.jsp");
			RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/PrincipalNocturna.jsp");

			// Paso los atributos
			request.setAttribute("usuario", usuario);
			request.setAttribute("pantalla", pantalla);
			request.setAttribute("productosTienda", productosTienda);
			request.setAttribute("productosMedia", productosMedia);
			request.setAttribute("categorias", categorias);
			request.setAttribute("marcas", marcas);
			request.setAttribute("error", error);
			request.setAttribute("contarCarro", contarCarro);
			request.setAttribute("emailUsuario", emailUsuario);

			// Comprueblo el valor de pantalla y redirigo aun o otro jsp
			if (pantalla == null || pantalla.equals("D")) {
				rsPagina.forward(request, response);
			} else {
				rsNocturna.forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero los valores del formulacior
		// para luego pasarselo al ejb del metodo para enviar el correo
		String para = "garciaruizcristian50@gmail.com";

		String remitente = request.getParameter("remitente");

		String asunto = request.getParameter("asunto");

		String nombre = request.getParameter("nombre");

		String mensaje = request.getParameter("mensaje");

		if (para != null && asunto != null && mensaje != null && nombre != null && remitente != null) {

			mailEjb.sendMail1(para, nombre, remitente, asunto, mensaje);
			response.sendRedirect("Principal");
			loggerNormal.debug("Enviando correo sin problemas");
		} else {
			response.sendRedirect("FormularioAyudaCliente?error=hay ");
			loggerError.error("No se ha enviado el correo ");

		}

	}

}
