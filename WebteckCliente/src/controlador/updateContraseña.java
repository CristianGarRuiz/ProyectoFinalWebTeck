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

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.Ejb.GeneradoresEnlaceEjb;
import modelo.Ejb.MailsEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/updateContraseña")
public class updateContraseña extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	// EJBS utilizados
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

		// Recojo la session
		HttpSession session = request.getSession();
		// estancio la variable error
		String error = request.getParameter("error");
		// Asocio la session al usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// Recupero el valor de pantalla de la sesion
		String pantalla = sesionesEjb.getPantalla(session);

		// Dispacher de redireccion de la pagina a un otro jsp
		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/updateContraseña.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/updateContraseñaNocturna.jsp");

		// Paso los atributos
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("error", error);

		// Comprueblo la el valor de pantalla
		if (pantalla == null || pantalla.equals("D")) {
			rsPagina.forward(request, response);
			loggerNormal.debug("Entrando correctamente");
		} else {
			rsNocturna.forward(request, response);
			loggerNormal.debug("Entrando correctamente");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Dispcher de la redireccion al jsp
		RequestDispatcher rsCorreo = getServletContext().getRequestDispatcher("/correoContraseña.jsp");
		UsuariosPojo usu = new UsuariosPojo();
		// Recojo el atributo
		request.setAttribute("usuario", usu);

		// Recupero el enlace del ejb
		String enlace = generadorEnlaceEJB.generarEnlaceUpdateContraseña();
		// Paso el atributo
		request.setAttribute("enlace", enlace);

		// COmpruebo el email de usuario no sea nulo
		if (request.getParameter("emailUsuario") != null) {
			usu.setEmailUsuario(request.getParameter("emailUsuario"));
		}

		try {
			// Envio el email para la modficacion de la contraseña
			mailEJB.sendMail(usu.getEmailUsuario(), enlace, "Update Contraseña");
			rsCorreo.forward(request, response);
			loggerNormal.debug("se ha modficado la contraseña correctamente");

		} catch (MessagingException e) {
			loggerError.error("Error la modificar a contraseña");
		}

	}

}
