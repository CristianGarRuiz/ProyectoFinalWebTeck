package controlador;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Ejb.CarritosEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/AñadirCarrito")
public class AñadirCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String error = request.getParameter("error");
		String id = request.getParameter("id");
		Integer indentificador = Integer.valueOf(id);

		int idProducto = indentificador;
		String emailUsuario = usuario.getEmailUsuario();

		request.setAttribute("error", error);
		request.setAttribute("idProducto", idProducto);
		request.setAttribute("emailUsuario", emailUsuario);

		if (id != null && emailUsuario != null) {

			CarritosPojo car = new CarritosPojo();

			car.setEmailUsuario(emailUsuario);
			car.setIdProducto(idProducto);

			carritoEjb.añadirProductoCarro(car);

			response.sendRedirect("Principal");

		} else {

			response.sendRedirect("error?Hay");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
