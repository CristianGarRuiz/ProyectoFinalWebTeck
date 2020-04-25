package modelo.Ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import modelo.Pojo.UsuariosPojo;

@Stateless
@LocalBean
public class UsuariosEjb {

	public UsuariosPojo leerDato(String nombre, String pass) {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/getUsuario/patata23/" + nombre + "/" + pass);

		UsuariosPojo usuario = target1.request().get(UsuariosPojo.class);

		return usuario;

	}

	public ArrayList<UsuariosPojo> leerDatosUsuario(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getDatosUsuario/patata23/"
						+ emailUsuario);

		ArrayList<UsuariosPojo> lista = (ArrayList<UsuariosPojo>) target1.request()
				.get(new GenericType<List<UsuariosPojo>>() {
				});

		return lista;
	}

	/**
	 * este metodo recoge la foto de los usuario
	 * 
	 * @param usu
	 * @return
	 * @throws SQLException
	 */

	public String getFoto(UsuariosPojo usu) throws SQLException {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getFoto/patata23/" + usu);

		UsuariosPojo usuario = target1.request().get(UsuariosPojo.class);

		return usuario.getFoto();

	}

	/**
	 * este metodo añade un usuario a la bd y genera un codigo random llama a la
	 * estacnia de insertar codigo y le pasa el codigo generado ycon el correo
	 * asociado y devuelve el codigo
	 * 
	 * @param usu
	 * @return
	 * @return
	 * @throws SQLException
	 */

//	public int añadirUsuario(UsuariosPojo usu) {
//		Client cliente = ClientBuilder.newClient();
//
//		int codigo = (int) (Math.random() * 10000 + 1);
//
//		WebTarget target1 = cliente.target("http://localhost:8080/WebteckEmpleado/ControladorRest/nuevoUsuario/patata23/" + usu + "/" + codigo);
//
//		target1.request().get(UsuariosPojo.class);
//
//		return codigo;
//
//	}
	
	public int añadirUsuario(UsuariosPojo usu) {
		Client cliente = ClientBuilder.newClient();

		int codigo = (int) (Math.random() * 10000 + 1);

		WebTarget target1 = cliente.target("http://localhost:8080/WebteckEmpleado/ControladorRest/nuevoUsuario/patata23/" + usu + "/" + codigo);

		target1.request().get(UsuariosPojo.class);

		return codigo;

	}


	/**
	 * este metodo elimina un usuario por su correo
	 * 
	 * @param correo
	 * @throws SQLException
	 */

	public void eliminarUsuarios(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/dropUsuarios/patata23/" + emailUsuario);

		target2.request().delete(UsuariosPojo.class);
	}

	/**
	 * este metodo serviria para activar el usuairo con el codigo que le pasamos
	 * 
	 * @param codigo
	 * @throws SQLException
	 */

	public void ActivarUsuario(int codigo) throws SQLException {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/activarUsuario/patata23/" + codigo);

		target1.request().get();

	}

	/**
	 * este metodo nos servira para hacer una conexion BBDD y modificar el campo
	 * pantalla segun el valor tenga con el usuario relacionado a la session
	 * 
	 * @param pantalla
	 * @param usuario
	 */

//	public void pantallaUsuario(String pantalla,String usuario ) {
//		daoUsuario userDao = new daoUsuario();
//		userDao.pantallaUsuario(pantalla, usuario);
//	}
//	

	// ESTE NOSE SI LO HE PASADO BIEN PORQUE
	// ANTES NO TENIA UNA ENTIDAD POJO COMO ABAJO
	public void pantallaUsuario(String pantalla, String usuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/pantallaUsuario/patata23/" + pantalla
						+ "/" + usuario);

		target2.request().get();
	}

	public void updateContraseña(UsuariosPojo usu) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/updateContraseña/patata23");

		target2.request().put(Entity.json(usu));
	}
	
	public void updateFoto(UsuariosPojo usu) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/updateFoto/patata23");

		target2.request().put(Entity.json(usu));
	}

}
