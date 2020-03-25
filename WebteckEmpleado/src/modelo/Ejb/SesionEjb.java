package modelo.Ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import modelo.Pojo.UsuarioPojo;

@Stateless
@LocalBean
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
