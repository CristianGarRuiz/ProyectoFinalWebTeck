package modelo.Pojo;

/**
 * este pojo es el pojo de las marcas
 * 
 * @author cristian
 *
 */
public class MarcasPojo {

	private int id;
	private String nombre;

	public MarcasPojo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public MarcasPojo() {
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
