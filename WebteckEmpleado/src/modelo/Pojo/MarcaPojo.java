package modelo.Pojo;

public class MarcaPojo {

	private int id;
	private String nombre;

	public MarcaPojo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public MarcaPojo() {
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

}
