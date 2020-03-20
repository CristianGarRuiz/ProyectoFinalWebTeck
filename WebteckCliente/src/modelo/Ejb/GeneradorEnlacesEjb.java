package modelo.Ejb;

public class GeneradorEnlacesEjb {
	
	
	public String  generarEnlace(int codigo) {
		
		
		return "http://localhost:8080/WebteckCliente/claveRegistro?codigo=" + codigo;
		
	}

}
