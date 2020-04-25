package modelo.Ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class GeneradoresEnlaceEjb {

	public String generarEnlace(int codigo) {
		return "http://localhost:8080/WebteckEmpleado/claveRegistro?codigo=" + codigo;
	}

	public String generarEnlaceUpdateContraseña() {

	
		String info = "Ves a nuestro enlace y modifica tu contraseña, Pero sino has solicitado este correo Ignoralo , Gracias EquipoTecnico";

		return info + "\r\t\n" + "http://localhost:8080/WebteckCliente/cambiarContra";
	}
}
