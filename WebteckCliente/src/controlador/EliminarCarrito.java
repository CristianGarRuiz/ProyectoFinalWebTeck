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
import modelo.Pojo.UsuariosPojo;

@WebServlet("/EliminarCarrito")
public class EliminarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productoEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	CarritosEjb carritoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String error = request.getParameter("error");
		String emailUsuario = usuario.getEmailUsuario();
		String id = request.getParameter("id");
		Integer idProducto = Integer.valueOf(id);

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emailUsuario", emailUsuario);
	

		try {

			carritoEjb.eliminarProductoCarro(idProducto, emailUsuario);
		} catch (Exception e) {
//			loggerError.error(e.getMessage() + "Error al eliminar una direccion de un usuario con el email propio");

		}
//		loggerNormal.debug("Eliminado Correctamente");
		response.sendRedirect("VerCarrito");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
