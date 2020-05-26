package modelo.Ejb;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.dao.EmpleadoDao;
import modelo.dao.UsuarioDao;
import modelo.dao.CodigoDAO;
import modelo.Pojo.UsuarioPojo;


@Stateless
@LocalBean
public class UsuarioEjb {

	public UsuarioPojo leerDatos(String user, String paswd) throws SQLException {

		UsuarioDao userDAO = new UsuarioDao();
		return userDAO.leerDatos(user, paswd);

	}
	
	
	public UsuarioPojo leerDatosEmpleado (String user, String paswd) throws SQLException {

		EmpleadoDao userDAO = new EmpleadoDao();
		return userDAO.leerDatosEmpleado(user, paswd);

	}
	
	
	public UsuarioPojo comprobarUsuario (String NombreUsuario) throws SQLException {

		UsuarioDao userDAO = new UsuarioDao();
		return userDAO.comprobarUsuario(NombreUsuario);

	}
	
	public UsuarioPojo comprobarEmailUsario (String emailUsuario) throws SQLException {

		UsuarioDao userDAO = new UsuarioDao();
		return userDAO.comprobarEmailUsuario(emailUsuario);

	}
	
	
	public UsuarioPojo comprobarUsuarioEmpleado (String NombreUsuario) throws SQLException {

		EmpleadoDao userDAO = new EmpleadoDao();
		return userDAO.comprobarUsuarioEmpleado(NombreUsuario);

	}
	
	public UsuarioPojo comprobarEmailUsarioEmpleado (String emailUsuario) throws SQLException {

		EmpleadoDao userDAO = new EmpleadoDao();
		return userDAO.comprobarEmailUsuarioEmpleado(emailUsuario);

	}
	
	
	public void eliminarEmpleado(String emailUsuario) throws SQLException {
		EmpleadoDao userDao = new EmpleadoDao();
		userDao.eliminarEmpleado(emailUsuario);
	}
	/**
	 * este metodo recoge la foto de los usuario
	 * 
	 * @param usu
	 * @return
	 * @throws SQLException
	 */

	public String getFoto(UsuarioPojo usu) throws SQLException {

		UsuarioDao userFoto = new UsuarioDao();

		return userFoto.getFoto(usu);

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
	
	public void AñadirEmpleado(UsuarioPojo usu) throws SQLException {
		EmpleadoDao userDao = new EmpleadoDao();
		userDao.AñadirEmpleado(usu);


	}
	
	public int añadirUsuario(UsuarioPojo usu, int codigo) throws SQLException {
		UsuarioDao userDao = new UsuarioDao();
		userDao.AñadirUsuarios(usu);
		
		CodigoDAO codigoDao = new CodigoDAO();
		codigoDao.insertCodigo(codigo, usu.getEmailUsuario());
		return codigo;

	}

	/**
	 * este metodo elimina un usuario por su correo
	 * 
	 * @param correo
	 * @throws SQLException
	 */
	public void eliminarUsuario(String emailUsuario) throws SQLException {
		UsuarioDao userDao = new UsuarioDao();
		userDao.eliminarUsuario(emailUsuario);
		userDao.eliminarClave(emailUsuario);
	}

	/**
	 * este metodo serviria para activar el usuairo con el codigo que le pasamos
	 * 
	 * @param codigo
	 * @throws SQLException
	 */
	public void activarUsuario(int codigo) throws SQLException {
		UsuarioDao userDao = new UsuarioDao();
		userDao.activarUsuario(codigo);
	}

	
	public ArrayList<UsuarioPojo> getDatosUsuarioporEmailUsuario(String emailUsuario)  throws SQLException {
		UsuarioDao userDao = new UsuarioDao();
		return userDao.getDatosUsuarioporEmailUsuario(emailUsuario);

	}
	/**
	 * este metodo serviria para contar los usuarios
	 * 
	 * @return
	 * @throws SQLException
	 */

//	public int contarUsuario() throws SQLException {
//		UsuarioDao userDao = new UsuarioDao();
//		return userDao.contarUsuarios();
//	}
	/**
	 * este metodo nos servira para hacer una conexion BBDD y modificar el campo
	 * pantalla segun el valor tenga con el usuario relacionado a la session
	 * 
	 * @param pantalla
	 * @param usuario
	 */
	public void pantallaUsuario(String pantalla, String usuario) {
		UsuarioDao userDao = new UsuarioDao();
		userDao.pantallaUsuario(pantalla, usuario);
	}
	
	
	public void updateContraseña(UsuarioPojo usu) {
		UsuarioDao userDao = new UsuarioDao();
		userDao.updateContraseña(usu);
	}
	
	public void updateImagen(UsuarioPojo usu) {
		UsuarioDao userDao = new UsuarioDao();
		userDao.updateImagen(usu);
	}

}
