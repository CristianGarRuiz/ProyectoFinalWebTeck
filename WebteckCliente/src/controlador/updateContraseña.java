package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Ejb.GeneradoresEnlaceEjb;
import modelo.Ejb.MailsEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/updateContraseña")
public class updateContraseña extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	MailsEjb mailEJB;

	@EJB
	GeneradoresEnlaceEjb generadorEnlaceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);

		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/updateContraseña.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/updateContraseñaNocturna.jsp");

		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);

		request.setAttribute("error", error);

		if (pantalla == null || pantalla.equals("D")) {
			rsPagina.forward(request, response);
		} else {
			rsNocturna.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rsCorreo = getServletContext().getRequestDispatcher("/correoContraseña.jsp");
		UsuariosPojo usu = new UsuariosPojo();
		request.setAttribute("usuario", usu);

		String enlace = generadorEnlaceEJB.generarEnlaceUpdateContraseña();
		request.setAttribute("enlace", enlace);

		if (request.getParameter("emailUsuario") != null) {
			usu.setEmailUsuario(request.getParameter("emailUsuario"));
		}

		try {
			mailEJB.sendMail(usu.getEmailUsuario(), enlace, "Update Contraseña");
			rsCorreo.forward(request, response);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
