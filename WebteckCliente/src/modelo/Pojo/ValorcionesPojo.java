package modelo.Pojo;

public class ValorcionesPojo {
	private int id;
	private int idProducto;
	private String emailUsuario;
	private int valoraciones;
	private String comentarios;
	private String foto;

	public ValorcionesPojo(int id, int idProducto, String emailUsuario, int valoraciones, String comentarios,
			String foto) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.emailUsuario = emailUsuario;
		this.valoraciones = valoraciones;
		this.comentarios = comentarios;
		this.foto = foto;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public ValorcionesPojo() {
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

	public int getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(int valoraciones) {
		this.valoraciones = valoraciones;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
