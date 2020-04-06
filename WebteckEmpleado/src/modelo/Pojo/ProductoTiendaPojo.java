package modelo.Pojo;

public class ProductoTiendaPojo {

	private int id;
	private String titulo;
	private int anyo;
	private String foto;
	private String descripcion;
	private int precio;
	private int stock;
	private String genero;
	private String plataforma;
	private String comentario;
	private int valoracion;

	public ProductoTiendaPojo() {
		super();
	
	}

	public ProductoTiendaPojo(int id, String titulo, int anyo, String foto, String descripcion, int precio, int stock,
			String genero, String plataforma,String comentario,int valoracion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anyo = anyo;
		this.foto = foto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.genero = genero;
		this.plataforma = plataforma;
		this.valoracion = valoracion;
		this.comentario = comentario;
	}

	
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
