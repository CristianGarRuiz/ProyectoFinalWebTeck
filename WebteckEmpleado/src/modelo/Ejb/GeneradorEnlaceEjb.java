package modelo.Ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class GeneradorEnlaceEjb {

	public String generarEnlace(int codigo) {
		return "http://localhost:8080/WebteckCliente/claveRegistro?codigo=" + codigo;
	}
}
