package modelo.Ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import modelo.Pojo.UsuariosPojo;

@Stateless
@LocalBean
public class SesionesEjb {

	public UsuariosPojo usuariosLogeado(HttpSession session) {

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

}
