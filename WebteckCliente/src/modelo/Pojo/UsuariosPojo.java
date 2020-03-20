package modelo.Pojo;

public class UsuariosPojo {

	private String emailUsuario;
	private String nombre;
	private String usuario;
	private String password;
	private String foto;
	private String administrador;
	private String pantalla;
	private String activado;

	public UsuariosPojo(String emailUsuario, String nombre, String usuario, String password, String foto,
			String administrador, String pantalla, String activado) {
		super();
		this.emailUsuario = emailUsuario;
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
		this.foto = foto;
		this.administrador = administrador;
		this.pantalla = pantalla;
		this.activado = activado;
	}

	public UsuariosPojo() {
		super();
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

	public String getPantalla() {
		return pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}

	public String getActivado() {
		return activado;
	}

	public void setActivado(String activado) {
		this.activado = activado;
	}

}
