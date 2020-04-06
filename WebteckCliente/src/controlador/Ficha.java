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
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/Ficha")
public class Ficha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productoEjb;

	@EJB
	SesionesEjb sesionesEjb;

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

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("productosTienda", productosTienda);

		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String error = request.getParameter("error");

		ProductosTiendaPojo productosTiendaPojo = null;

		int idProducto = productosTiendaPojo.getId();
		String emailUsuario = usuario.getEmailUsuario();

		String valora = request.getParameter("valoracion");
		Integer valoracion = Integer.valueOf(valora);

		String comentario = request.getParameter("comentario");
		
		request.setAttribute("error",error);
		request.setAttribute("idProducto",idProducto);
		request.setAttribute("emailUsuario",emailUsuario);
		request.setAttribute("valoracion",valoracion);
		request.setAttribute("comentario",comentario);
		

		if (valora != null) {

			// Valorar
		} else {
			response.sendRedirect("error?Hay");
		}

		if (comentario != null) {
			// Comentar

		} else {
			response.sendRedirect("error?Hay");
		}
	}

}
