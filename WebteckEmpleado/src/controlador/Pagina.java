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

	// Los ejbs utilizados en la Principal
	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;

	@EJB
	ProductoEjb productoEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//Recojo la session si existe 
		HttpSession session = request.getSession();
		//Compruebo el usuario que abierto una session
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		//Recupero un arrayList con todos los productos
		ArrayList<ProductoPojo> producto;

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Pagina.jsp");

		try {
			//Recojo el arrayList con el Ejb
			producto = productoEjb.leerTotalProductos();
			//recojo los atributos de usuario y producto
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
