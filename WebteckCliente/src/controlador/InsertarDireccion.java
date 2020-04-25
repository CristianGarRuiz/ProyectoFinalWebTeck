package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Ejb.DireccionesEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.DireccionesPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/InsertarDireccion")
public class InsertarDireccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productoEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	DireccionesEjb direccionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String error = request.getParameter("error");

		String emailUsuario = usuario.getEmailUsuario();
		String direccion = request.getParameter("direccion");
		String vivienda = request.getParameter("vivienda");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String codigo = request.getParameter("codigoPostal");
		Integer codigoPostal = Integer.valueOf(codigo);

		request.setAttribute("error", error);
		request.setAttribute("emailUsuario", emailUsuario);
		request.setAttribute("vivienda", vivienda);
		request.setAttribute("direccion", direccion);
		request.setAttribute("localidad", localidad);
		request.setAttribute("provincia", provincia);
		request.setAttribute("codigoPostal", codigoPostal);
		request.setAttribute("pantalla", pantalla);

		if (codigo != null && emailUsuario != null && localidad != null && provincia != null && vivienda != null
				&& direccion != null) {

			DireccionesPojo d = new DireccionesPojo();

			d.setCodigoPostal(codigoPostal);
			d.setDireccion(direccion);
			d.setEmailUsuario(emailUsuario);
			d.setLocalidad(localidad);
			d.setProvincia(provincia);
			d.setVivienda(vivienda);

			direccionesEjb.añadirDireccion(d);

			response.sendRedirect("Principal");

			// Comentar

		} else {
			response.sendRedirect("error?Hay");
		}
	}

}
