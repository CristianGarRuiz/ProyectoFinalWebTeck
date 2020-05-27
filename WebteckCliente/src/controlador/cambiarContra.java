package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/cambiarContra")
public class cambiarContra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	@EJB
	UsuariosEjb usuariosEJB;

	@EJB
	SesionesEjb sesionesEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/cambiarContra.jsp");

		rsPagina.forward(request, response);

		response.sendRedirect("cambiarContra.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Principal.jsp");

		// recupero los valores de jsp del formulario
		String password = request.getParameter("password");
		String emailUsuario = request.getParameter("emailUsuario");

		// si no son nulos esos valores

		if (password != null && emailUsuario != null) {

			UsuariosPojo usu = new UsuariosPojo();
			usu.setEmailUsuario(emailUsuario);
			usu.setPassword(password);

			// llamo al ejb y moidfico la contraseña
			usuariosEJB.updateContraseña(usu);
			rsPagina.forward(request, response);
			loggerNormal.debug("se cambiado la contraseña correctamente");

		} else {

			response.sendRedirect("error?=Hay");
			loggerError.error("error al cambiar la contraseña");

		}

	}

}
