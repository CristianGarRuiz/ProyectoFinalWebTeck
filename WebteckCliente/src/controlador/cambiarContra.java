package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/cambiarContra")
public class cambiarContra extends HttpServlet {
	private static final long serialVersionUID = 1L;
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


		String password = request.getParameter("password");
		String emailUsuario = request.getParameter("emailUsuario");

		if (password != null && emailUsuario != null) {

			UsuariosPojo usu = new UsuariosPojo();
			usu.setEmailUsuario(emailUsuario);
			usu.setPassword(password);

			usuariosEJB.updateContraseña(usu);
			rsPagina.forward(request, response);

		} else {
			
			response.sendRedirect("error?=Hay");

		}

	}

}
