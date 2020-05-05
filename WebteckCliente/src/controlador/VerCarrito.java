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

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);

		String pantalla = sesionesEjb.getPantalla(session);
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		String error = request.getParameter("error");

		if (emailUsuario == null) {

			ArrayList<CarritosPojo> productosCarrito = carritoEjb.leerCarrito(emailUsuario);
			ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
			ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
			CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);
			RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Carrito.jsp");
			RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/CarritoNocturna.jsp");
			
			CarritosPojo totalCarro = carritoEjb.sumaCarro(emailUsuario);

			request.setAttribute("usuario", usuario);
			request.setAttribute("pantalla", pantalla);
			request.setAttribute("productosCarrito", productosCarrito);
			request.setAttribute("error", error);
			request.setAttribute("categorias", categorias);
			request.setAttribute("marcas", marcas);
			request.setAttribute("contarCarro", contarCarro);
			request.setAttribute("totalCarro", totalCarro);


			if (pantalla == null || pantalla.equals("D")) {
				rsPagina.forward(request, response);
			} else {
				rsNocturna.forward(request, response);
			}

		} else {

			ArrayList<CarritosPojo> productosCarrito = carritoEjb.leerCarrito(emailUsuario);
			ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
			ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
			CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);
			ArrayList<DireccionesPojo> direccionesUsuarios = direccionesEjb.leerDatosporMail(emailUsuario);
			
			CarritosPojo totalCarro = carritoEjb.sumaCarro(emailUsuario);

			RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Carrito.jsp");
			RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/CarritoNocturna.jsp");

			request.setAttribute("usuario", usuario);
			request.setAttribute("pantalla", pantalla);
			request.setAttribute("productosCarrito", productosCarrito);
			request.setAttribute("error", error);
			request.setAttribute("categorias", categorias);
			request.setAttribute("marcas", marcas);
			request.setAttribute("contarCarro", contarCarro);
			request.setAttribute("direccionesUsuarios", direccionesUsuarios);
			request.setAttribute("totalCarro", totalCarro);

			if (pantalla == null || pantalla.equals("D")) {
				rsPagina.forward(request, response);
			} else {
				rsNocturna.forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
