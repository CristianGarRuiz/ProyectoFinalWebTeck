package modelo.Pojo;

public class VentaPojo {

	private String titulo;
	private int precio;
	private String fecha;
	private String nombre;

	public VentaPojo(String titulo, int precio, String fecha, String nombre) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.fecha = fecha;
		this.nombre = nombre;
	}

	public VentaPojo() {
		super();

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
