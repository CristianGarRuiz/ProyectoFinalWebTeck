package modelo.Pojo;

/**
 * este pojo es el pojo del carrito del cliente
 * 
 * @author cristian
 *
 */
public class CarritosPojo {

	private int id;
	private int idProducto;
	private String emailUsuario;
	private int stock;
	private int precio;
	private String foto;
	private String titulo;

	public CarritosPojo(int id, int idProducto, String emailUsuario, int precio, int stock, String foto,
			String titulo) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.emailUsuario = emailUsuario;
		this.stock = stock;
		this.precio = precio;
		this.foto = foto;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public CarritosPojo() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
