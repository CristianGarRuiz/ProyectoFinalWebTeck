package modelo.Ejb;

import javax.servlet.http.HttpSession;

import modelo.Pojo.UsuarioPojo;

public class SesionEjb {

	public UsuarioPojo usuariosLogeado(HttpSession session) {

		UsuarioPojo usuario = null;

		if (session != null) {

			usuario = (UsuarioPojo) session.getAttribute("usuario");
		}

		return usuario;

	}

	public void loginUsuario(HttpSession session, UsuarioPojo usuario) {

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

}
