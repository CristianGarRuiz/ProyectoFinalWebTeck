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

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.Ejb.UsuariosEjb;

@WebServlet("/claveRegistro")
public class claveRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");

	@EJB
	UsuariosEjb usuarioEJB;

//Este metodo activa el usuario por el su codigo que se le envia al correo
	// Luego lo redirige a pagina
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Principal.jsp");
		try {
			usuarioEJB.ActivarUsuario(Integer.parseInt(request.getParameter("codigo")));

			rs.forward(request, response);
		} catch (NumberFormatException e) {
			loggerError
					.error(e.getMessage() + "Erro al activar el usuario y hacer la dereccion del usuario a la pagina");
		} catch (SQLException e) {
			loggerError
					.error(e.getMessage() + "Error al activar el usuario y hacer la dereccion del usuario a la pagina");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
