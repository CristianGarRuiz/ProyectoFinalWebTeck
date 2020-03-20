package modelo.Pojo;

public class CategoriaPojo {

	private int id;
	private String nombre;

	public CategoriaPojo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public CategoriaPojo() {
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
