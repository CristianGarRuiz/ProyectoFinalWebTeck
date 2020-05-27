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

import modelo.Ejb.SesionEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Pojo.UsuarioPojo;


@WebServlet("/ComprobarAdmin")
public class ComprobarAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupero la session
		HttpSession session = request.getSession();
		//creos la estancia de la parametro error
		String error = request.getParameter("error");
		//Recupero la session asociada al usuario
		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/ComprobarAdmin.jsp");
		//Recojo los atributos creados 
		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		//y envio a la pagina 
		rs.forward(request, response);

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Creo las variable necesarias
		String cod = request.getParameter("codigo");
		String error = null;
		int codigoSecreto = 12345;
		
		int codigo = Integer.parseInt(cod);
		
		
		try {
			//Recojo los atributos creados 
			request.setAttribute("error", error);
			request.setAttribute("codigo", codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Compruebo que el codigoSecreto se ha el correcto
		if(codigo != codigoSecreto) {
			response.sendRedirect("ComprobarAdmin?error=hay");
		}else {
			response.sendRedirect("LogearUsuarios");
			
		}
		
		
	}

}
