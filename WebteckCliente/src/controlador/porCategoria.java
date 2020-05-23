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

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String error = request.getParameter("error");
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/mostrarProductoporCategoria.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/mostrarProductoporCategoriaNocturna.jsp");

		String eseid = request.getParameter("id");

		Integer id = Integer.valueOf(eseid);

		ArrayList<CategoriasPojo> categoriasID = productosEjb.leerCategoriaId(id);
		ArrayList<ProductosTiendaPojo> productosCategoriaid = productosEjb.leerProductoidCategoria(id);
		ProductosTiendaPojo contarProd = productosEjb.contarProductosporCategoria(id);
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

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

		if (pantalla == null || pantalla.equals("D")) {
			rsPagina.forward(request, response);
		} else {
			rsNocturna.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
