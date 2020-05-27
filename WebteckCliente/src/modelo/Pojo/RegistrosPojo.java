package modelo.Pojo;


import java.util.Date;

/**
 * esta clase seria la clase pelada de los datos de un registro un usuario con
 * las datos necesitados
 * 
 * @author cristian
 *
 */
public class RegistrosPojo {

	private int id;
	private String emailUsuario;
	private String clave;
	private Date fechaHora;

	public RegistrosPojo(int id, String emailUsuario, String clave, Date fechaHora) {
		super();
		this.id = id;
		this.emailUsuario = emailUsuario;
		this.clave = clave;
		this.fechaHora = fechaHora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

}
