package modelo.Pojo;

import java.util.ArrayList;

public class ProductoPojo {

	private int id;
	private String titulo;
	private int anyo;
	private String foto;
	private String descripcion;
	private int precio;
	private int stock;
	private int idGenero;
	private int idPlataforma;

	public ProductoPojo() {
		super();
	}

	public ProductoPojo(int id, String titulo, int anyo, String foto, String descripcion, int precio,int stock, int idGenero,
			int idPlataforma) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anyo = anyo;
		this.foto = foto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock=stock;
		this.idGenero = idGenero;
		this.idPlataforma = idPlataforma;
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

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public int getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(int idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
