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
import modelo.Pojo.UsuariosPojo;
import modelo.Pojo.VentaPojo;

@WebServlet("/comprasUsuarios")
public class comprasUsuarios extends HttpServlet {
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

		// Recojo la session
		HttpSession session = request.getSession();
		// asocio la session al usuario logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// recupero el valor de pantalal en la session
		String pantalla = sesionesEjb.getPantalla(session);
		// estancion la variable error
		String error = request.getParameter("error");

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/comprasUsuarios.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/comprasUsuariosNocturna.jsp");

		// recupero una lista de categorias
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		// recupero una lista de marcas
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		// recupero el email de usuario
		String emailUsuario = usuario.getEmailUsuario();

		// recupero las ventas de cliente por su correo
		ArrayList<VentaPojo> ventasCliente = ventaEjb.leerProductosporEmail(emailUsuario);
		// cuento los porductos del carrito
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		// y Paso todas las estancias
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("emailUsuario", emailUsuario);
		request.setAttribute("ventasCliente", ventasCliente);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);
		request.setAttribute("contarCarro", contarCarro);

		// Comprueblo el valor de pantalla y segun su valora redirigio a un otro jsp
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
