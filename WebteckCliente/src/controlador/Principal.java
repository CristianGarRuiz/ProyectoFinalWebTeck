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

import modelo.Ejb.PreguntasEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	PreguntasEjb preguntasEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		
		String pantalla = sesionesEjb.getPantalla(session);
		
		String error = request.getParameter("error");
		ArrayList<ProductosTiendaPojo> productosTienda = productosEjb.leerTotalProductos();
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		ArrayList<ProductosTiendaPojo> productosMedia = productosEjb.leerTotalProductosMedia();

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Principal.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/PrincipalNocturna.jsp");

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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String titulo = request.getParameter("titulo");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/ProductosBusqueda.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/PaginaNocturno.jsp");

		request.setAttribute("usuario", usuario);
		request.setAttribute("titulo", titulo);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		// Generamos la página para el usuario y la mostramos

		if (pantalla == null || pantalla.equals("D")) {

			ArrayList<ProductosTiendaPojo> Busquedaproducto = productosEjb.BuscarProductoporNombreTienda(titulo);

			request.setAttribute("Busquedaproducto", Busquedaproducto);
			rs.forward(request, response);

		} else {
			ArrayList<ProductosTiendaPojo> Busquedaproducto = productosEjb.BuscarProductoporNombreTienda(titulo);
			request.setAttribute("Busquedaproducto", Busquedaproducto);
			rsNocturna.forward(request, response);

		}

	}

}
