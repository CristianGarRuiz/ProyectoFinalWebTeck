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
import modelo.Ejb.PreguntasEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	// EJBS utilizados
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero la session
		HttpSession session = request.getSession();
		// Asociado la sesion al usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);

		// Recupero el valor de pantalla de la sesion
		String pantalla = sesionesEjb.getPantalla(session);
		// Recupero el email de la session
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// Estancio variable error
		String error = request.getParameter("error");

		// Compruebo que el email del usuario no sea nulo
		if (emailUsuario == null) {

			// Recupero todod los productos
			ArrayList<ProductosTiendaPojo> productosTienda = productosEjb.leerTotalProductos();
			// Recupero todas las categorias
			ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
			// Recupero todas las marcas
			ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
			// Recupero total de productos media
			ArrayList<ProductosTiendaPojo> productosMedia = productosEjb.leerTotalProductosMedia();

			// Dispacher de un jps o otro
			RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Principal.jsp");
			RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/PrincipalNocturna.jsp");

			// Paso los atributod¡s
			request.setAttribute("usuario", usuario);
			request.setAttribute("pantalla", pantalla);
			request.setAttribute("productosTienda", productosTienda);
			request.setAttribute("productosMedia", productosMedia);
			request.setAttribute("categorias", categorias);
			request.setAttribute("marcas", marcas);
			request.setAttribute("error", error);

			// Compruebo el valor de pantalla
			if (pantalla == null || pantalla.equals("D")) {
				rsPagina.forward(request, response);
				loggerNormal.debug("Entrando correctamente ne pagina diurna");
			} else {
				rsNocturna.forward(request, response);
				loggerNormal.debug("Entrando correctamente ne pagina Nocturna");
			}

		} else {
			// Recupero todos los productos
			ArrayList<ProductosTiendaPojo> productosTienda = productosEjb.leerTotalProductos();
			// Recupero todas las categorias
			ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
			// Recupero todas las marcas
			ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
			// Recupero los porductos con mejor media
			ArrayList<ProductosTiendaPojo> productosMedia = productosEjb.leerTotalProductosMedia();

			// cuento el total de productos del carro
			CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

			// Dispacher de un a o otro jsp
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

			// Comprubo el valor de pantalla
			if (pantalla == null || pantalla.equals("D")) {
				rsPagina.forward(request, response);
				loggerNormal.debug("Entrando correctamente en pagina diurna");
			} else {
				rsNocturna.forward(request, response);
				loggerNormal.debug("Entrando correctamente ne pagina Nocturna");
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Request de la sesion
		HttpSession session = request.getSession();
		// Estancia de la variable error
		String error = request.getParameter("error");
		// Asociado la session a la usuario logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recupero el valor de pantalla de la session
		String pantalla = sesionesEjb.getPantalla(session);
		// Recupero el valor de titulo
		String titulo = request.getParameter("titulo");
		// Recupero el valor de email de la session
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// Los dispcher de un o otro jsp
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/ProductosBusqueda.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/ProductosBusquedaNocturna.jsp");

		// Contar los porductos del carro
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		// Paso los atributos
		request.setAttribute("usuario", usuario);
		request.setAttribute("titulo", titulo);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("contarCarro", contarCarro);
		// Generamos la página para el usuario y la mostramos

		if (pantalla == null || pantalla.equals("D")) {

			ArrayList<ProductosTiendaPojo> Busquedaproducto = productosEjb.BuscarProductoporNombreTienda(titulo);

			request.setAttribute("Busquedaproducto", Busquedaproducto);
			rs.forward(request, response);
			loggerNormal.debug("Entrando correctamente ne pagina diurna");

		} else {
			ArrayList<ProductosTiendaPojo> Busquedaproducto = productosEjb.BuscarProductoporNombreTienda(titulo);
			request.setAttribute("Busquedaproducto", Busquedaproducto);
			rsNocturna.forward(request, response);
			loggerNormal.debug("entrando correctamente en pagina nocturna");

		}

	}

}
