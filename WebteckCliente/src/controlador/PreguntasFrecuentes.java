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
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.PreguntasPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/PreguntasFrecuentes")
public class PreguntasFrecuentes extends HttpServlet {
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
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String error = request.getParameter("error");
		String emailUsuario = sesionesEjb.getEmailUsuario(session);

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Preguntas.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/PrincipalNocturna.jsp");
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
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

		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String pregunta = request.getParameter("pregunta");
		String emailUsuario = sesionesEjb.getEmailUsuario(session);
		
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();
		CarritosPojo contarCarro = carritoEjb.contarProductosCarrito(emailUsuario);

		RequestDispatcher rs1 = getServletContext().getRequestDispatcher("/Preguntas.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/Preguntas.jsp");

		request.setAttribute("usuario", usuario);
		request.setAttribute("pregunta", pregunta);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);
		request.setAttribute("contarCarro", contarCarro);
		if (pantalla == null || pantalla.equals("D")) {

			if(pregunta != null) {
			
			ArrayList<PreguntasPojo> preguntas = preguntasEjb.RespuestaPreguntas(pregunta);

			request.setAttribute("preguntas", preguntas);
			rs1.forward(request, response);
			
			}else {
				
				response.sendRedirect("PreguntasFrecuentes?error= No hay");
				
			}

		} else {
			
			if(pregunta != null) {
			ArrayList<PreguntasPojo> preguntas = preguntasEjb.RespuestaPreguntas(pregunta);
			request.setAttribute("preguntas", preguntas);
			rsNocturna.forward(request, response);
			
			}else{
				response.sendRedirect("PreguntasFrecuentes?error= No hay");
				
			}

		}

	}

}
