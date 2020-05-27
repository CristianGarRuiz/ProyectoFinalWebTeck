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
import modelo.Ejb.DireccionesEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.DireccionesPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/VerCarrito")
public class VerCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	CarritosEjb carritoEjb;

	@EJB
	DireccionesEjb direccionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero la session
		HttpSession session = request.getSession();
		// Asocio al usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);

		// recupero el valor de pantalla de la sesion
		String pantalla = sesionesEjb.getPantalla(session);
		// recupero el email de la sesion
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// estancio la variable error
		String error = request.getParameter("error");

		// Compruebo que no sea nulo el email
		if (emailUsuario == null) {

			//Recupero los productos del carro
			ArrayList<CarritosPojo> productosCarrito = carritoEjb.leerCarrito(emailUsuario);
			//Recupero todas las categorias
			ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
			//Recupero todas las marcas
			ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
			//Cuento los productos del carro
			CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);
			
			//Dispacher de redireccion de un o otro jsp
			RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Carrito.jsp");
			RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/CarritoNocturna.jsp");

			//Recupero la suma de precios de todo el carro
			CarritosPojo totalCarro = carritoEjb.sumaCarro(emailUsuario);

			//Paso los atributos
			request.setAttribute("usuario", usuario);
			request.setAttribute("pantalla", pantalla);
			request.setAttribute("productosCarrito", productosCarrito);
			request.setAttribute("error", error);
			request.setAttribute("categorias", categorias);
			request.setAttribute("marcas", marcas);
			request.setAttribute("contarCarro", contarCarro);
			request.setAttribute("totalCarro", totalCarro);

			// Compruebo el valor de pantalla
			if (pantalla == null || pantalla.equals("D")) {
				rsPagina.forward(request, response);
			} else {
				rsNocturna.forward(request, response);
			}

		} else {

			// Recupero la los porductos del carro
			ArrayList<CarritosPojo> productosCarrito = carritoEjb.leerCarrito(emailUsuario);
			// Recupero las categorias
			ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
			// Recupero las marcas
			ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
			// Cuento los productos del carro
			CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);
			// Recupero la direccion del cliente
			ArrayList<DireccionesPojo> direccionesUsuarios = direccionesEjb.leerDatosporMail(emailUsuario);
			// El precio total del carro
			CarritosPojo totalCarro = carritoEjb.sumaCarro(emailUsuario);

			// los dispacher de redireccion de un o otro jsp
			RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Carrito.jsp");
			RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/CarritoNocturna.jsp");

			// Paso los a atributod
			request.setAttribute("usuario", usuario);
			request.setAttribute("pantalla", pantalla);
			request.setAttribute("productosCarrito", productosCarrito);
			request.setAttribute("error", error);
			request.setAttribute("categorias", categorias);
			request.setAttribute("marcas", marcas);
			request.setAttribute("contarCarro", contarCarro);
			request.setAttribute("direccionesUsuarios", direccionesUsuarios);
			request.setAttribute("totalCarro", totalCarro);

			// Compruebo el valor de pantalla
			if (pantalla == null || pantalla.equals("D")) {
				rsPagina.forward(request, response);
				loggerNormal.debug("Entrado sin problema en modo diurno");
			} else {
				rsNocturna.forward(request, response);
				loggerNormal.debug("Entrando sin problema en modo nocturno");
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
