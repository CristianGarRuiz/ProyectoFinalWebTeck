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
			session.setAttribute("pantalla", usuario.getPantalla());
			session.setAttribute("emailUsuario", usuario.getEmailUsuario());
		}

	}

	public void logoutUsuario(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}

	/**
	 * este metodo recoge de la session el valor pantalla
	 * 
	 * @param session
	 * @return
	 */

	public String getPantalla(HttpSession session) {
		String pantalla;
		pantalla = (String) session.getAttribute("pantalla");

		return pantalla;

	}

	public String getEmailUsuario(HttpSession session) {
		String emailUsuario;
		emailUsuario = (String) session.getAttribute("emailUsuario");

		return emailUsuario;

	}

	/**
	 * este metodo comprueba que no sea nula la session y cambia el valor de
	 * pantalla en session
	 * 
	 * @param session
	 * @param pantalla
	 */
	public void cambiarPantalla(HttpSession session, String pantalla) {

		if (session != null) {
			session.setAttribute("pantalla", pantalla);
		}

	}
}
