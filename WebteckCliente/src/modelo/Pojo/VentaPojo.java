package modelo.Pojo;

public class VentaPojo {

	private String titulo;
	private int codigoPedido;
	private int precio;
	private String fecha;
	private String nombre;
	private String emailUsuario;
	private int idProducto;

	public VentaPojo(String titulo, int precio, String fecha, String nombre, int idProducto, String emailUsuario,
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

	public VentaPojo() {
		super();

	}

	
	
	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
