package modelo.Ejb;

import javax.servlet.http.HttpSession;

import modelo.Pojo.UsuariosPojo;

public class SesionesEjb {

	public UsuariosPojo usuarioLogeado(HttpSession session) {
		UsuariosPojo usuario = null;

		if (session != null) {
			usuario = (UsuariosPojo) session.getAttribute("usuario");
		}
		return usuario;

	}

	public void loginUsuario(HttpSession session, UsuariosPojo usuario) {

		if (session != null) {
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(30 * 60);
		}
	}

	public void logoutUsuario(HttpSession session) {

		if (session != null) {
			session.invalidate();
		}

	}

	public String getPantalla(HttpSession session) {

		String pantalla;
		pantalla = (String) session.getAttribute("pantalla");
		return pantalla;
	}
	
	
	public void cambiarPantalla(HttpSession session, String pantalla) {
		if(session!=null) {
			session.setAttribute("pantalla", pantalla);
		}
	}
}
