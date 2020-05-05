package modelo.Pojo;

public class VentasPojo {

	private String titulo;
	private int precio;
	private String fecha;
	private String nombre;
	private int idProducto;
	private String emailUsuario;
	private int codigoPedido;

	public VentasPojo(String titulo, int precio, String fecha, String nombre, String emailUsuario, int idProducto,
			int codigoPedido) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.fecha = fecha;
		this.nombre = nombre;
		this.idProducto = idProducto;
		this.emailUsuario = emailUsuario;
		this.codigoPedido = codigoPedido;
	}

	public VentasPojo() {
		super();

	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
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
