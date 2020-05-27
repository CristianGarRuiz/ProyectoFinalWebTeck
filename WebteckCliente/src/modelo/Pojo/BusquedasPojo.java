package modelo.Pojo;

/**
 * este pojo es el pojo de la busqueda de productos
 * 
 * @author cristian
 *
 */
public class BusquedasPojo {

	private int id;
	private String titulo;
	private int anyo;
	private int precio;
	private String descripcion;
	private String genero;
	private String plataforma;

	public BusquedasPojo(int id, String titulo, int anyo, int precio, String descripcion, String genero,
			String plataforma) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anyo = anyo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.genero = genero;
		this.plataforma = plataforma;
	}

	public BusquedasPojo() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

}
