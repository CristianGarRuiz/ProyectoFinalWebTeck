package modelo.Ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import modelo.Pojo.UsuarioPojo;

@Stateless
@LocalBean
public class SesionEjb {

	/**
	 * recupera la session asociada la usuario
	 * 
	 * @param session
	 * @return
	 */
	public UsuarioPojo usuariosLogeado(HttpSession session) {

		UsuarioPojo usuario = null;

		if (session != null) {
			usuario = (UsuarioPojo) session.getAttribute("usuario");
		}

		return usuario;

	}

	/**
	 * abre la session al usuario con intervalo de tiempo
	 * 
	 * @param session
	 * @param usuario
	 */
	public void loginUsuario(HttpSession session, UsuarioPojo usuario) {

		if (session != null) {
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(30 * 60);
		}

	}

	/**
	 * cierra la session del usuario
	 * 
	 * @param session
	 */
	public void logoutUsuario(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}

	/**
	 * recupera el valora de pantalla de la session
	 * 
	 * @param session
	 * @return
	 */
	public String getPantalla(HttpSession session) {
		String pantalla;
		pantalla = (String) session.getAttribute("pantalla");

		return pantalla;

	}

	/**
	 * recupera el email de usuario de la session
	 * 
	 * @param session
	 * @return
	 */
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
