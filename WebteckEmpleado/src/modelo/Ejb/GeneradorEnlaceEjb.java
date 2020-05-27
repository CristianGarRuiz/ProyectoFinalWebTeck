package modelo.Ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class GeneradorEnlaceEjb {

	/**
	 * este metodo genera un enlace con el codigo de activacion
	 * 
	 * @param codigo
	 * @return
	 */
	public String generarEnlace(int codigo) {
		return "http://localhost:8080/WebteckCliente/claveRegistro?codigo=" + codigo;
	}
}
