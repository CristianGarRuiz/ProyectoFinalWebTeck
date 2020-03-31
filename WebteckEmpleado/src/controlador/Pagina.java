package controlador;

import java.io.IOException;
import java.sql.SQLException;
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
import modelo.Pojo.ProductoPojo;
import modelo.Pojo.UsuarioPojo;

@WebServlet("/Pagina")
public class Pagina extends HttpServlet {
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
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		ArrayList<ProductoPojo> producto;

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Pagina.jsp");

		try {
			producto = productoEjb.leerTotalProductos();
			request.setAttribute("usuario", usuario);
			request.setAttribute("producto", producto);
		} catch (SQLException e) {
			loggerError.error( e.getMessage() + "Error al mostrar la pagina principal");
			
		}
		loggerNormal.debug("Entrando en Principal sin fallos");
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
