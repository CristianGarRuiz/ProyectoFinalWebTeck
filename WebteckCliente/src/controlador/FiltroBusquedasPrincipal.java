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
import modelo.Ejb.VentaEjb;
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/FiltroBusquedasPrincipal")
public class FiltroBusquedasPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	// EJBS utulizados
	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	PreguntasEjb preguntasEjb;

	@EJB
	VentaEjb ventaEjb;

	@EJB
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupero la sesion
		HttpSession session = request.getSession();
		// Estancio la variable error
		String error = request.getParameter("error");
		// Asocio al usuario a la session
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recupero el valor de pantalla de la sesion
		String pantalla = sesionesEjb.getPantalla(session);
		// Recupero el valor de email de la sesion
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// Recupero el valor de la id de categorias
		String eseid = request.getParameter("Categorias");
		Integer idCategoria = Integer.valueOf(eseid);

		// Recupero el valor de la id de categorias
		String esid = request.getParameter("Marcas");
		Integer idMarca = Integer.valueOf(esid);

		// Recupero el precion de inicio
		String eseprecio = request.getParameter("precioIni");
		Integer precioIni = Integer.valueOf(eseprecio);

		// Recupero el precio final
		String eseprecioFinal = request.getParameter("precioFin");
		Integer precioFin = Integer.valueOf(eseprecioFinal);

		// los dispacher para redirigir a uno otro jsp
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/FiltroBusqueda.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/FiltroBusquedaNocturna.jsp");

		// Cuento los porductos del carro
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);
		// Cuento los porductos por id de categoria
		ProductosTiendaPojo contarProd = productosEjb.contarProductosporCategoria(idCategoria);

		// Paso los atributos
		request.setAttribute("usuario", usuario);
		request.setAttribute("idMarca", idMarca);
		request.setAttribute("idCategoria", idCategoria);
		request.setAttribute("precioIni", precioIni);
		request.setAttribute("precioFin", precioFin);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("contarCarro", contarCarro);
		request.setAttribute("contarProd", contarProd);

		// Comporbamos el valor de pantalla

		if (pantalla == null || pantalla.equals("D")) {

			// ira el metodo con que llama al filtro y muestra un array de productos por los
			// valores de busqueda

			ArrayList<ProductosTiendaPojo> Busquedaproducto = productosEjb.leerProductosFiltro(idMarca, idCategoria,
					precioIni, precioFin);

			request.setAttribute("Busquedaproducto", Busquedaproducto);
			rs.forward(request, response);
			loggerNormal.debug("Entrado sin problemas en filtro del producto en pagina diurna");

		} else {
			// ira el metodo con que llama al filtro y muestra un array de productos por los
			// valores de busqueda
			ArrayList<ProductosTiendaPojo> Busquedaproducto = productosEjb.leerProductosFiltro(idMarca, idCategoria,
					precioIni, precioFin);
			request.setAttribute("Busquedaproducto", Busquedaproducto);
			rsNocturna.forward(request, response);
			loggerNormal.debug("Entrado sin problemas en filtro de producto en pagina nocturna");

		}

	}
}
