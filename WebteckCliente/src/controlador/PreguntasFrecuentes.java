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
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.PreguntasPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/PreguntasFrecuentes")
public class PreguntasFrecuentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
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
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// REcupero la session
		HttpSession session = request.getSession();
		// Asocio la sesion al usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// recupero el valor de pantalla de la seesion
		String pantalla = sesionesEjb.getPantalla(session);
		// Estacion la variable error
		String error = request.getParameter("error");
		// Recupero el valor del email de la sesion
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// Dispacher de la redireccion de un o otro jsp
		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Preguntas.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/PrincipalNocturna.jsp");

		// REcupero las categorias
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		// recupero las marcas
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		// Cuento la catindad de productos del carrro
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		// Paso los atributos
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);
		request.setAttribute("contarCarro", contarCarro);

		// Compruebo el valor de pantalla
		if (pantalla == null || pantalla.equals("D")) {
			rsPagina.forward(request, response);
		} else {
			rsNocturna.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recojo la session
		HttpSession session = request.getSession();
		// Estacion la variable error
		String error = request.getParameter("error");
		// Asocio el usuario logeado a la session
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recupero el valor de pantalla de la session
		String pantalla = sesionesEjb.getPantalla(session);
		// recupero el valor de la pregunta
		String pregunta = request.getParameter("pregunta");
		// recupero el email de la session
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		// Recupero todas las categorias
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();

		// Recupero todas las marcas
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();

		// Cuento los porductos del carro
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		// Dispacher de la redireccion de un o otro jsp
		RequestDispatcher rs1 = getServletContext().getRequestDispatcher("/Preguntas.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/Preguntas.jsp");

		// Paso los atributos
		request.setAttribute("usuario", usuario);
		request.setAttribute("pregunta", pregunta);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);
		request.setAttribute("contarCarro", contarCarro);
		// COmpruebo el valor de ppantalla
		if (pantalla == null || pantalla.equals("D")) {

			// Compruebo que la pregunta no sea nula
			if (pregunta != null) {

				// Recupero las preguntas
				ArrayList<PreguntasPojo> preguntas = preguntasEjb.RespuestaPreguntas(pregunta);

				request.setAttribute("preguntas", preguntas);
				rs1.forward(request, response);
				loggerNormal.debug("Sin problemas he redirigo a pagina");
			} else {

				response.sendRedirect("PreguntasFrecuentes?error= No hay");
				loggerError.error("Error en las preguntas frecuentes");

			}

		} else {

			// Comprueblo que la pregunta no sea nula
			if (pregunta != null) {
				// Recupero la lista de preguntas asociada esa
				ArrayList<PreguntasPojo> preguntas = preguntasEjb.RespuestaPreguntas(pregunta);
				request.setAttribute("preguntas", preguntas);
				// Redirigo a la pagina
				rsNocturna.forward(request, response);
				loggerNormal.debug("Sin problemas he redirigo a pagina");

			} else {
				response.sendRedirect("PreguntasFrecuentes?error= No hay");
				loggerError.error("Error en las preguntas frecuentes");

			}

		}

	}

}
