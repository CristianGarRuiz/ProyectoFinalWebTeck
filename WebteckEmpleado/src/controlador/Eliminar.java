package controlador;

import java.io.IOException;

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
import modelo.Pojo.UsuarioPojo;

@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	/**
	 * Creo los EJB Para recoge los metodos que me haran falta
	 */
	
	@EJB
	ProductoEjb productoEJb;
	@EJB
	SesionEjb sesionesEjb;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Busco session de un usuario si hay
		HttpSession session = request.getSession();
		//Creo una estancia del usuario pojo y llamos la ejb para comprobar y devuelva
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		//Creo el dispacher para redirigir a la pagina
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Pagina.jsp");

		try {
			//reogo el parametro de la id 
			String identificador = request.getParameter("id");

			//Convertio el String un int
			int id = Integer.parseInt(identificador);

			//La id que recibo la borro con el ejb 
			productoEJb.eliminarProducto(id);
			//recojo las estancias creadas
			request.setAttribute("id", id);
			request.setAttribute("usuario", usuario);
		} catch (Exception e) {
			loggerError.error("Error al eliminar el jugador con la id ");
			loggerNormal.debug("Eliminado a jugador por la id ");
		}
		//renvio a la pagina
		rs.forward(request, response);
	}

}
