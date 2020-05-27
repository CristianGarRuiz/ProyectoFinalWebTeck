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

@WebServlet("/porMarca")
public class porMarca extends HttpServlet {
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

		// Recupero la session
		HttpSession session = request.getSession();
		// Asocio la sesion al usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recupero el valor de pantalla de la session
		String pantalla = sesionesEjb.getPantalla(session);
		// Estancion la variable error
		String error = request.getParameter("error");
		// recupero el email de la sesion
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// los dispacher de un jsp o otro
		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/mostrarProductoporMarca.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/mostrarProductoporMarcaNocturna.jsp");

		// Recupero la id
		String eseid = request.getParameter("id");

		// la paso a integer
		Integer id = Integer.valueOf(eseid);

		// Recojo los id de las marcas
		ArrayList<MarcasPojo> MarcasID = productosEjb.leerMarcasId(id);

		// Recojo los porductos por id de marca
		ArrayList<ProductosTiendaPojo> productosMarcaid = productosEjb.leerProductoidMarca(id);

		// cuento los productos por id de la marca
		ProductosTiendaPojo contarProds = productosEjb.contarProductosporMarca(id);

		// Recupero todas las categorias
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();

		// Recupero todas las marcas
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();

		// cuento los productos del carro
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		// Paso los atributos
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("id", id);
		request.setAttribute("MarcasID", MarcasID);
		request.setAttribute("productosMarcaid", productosMarcaid);
		request.setAttribute("contarProds", contarProds);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);
		request.setAttribute("contarCarro", contarCarro);

		// Compruebo el valor de pantalla
		if (pantalla == null || pantalla.equals("D")) {
			rsPagina.forward(request, response);
			loggerNormal.debug("Sin problemas al entrar en diurno");
		} else {
			rsNocturna.forward(request, response);
			loggerNormal.debug("Sin problemas al entrar en nocturno");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
