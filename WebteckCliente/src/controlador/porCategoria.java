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
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/porCategoria")
public class porCategoria extends HttpServlet {
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
	VentaEjb ventaEjb;

	@EJB
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recojo la sesion
		HttpSession session = request.getSession();
		// Asocio al usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recojo el valor de pantalla
		String pantalla = sesionesEjb.getPantalla(session);
		// estancio la variable error
		String error = request.getParameter("error");
		// Recupero el valor del email del usuario
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// Dispacher para redireccionar a un jsp o a otro
		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/mostrarProductoporCategoria.jsp");
		RequestDispatcher rsNocturna = getServletContext()
				.getRequestDispatcher("/mostrarProductoporCategoriaNocturna.jsp");

		// Recupero la id
		String eseid = request.getParameter("id");

		// la paso a integer
		Integer id = Integer.valueOf(eseid);

		// Recupero la categoria por id
		ArrayList<CategoriasPojo> categoriasID = productosEjb.leerCategoriaId(id);
		// Recupero los productod por el id de la categoria
		ArrayList<ProductosTiendaPojo> productosCategoriaid = productosEjb.leerProductoidCategoria(id);
		// Recupero todos los productos por el id de la categoria
		ProductosTiendaPojo contarProd = productosEjb.contarProductosporCategoria(id);
		// Recupero todas la categorias
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		// Recupero todas la marcas
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		// Cuento los porductos del carro
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		// Paso los atributos
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("id", id);
		request.setAttribute("categoriasID", categoriasID);
		request.setAttribute("productosCategoriaid", productosCategoriaid);
		request.setAttribute("contarProd", contarProd);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);
		request.setAttribute("contarCarro", contarCarro);

		// Comprueblo el valor de pantalla
		if (pantalla == null || pantalla.equals("D")) {
			rsPagina.forward(request, response);
			loggerNormal.debug("Sin problemas redirigiendo a diurno");
		} else {
			rsNocturna.forward(request, response);
			loggerNormal.debug("Sin problemas redirigiendo a nocturno");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
