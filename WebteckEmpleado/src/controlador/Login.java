package controlador;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	UsuarioEjb usuariosEJB;

	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	SesionEjb sesionesEJB;

	/**
	 * Método que trata las peticiones GET que llegan al servlet
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Pagina.jsp");
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Login.jsp");
		// Intentamos obtener el usuario de la sesión
		UsuarioPojo usuario = sesionesEJB.usuariosLogeado(session);

		if (usuario != null) {
			// Ya está logeado, lo redirigimos a la principal
			rsPagina.forward(request, response);

		} else {
			// No está logeado, mostramos página de login
			request.setAttribute("usuario", usuario);
			request.setAttribute("error", error);

			rs.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// recojo la request del valor del formulario
		// Luego compruebo que no sea nula
		String user = request.getParameter("usuario");
		String paswd = request.getParameter("password");

		if (session != null) {
			// Si tenemos sesión, miramos si tenemos usuario en la sesión
			UsuarioPojo usuario = null;

			try {
				usuario = usuariosEJB.leerDatosEmpleado(user, paswd);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// Si no tenemos usuario, es una sesión no válida y la invalidamos
			if (usuario == null) {
				sesionesEJB.logoutUsuario(session);
				response.sendRedirect("Login?error=hay");

			} else {
				// Añadimos el usuario a la sesión
				session = request.getSession(true);
				sesionesEJB.loginUsuario(session, usuario);
				// Lo redirigimos a la página principal
				response.sendRedirect("Pagina");

			}
		}
	}

}
