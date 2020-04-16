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
import modelo.Ejb.VentaEjb;
import modelo.Pojo.CategoriasPojo;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String error = request.getParameter("error");

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/mostrarProductoporCategoria.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/mostrarProductoporCategoriaNocturno.jsp");

		String eseid = request.getParameter("id");

		Integer id = Integer.valueOf(eseid);

		ArrayList<CategoriasPojo> categoriasID = productosEjb.leerCategoriaId(id);
		ArrayList<ProductosTiendaPojo> productosCategoriaid = productosEjb.leerProductoidCategoria(id);
		ProductosTiendaPojo contarProd = productosEjb.contarProductosporCategoria(id);

		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("id", id);
		request.setAttribute("categoriasID", categoriasID);
		request.setAttribute("productosCategoriaid", productosCategoriaid);
		request.setAttribute("contarProd", contarProd);

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
