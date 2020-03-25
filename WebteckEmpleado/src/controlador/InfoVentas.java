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
import modelo.Ejb.SesionEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Ejb.VentasEjb;
import modelo.Pojo.UsuarioPojo;
import modelo.Pojo.VentasPojo;


@WebServlet("/InfoVentas")
public class InfoVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;

	@EJB
	VentasEjb ventaEjb;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String error = request.getParameter("error");
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/infoVentas.jsp");
		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// creoa la variable inico y fin para las fecha
		String inicio = request.getParameter("inicio");
		String fin = request.getParameter("fin");
		String error = null;
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		// dispache para la pagina
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/infoVentas.jsp");

		try {
			// el arraylist de las estadisticas del ejb con las fecha pasadas
			ArrayList<VentasPojo> ventas = ventaEjb.leerProductosporFecha(inicio, fin);

			// recogo los atributos de las estancias que he creado
			request.setAttribute("ventas", ventas);
			request.setAttribute("error", error);
			request.setAttribute("usuario", usuario);
			request.setAttribute("inicio", inicio);
			request.setAttribute("fin", fin);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// los datos que le paso no son nulos pues redirigo a la pagina con los datos
		if (inicio != null && fin != null) {
			rs.forward(request, response);
//			loggerNormal.debug(" Realizando la consultas sin fallos");

		} else {
			// sino dirigo con el error
			response.sendRedirect("PaginaPrincipal?error=hay fechas Incorrectas");

//			loggerError.error("Error al realizar la consultas por fechas");
		}

	}

}