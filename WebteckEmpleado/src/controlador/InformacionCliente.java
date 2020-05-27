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
import modelo.Ejb.SesionEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Ejb.VentasEjb;
import modelo.Pojo.UsuarioPojo;
import modelo.Pojo.VentasPojo;

@WebServlet("/InformacionCliente")
public class InformacionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;

	@EJB

	VentasEjb ventaEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recupero la session
		HttpSession session = request.getSession();
		// Recupero la session asociada al usuario
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/InformacionCliente.jsp");

		// Recojo los atributos creados
		request.setAttribute("usuario", usuario);
		loggerNormal.debug("Entrando en Infomracion CLiente sin fallos");
		// y envio a la pagina
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recupero la session
		HttpSession session = request.getSession();
		//creos la estancia de la parametro error
		String error = request.getParameter("error");
		//Recupero la session asociada al usuario
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/InformacionCliente.jsp");
		//Creo las variable necesarias para este servlet
		String emailUsuario = request.getParameter("emailUsuario");
		ArrayList<UsuarioPojo> datosCliente;
		ArrayList<VentasPojo> ventasCliente;

		//Comprueblo que el email no sea nulo
		if ((emailUsuario != null)) {

			try {
				//Recupero los datos del cliente
				datosCliente = usuarioEjb.getDatosUsuarioporEmailUsuario(emailUsuario);
				//Recupero las ventas del cliente
				ventasCliente = ventaEjb.leerProductosporEmail(emailUsuario);
				
				//Recojo los atributos creados 
				request.setAttribute("usuario", usuario);
				request.setAttribute("error", error);
				request.setAttribute("emailUsuario", emailUsuario);
				request.setAttribute("datosCliente", datosCliente);
				request.setAttribute("ventasCliente", ventasCliente);
				loggerNormal.debug(" Realizando la consultas sin fallos");
				rs.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			response.sendRedirect("InfromacionCliente?error=No");

			loggerError.error("Error al Intentar acceder al cliente o no existe el cliente con ese correo");

		}

	}

}
