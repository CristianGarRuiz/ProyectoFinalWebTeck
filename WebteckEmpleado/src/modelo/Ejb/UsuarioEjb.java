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

	/**
	 * este metodo recupera un usuario por el nombre de usuario y el pasword
	 * 
	 * @param user
	 * @param paswd
	 * @return
	 * @throws SQLException
	 */
	public UsuarioPojo leerDatos(String user, String paswd) throws SQLException {

		UsuarioDao userDAO = new UsuarioDao();
		return userDAO.leerDatos(user, paswd);

	}

	/**
	 * este metodo recupera un empleado por su nombre y su password
	 * 
	 * @param user
	 * @param paswd
	 * @return
	 * @throws SQLException
	 */
	public UsuarioPojo leerDatosEmpleado(String user, String paswd) throws SQLException {

		EmpleadoDao userDAO = new EmpleadoDao();
		return userDAO.leerDatosEmpleado(user, paswd);

	}

	/**
	 * este metodo comprueba que el nombre de usuario ya exite
	 * 
	 * @param NombreUsuario
	 * @return
	 * @throws SQLException
	 */
	public UsuarioPojo comprobarUsuario(String NombreUsuario) throws SQLException {

		UsuarioDao userDAO = new UsuarioDao();
		return userDAO.comprobarUsuario(NombreUsuario);

	}

	/**
	 * este metodo comprueba que el email de usuario ya existe
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */
	public UsuarioPojo comprobarEmailUsario(String emailUsuario) throws SQLException {

		UsuarioDao userDAO = new UsuarioDao();
		return userDAO.comprobarEmailUsuario(emailUsuario);

	}

	/**
	 * este metodo comprubea que el nombre de usuario de empleado ya existe
	 * 
	 * @param NombreUsuario
	 * @return
	 * @throws SQLException
	 */
	public UsuarioPojo comprobarUsuarioEmpleado(String NombreUsuario) throws SQLException {

		EmpleadoDao userDAO = new EmpleadoDao();
		return userDAO.comprobarUsuarioEmpleado(NombreUsuario);

	}

	/**
	 * este metodo comprubea que el email del empleado ya existe
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */

	public UsuarioPojo comprobarEmailUsarioEmpleado(String emailUsuario) throws SQLException {

		EmpleadoDao userDAO = new EmpleadoDao();
		return userDAO.comprobarEmailUsuarioEmpleado(emailUsuario);

	}

	/**
	 * este metodo elimina un empleado por su email
	 * 
	 * @param emailUsuario
	 * @throws SQLException
	 */
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
	 * este metodo añade un empleado
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

	/**
	 * este metodo añade al usuario y al mismo tiempo añade el codigo de activacion
	 * con le usuario asociado a ese codigo
	 * 
	 * @param usu
	 * @param codigo
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * este metodo recupera los datos de usuario por su email
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UsuarioPojo> getDatosUsuarioporEmailUsuario(String emailUsuario) throws SQLException {
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

	/**
	 * este metodo modifica la contraseña del usuario
	 * 
	 * @param usu
	 */
	public void updateContraseña(UsuarioPojo usu) {
		UsuarioDao userDao = new UsuarioDao();
		userDao.updateContraseña(usu);
	}

	/**
	 * este metodo modifica la imagen del usuario
	 * 
	 * @param usu
	 */
	public void updateImagen(UsuarioPojo usu) {
		UsuarioDao userDao = new UsuarioDao();
		userDao.updateImagen(usu);
	}

}
