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
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/porMarca")
public class porMarca extends HttpServlet {
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

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/mostrarProductoporMarca.jsp");
		RequestDispatcher rsNocturna = getServletContext()
				.getRequestDispatcher("/mostrarProductoporCategoriaNocturno.jsp");

		String eseid = request.getParameter("id");

		Integer id = Integer.valueOf(eseid);

		ArrayList<MarcasPojo> MarcasID = productosEjb.leerMarcasId(id);
		ArrayList<ProductosTiendaPojo> productosMarcaid = productosEjb.leerProductoidMarca(id);
		ProductosTiendaPojo contarProds = productosEjb.contarProductosporMarca(id);
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();

		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("id", id);
		request.setAttribute("MarcasID", MarcasID);
		request.setAttribute("productosMarcaid", productosMarcaid);
		request.setAttribute("contarProds", contarProds);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);

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