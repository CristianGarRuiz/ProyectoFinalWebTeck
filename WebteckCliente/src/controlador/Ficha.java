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

import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Ejb.ValoracionesEjb;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;
import modelo.Pojo.ValorcionesPojo;

@WebServlet("/Ficha")
public class Ficha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productoEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	ValoracionesEjb valoracionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String error = request.getParameter("error");
		String id = request.getParameter("id");
		Integer indentificador = Integer.valueOf(id);

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/FichaProducto.jsp");

		ArrayList<ProductosTiendaPojo> productosTienda = productoEjb.leerProducto(indentificador);
		ArrayList<ValorcionesPojo> comentariosProd = valoracionesEjb.leerComentario(indentificador);
		ArrayList<ValorcionesPojo> valoracionesProd = valoracionesEjb.leerValoracion(indentificador);

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("productosTienda", productosTienda);
		request.setAttribute("comentariosProd", comentariosProd);
		request.setAttribute("valoracionesProd", valoracionesProd);

		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String error = request.getParameter("error");
		String id = request.getParameter("id");
		Integer indentificador = Integer.valueOf(id);



		int idProducto = indentificador;
		String emailUsuario = usuario.getEmailUsuario();

		String valora = request.getParameter("valoraciones");
		Integer valoraciones = Integer.valueOf(valora);

		String comentario = request.getParameter("comentario");

		request.setAttribute("error", error);
		request.setAttribute("idProducto", idProducto);
		request.setAttribute("emailUsuario", emailUsuario);
		request.setAttribute("valoraciones", valoraciones);
		request.setAttribute("comentario", comentario);

		if (valora != null) {
			ValorcionesPojo v = new ValorcionesPojo();
			
			v.setValoraciones(valoraciones);
			v.setEmailUsuario(emailUsuario);
			v.setIdProducto(idProducto);
			
			valoracionesEjb.añadirValoracion(v);
			
			

		} else {
			response.sendRedirect("error?Hay");
		}

		if (comentario != null) {

			ValorcionesPojo v = new ValorcionesPojo();

			v.setComentarios(comentario);
			v.setEmailUsuario(emailUsuario);
			v.setIdProducto(idProducto);

			valoracionesEjb.añadirComentario(v);

			response.sendRedirect("Principal");

			// Comentar

		} else {
			response.sendRedirect("error?Hay");
		}
	}

}
