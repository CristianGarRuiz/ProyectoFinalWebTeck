package controlador;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Ejb.SesionEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Pojo.UsuarioPojo;

@WebServlet("/OpcionesEliminarusu")
public class OpcionesEliminarusu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ejb de usuario
	 */
	@EJB
	UsuarioEjb usuarioEjb;

	/**
	 * ejb de la sesion
	 */
	@EJB
	SesionEjb sesionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Eliminar.jsp");

		// creo una estancia del usuario y recojo la session del usuario

		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);

		// recojo la request de las instancias creadas
		request.setAttribute("usuario", usuario);

		rs.forward(request, response);

	}
}
