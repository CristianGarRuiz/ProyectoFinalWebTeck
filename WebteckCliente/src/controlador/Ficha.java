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
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Ejb.ValoracionesEjb;
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;
import modelo.Pojo.ValorcionesPojo;

@WebServlet("/Ficha")
public class Ficha extends HttpServlet {
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

		// Recupero la sesion
		HttpSession session = request.getSession();
		// asocio la sesion con el usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recogo el valor de pantalla de la session
		String pantalla = sesionesEjb.getPantalla(session);
		// Recojo el valor de email del usuario de la session
		String emailUsuario = sesionesEjb.getEmailUsuario(session);
		// Creo la estancia de la variable erro que recojo
		String error = request.getParameter("error");
		// Creo la estancia de la variable id que recojo
		String id = request.getParameter("id");
		// Paso la variable id a integer
		Integer indentificador = Integer.valueOf(id);

		// Los dispaches de cada jsp
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/FichaProducto.jsp");
		RequestDispatcher rsN = getServletContext().getRequestDispatcher("/FichaProductoNocturna.jsp");

		// Recupero los porductos de la tienda
		ArrayList<ProductosTiendaPojo> productosTienda = productoEjb.leerProducto(indentificador);
		// recupero los comentarios del productos
		ArrayList<ValorcionesPojo> comentariosProd = valoracionesEjb.leerComentario(indentificador);
		// recupero los valoraciones del productos
		ArrayList<ValorcionesPojo> valoracionesProd = valoracionesEjb.leerValoracion(indentificador);
		// recupero las categorias
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		// recupero las marcas
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		// recupero la cantida de pordcutos en el carro
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		// Paso los atributos
		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("productosTienda", productosTienda);
		request.setAttribute("comentariosProd", comentariosProd);
		request.setAttribute("valoracionesProd", valoracionesProd);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);
		request.setAttribute("contarCarro", contarCarro);

		// Segun el valor de pantalla redirigo a un jsp o a otro jsp
		if (pantalla == null || pantalla.equals("D")) {
			rs.forward(request, response);
		} else {
			rsN.forward(request, response);
		}

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

		// recupero el valor de valoracion
		String valora = request.getParameter("valoraciones");
		// lo paso a integer
		Integer valoraciones = Integer.valueOf(valora);

		// recupero el comentario
		String comentario = request.getParameter("comentario");

		// Paso los atributos
		request.setAttribute("error", error);
		request.setAttribute("idProducto", idProducto);
		request.setAttribute("emailUsuario", emailUsuario);
		request.setAttribute("valoraciones", valoraciones);
		request.setAttribute("comentario", comentario);
		request.setAttribute("pantalla", pantalla);

		// Compruebo que no sea nulo
		if (valora != null) {
			ValorcionesPojo v = new ValorcionesPojo();

			v.setValoraciones(valoraciones);
			v.setEmailUsuario(emailUsuario);
			v.setIdProducto(idProducto);

			// Añado la valoracion
			valoracionesEjb.añadirValoracion(v);

			loggerNormal.debug("Se añadido la valroacion correctamente");
		} else {
			response.sendRedirect("error?Hay");
			loggerError.error("No se ha podido insertar la valoracion");
		}

		// Compruebo que no sea nulo
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
