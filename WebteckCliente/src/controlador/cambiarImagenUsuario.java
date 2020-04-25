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
import modelo.Ejb.ImagenesEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/cambiarImagenUsuario")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class cambiarImagenUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productosEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	ImagenesEjb imagenesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/cambiarImagen.jsp");

		request.setAttribute("error", error);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("usuario", usuario);

		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		ServletContext context = getServletContext();
		RequestDispatcher rsPagina = getServletContext().getRequestDispatcher("/Principal.jsp");

		String emailUsuario = usuario.getEmailUsuario();
		

		if (emailUsuario != null) {
			UsuariosPojo usu = new UsuariosPojo();
			usu.setEmailUsuario(emailUsuario);
			usu.setFoto(imagenesEjb.guardarImagen(request, context));
			usuarioEjb.updateFoto(usu);
			rsPagina.forward(request, response);
		} else {

			response.sendRedirect("error?Hay");

		}
	}

}
