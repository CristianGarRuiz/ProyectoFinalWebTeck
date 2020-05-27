package modelo.Pojo;

/**
 * este pojo es el pojo de las preguntas
 * 
 * @author cristian
 *
 */

public class PreguntasPojo {

	private int id;
	private String nombre;
	private String respuesta;

	public PreguntasPojo(int id, String nombre, String respuesta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.respuesta = respuesta;
	}

	public PreguntasPojo() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
