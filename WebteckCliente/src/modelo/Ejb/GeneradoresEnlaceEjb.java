package modelo.Ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class GeneradoresEnlaceEjb {

	public String generarEnlace(int codigo) {
		return "http://localhost:8080/WebteckEmpleado/claveRegistro?codigo=" + codigo;
	}
}
