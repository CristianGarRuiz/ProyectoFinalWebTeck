package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.Ejb.ProductoEjb;
import modelo.Ejb.SesionEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Pojo.BusquedaPojo;
import modelo.Pojo.UsuarioPojo;

@WebServlet("/BuscarProducto")
public class BuscarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;

	@EJB
	ProductoEjb productoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/BusquedaProducto.jsp");
		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// creoa la variable inico y fin para las fecha
		String titulo = request.getParameter("titulo");
		String error = null;
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		// dispache para la pagina
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/BusquedaProducto.jsp");

		try {
			// el arraylist de las estadisticas del ejb con las fecha pasadas
		   ArrayList<BusquedaPojo> productos = productoEjb.BuscarProductoporNombre(titulo);

			// recogo los atributos de las estancias que he creado
			request.setAttribute("productos", productos);
			request.setAttribute("titulo", titulo);
			request.setAttribute("error", error);
			request.setAttribute("usuario", usuario);
		} catch (Exception e) {
			loggerError.error(e.getMessage() +  "Error al realizar la consultas por nombre");
			
		}

		// los datos que le paso no son nulos pues redirigo a la pagina con los datos
		if (titulo != null ) {
			rs.forward(request, response);
			loggerNormal.debug(" Realizando la consultas sin fallos");

		} else {
			// sino dirigo con el error
			response.sendRedirect("BuscarProducto?error=hay");

		}

	}

}
