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
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/FiltroBusquedasPrincipal")
public class FiltroBusquedasPrincipal extends HttpServlet {
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		String eseid = request.getParameter("Categorias");
		Integer idCategoria = Integer.valueOf(eseid);


		String esid = request.getParameter("Marcas");
		Integer idMarca = Integer.valueOf(esid);

		String eseprecio = request.getParameter("precioIni");
		Integer precioIni = Integer.valueOf(eseprecio);
		
		
		String eseprecioFinal = request.getParameter("precioFin");
		Integer precioFin = Integer.valueOf(eseprecioFinal);
		

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/FiltroBusqueda.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/FiltroBusquedaNocturna.jsp");
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);
		ProductosTiendaPojo contarProd = productosEjb.contarProductosporCategoria(idCategoria);

		request.setAttribute("usuario", usuario);
		request.setAttribute("idMarca", idMarca);
		request.setAttribute("idCategoria", idCategoria);
		request.setAttribute("precioIni", precioIni);
		request.setAttribute("precioFin", precioFin);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("contarCarro", contarCarro);
		request.setAttribute("contarProd", contarProd);
		// Generamos la página para el usuario y la mostramos

		if (pantalla == null || pantalla.equals("D")) {

			// ira el metodo con que llama al filtro y muestra un array de productos por los valores de busqueda
			
			ArrayList<ProductosTiendaPojo> Busquedaproducto = productosEjb.leerProductosFiltro(idMarca, idCategoria, precioIni, precioFin);

			request.setAttribute("Busquedaproducto", Busquedaproducto);
			rs.forward(request, response);

		} else {
			ArrayList<ProductosTiendaPojo> Busquedaproducto = productosEjb.leerProductosFiltro( idMarca, idCategoria, precioIni, precioFin);
			request.setAttribute("Busquedaproducto", Busquedaproducto);
			rsNocturna.forward(request, response);

		}

	}
}
