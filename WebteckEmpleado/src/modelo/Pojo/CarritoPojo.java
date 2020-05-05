package modelo.Pojo;

public class CarritoPojo {

	private int id;
	private int idProducto;
	private String emailUsuario;
	private String foto;
	private int precio;
	private int stock;
	private String titulo;

	public CarritoPojo() {
		super();

	}

	public CarritoPojo(int id, int idProducto, String emailUsuario, int precio, int stock, String foto, String titulo) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.emailUsuario = emailUsuario;
		this.precio = precio;
		this.stock = stock;
		this.foto = foto;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
