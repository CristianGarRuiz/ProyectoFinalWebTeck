package modelo.Ejb;

public class GeneradorEnlaceEjb {

	public String generarEnlace(int codigo) {
		return "http://localhost:8080/WebteckEmpleado/claveRegistro?codigo=" + codigo;
	}
}
