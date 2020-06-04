package modelo.Ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class GeneradoresEnlaceEjb {

	/**
	 * este metodo genera un enlace para activar la cuenta
	 * 
	 * @param codigo
	 * @return
	 */
	public String generarEnlace(int codigo) {
		return "http://5.196.27.145:8080/WebteckCliente/claveRegistro?codigo=" + codigo;
	}

	/**
	 * este metodo genera un en para modificar la contraseña
	 * 
	 * @return
	 */
	public String generarEnlaceUpdateContraseña() {

		String info = "Ves a nuestro enlace y modifica tu contraseña, Pero sino has solicitado este correo Ignoralo , Gracias EquipoTecnico";

		return info + "\r\t\n" + "http://5.196.27.145:8080/WebteckCliente/cambiarContra";
	}
}
