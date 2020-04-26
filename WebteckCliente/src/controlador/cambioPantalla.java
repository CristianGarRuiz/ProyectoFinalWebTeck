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

import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/cambioPantalla")
public class cambioPantalla extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	SesionesEjb sesionesEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recojo la sesion
		HttpSession session = request.getSession();
		// recojo el usuario que esta logeado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// creo la variable para recoger la pantalla de la session
		String pantalla = sesionesEjb.getPantalla(session);

		// enviar a una o otro jsp segun el valor de pantalla
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Principal.jsp");
		RequestDispatcher rsNocturna = getServletContext().getRequestDispatcher("/PrincipalNocturna.jsp");

//las request de los atributos que estancio al principio
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);

		// Si pantalla es d enviara al jsp normal y si es n enviara al jsp nocturno pero
		// aparte
		// con el ejb pantallaUSuario ara un update en el valor de BBDD
		// con el ejbSession cmabiaPantalla guardar el valor en la session
		if (pantalla.equals("D")) {

			rsNocturna.forward(request, response);
			//cambio el valor de pantalla del usuario recogio en la session
			usuarioEjb.pantallaUsuario("N", usuario.getUsuario());
			//cambio el valor pantalla en la session
			sesionesEjb.cambiarPantalla(session, "N");

		} else {
			rs.forward(request, response);
			usuarioEjb.pantallaUsuario("D", usuario.getUsuario());
			sesionesEjb.cambiarPantalla(session, "D");
		}

	}
}
