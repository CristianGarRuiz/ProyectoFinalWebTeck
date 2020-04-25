package modelo.Pojo;

public class DireccionesPojo {

	private int id;
	private String direccion;
	private String vivienda;
	private String localidad;
	private String provincia;
	private int codigoPostal;
	private String emailUsuario;

	public DireccionesPojo() {
		super();

	}

	public DireccionesPojo(int id, String direccion, String vivienda, String localidad, String provincia,
			int codigoPostal, String emailUsuario) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.vivienda = vivienda;
		this.localidad = localidad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.emailUsuario = emailUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getVivienda() {
		return vivienda;
	}

	public void setVivienda(String vivienda) {
		this.vivienda = vivienda;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

}
