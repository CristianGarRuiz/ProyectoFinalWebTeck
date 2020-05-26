package controlador;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import modelo.Ejb.GeneradoresEnlaceEjb;
import modelo.Ejb.ImagenesEjb;
import modelo.Ejb.MailsEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/LogeaUsuarios")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class LogeaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");

	@EJB
	UsuariosEjb usuariosEJB;

	@EJB
	SesionesEjb sesionesEJB;

	@EJB
	GeneradoresEnlaceEjb generadorEnlaceEJB;

	@EJB
	MailsEjb mailEJB;

	@EJB
	ImagenesEjb imagenesEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		String error1 = request.getParameter("error1");
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Pagina.jsp");
		RequestDispatcher rsLogear = getServletContext().getRequestDispatcher("/Logear.jsp");
		// Intentamos obtener el usuario de la sesión
		UsuariosPojo usuario = sesionesEJB.usuariosLogeado(session);

		// recojo la request de las variables instanciadas
		request.setAttribute("usuario", usuario);
		request.setAttribute("error", error);
		request.setAttribute("error1", error1);

		if (usuario != null) {
			// Ya está logeado, lo redirigimos a la principal
			rs.forward(request, response);
		} else {
			// Mostramos la página y le pasamos null porque no hay errores
			rsLogear.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuariosPojo usu = new UsuariosPojo();
		request.setAttribute("usuario", usu);
		RequestDispatcher rsCorreo = getServletContext().getRequestDispatcher("/InfoCorreo.jsp");
		ServletContext context = getServletContext();

		// Compruebo que los datos no sean nulos
		if (request.getParameter("emailUsuario") != null) {
			usu.setEmailUsuario(request.getParameter("emailUsuario"));
		}
		// compruebo que los datos no sean nulos

		if (request.getParameter("nombre") != null) {
			usu.setNombre(request.getParameter("nombre"));
		}

		// compruebo que los datos no sean nulos
		if (request.getParameter("usuario") != null) {
			usu.setUsuario(request.getParameter("usuario"));
		}

		// compruebo que los datos no sean nulos
		if (request.getParameter("password") != null) {
			usu.setPassword(request.getParameter("password"));
		}
		// llamo un ejb que tiene la logica de la imagen con metodo que creado
		usu.setFoto(imagenesEJB.guardarImagen(request, context));

		// poongo manualmente el activado del usuario en n
		usu.setActivado("n");

		try {
			String Nombreusuario = request.getParameter("usuario");
			String emailUsuario = request.getParameter("emailUsuario");
			UsuariosPojo usuar = null;
			UsuariosPojo emai = null;

			usuar = usuariosEJB.comprobarnombreUsuario(Nombreusuario);
			emai = usuariosEJB.comprobaremailUsuario(emailUsuario);

			if ((usuar == null) && (emai == null)) {

				// codigo lo asocio cada vez que se registra un usuario
				int codigo = usuariosEJB.añadirUsuario(usu);

				request.setAttribute("codigo", codigo);
				// esta variable enlace hace referencia ejb con metodo que genera un enlace y le
				// paso el codigo
				String enlace = generadorEnlaceEJB.generarEnlace(codigo);
				request.setAttribute("enlace", enlace);
				// este ejb enviar elcorreo con email del usuario y el enlace
				mailEJB.sendMail(usu.getEmailUsuario(), enlace, "Codigo Activacion ");
				// Creo la pagina
				rsCorreo.forward(request, response);

			} else {
				response.sendRedirect("LogeaUsuarios?error1=hay");

			}

		} catch (Exception e) {
			loggerError.error(e.getMessage() + "Error en añadirusuario / enlace de codigo/enviar el correo ");
			response.sendRedirect("LogeaUsuarios?error=Hay");
		}

	}

}