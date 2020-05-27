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
import modelo.Ejb.DireccionesEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.DireccionesPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/FichaUsuario")
public class FichaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	// EJBS utilizados

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productoEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	DireccionesEjb direccionesEjb;

	@EJB
	ProductosEjb productosEjb;
	@EJB
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recojo la session
		HttpSession session = request.getSession();
		// Asocio la sesion al usuario logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// recupero el valor de pantalla de la sesion
		String pantalla = sesionesEjb.getPantalla(session);
		// estancio la variable error que recojo
		String error = request.getParameter("error");
		// Recupero el email del usuario
		String emailUsuario = usuario.getEmailUsuario();
		// el dispatcher para redirigir al jps
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/OpcPerfil.jsp");

		// recupero la direccion del cliente
		ArrayList<DireccionesPojo> direccionesUsuarios = direccionesEjb.leerDatosporMail(emailUsuario);
		// Recupero los datos del clinete
		ArrayList<UsuariosPojo> datosUsuario = usuarioEjb.leerDatosUsuario(emailUsuario);
		// Recupero la categorias
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		// Recupero las marcas
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		// Cuento la cantida de prodcutos del carro
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		// Paso los atributos
		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("direccionesUsuarios", direccionesUsuarios);
		request.setAttribute("datosUsuario", datosUsuario);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);
		request.setAttribute("contarCarro", contarCarro);

		// Y redirigo
		rs.forward(request, response);
		loggerNormal.debug("hemos entrado sin porblema al perfil del usuario");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
