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
import modelo.Ejb.ImageneEjb;
import modelo.Ejb.SesionEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Pojo.UsuarioPojo;

@WebServlet("/LogearUsuarios")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class LogearUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	@EJB
	UsuarioEjb usuariosEJB;

	@EJB
	SesionEjb sesionesEJB;

	@EJB
	ImageneEjb imagenesEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Pagina.jsp");
		RequestDispatcher rsLogear = getServletContext().getRequestDispatcher("/Logear.jsp");
		// Intentamos obtener el usuario de la sesión
		UsuarioPojo usuario = sesionesEJB.usuariosLogeado(session);

		// recojo la request de las variables instanciadas
		request.setAttribute("usuario", usuario);
		request.setAttribute("error", error);

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
		UsuarioPojo usu = new UsuarioPojo();
		request.setAttribute("usuario", usu);
		RequestDispatcher rsCorreo = getServletContext().getRequestDispatcher("/InfoRegistro.jsp");
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
		
		//Vuelvo a recoger los valores de email y usuario los estancia en 
		//una variable y los comprobare
		String emailUsuario=request.getParameter("emailUsuario");
		UsuarioPojo email = null;
		String NombreUsuario =request.getParameter("usuario") ;
		UsuarioPojo nom = null;

		try {
			//Aqui compruebo con dos ejb que los email y los nombre de usuario
			//no existe en bd ya 
			email=usuariosEJB.comprobarEmailUsarioEmpleado(emailUsuario);
			nom=usuariosEJB.comprobarUsuarioEmpleado(NombreUsuario);

			//Si los datos son nulos significa que no existen empleados con esos datos 
			// y luego inserto
			if((email==null) && (nom==null)) {
				usuariosEJB.AñadirEmpleado(usu);
		         
				rsCorreo.forward(request, response);
				
				loggerNormal.debug("Añadidoo el empleado sin problemas");
				
			}else {
				response.sendRedirect("LogearUsuarios?error=hay");
				
			}
			
			
			

		} catch (Exception e) {
			loggerError.error(e.getMessage() + "Error en añadirusuario ");
			response.sendRedirect("LogearUsuarios?error=Hay");
		}
	}

}