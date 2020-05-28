package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import modelo.Pojo.UsuarioPojo;

public interface UsuarioMapper {

	/**
	 * recojo los datos de un usuario y comprueba que cumpla con el usuario y
	 * password
	 * 
	 * @param user
	 * @param paswd
	 * @return
	 */
	public UsuarioPojo leerDatos(@Param("usuario") String user, @Param("password") String paswd);

	/**
	 * este metodo comprueba que nombre de usuario ya existe
	 * 
	 * @param NombreUsuario
	 * @return
	 */

	public UsuarioPojo comprobarUsuario(@Param("usuario") String NombreUsuario);

	/**
	 * este metod comprueba el email del usuario ya existe
	 * 
	 * @param emailUsuario
	 * @return
	 */

	public UsuarioPojo comprobarEmailUsario(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo comprueba si el nombre de del empleado ya existe
	 * 
	 * @param NombreUsuario
	 * @return
	 */

	public UsuarioPojo comprobarUsuarioEmpleado(@Param("usuario") String NombreUsuario);

	/**
	 * este metodo comprueba si el email del empleado ya existe
	 * 
	 * @param emailUsuario
	 * @return
	 */

	public UsuarioPojo comprobarEmailUsarioEmpleado(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo recupera los datos por email de usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */

	public ArrayList<UsuarioPojo> getDatosUsuarioporEmailUsuario(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metood recupera un empleado por el nombre de usuario y su password
	 * 
	 * @param user
	 * @param paswd
	 * @return
	 */

	public UsuarioPojo leerDatosEmpleado(@Param("usuario") String user, @Param("password") String paswd);

	/**
	 * recoje la imagen de un usuario que hace login
	 * 
	 * @param usuario
	 * @return
	 */
	public String getFoto(UsuarioPojo usuario);

	/**
	 * añade usuario nuevos a nuestra pagina
	 * 
	 * @param emailUsuario
	 * @param nombre
	 * @param usuario
	 * @param pass
	 * @param foto
	 */
	public void AñadirUsuarios(@Param("emailUsuario") String emailUsuario, @Param("nombre") String nombre,
			@Param("usuario") String usuario, @Param("password") String pass, @Param("foto") String foto,
			@Param("activado") String activado);

	/**
	 * añadir nuevos empleado a a la pagina
	 * 
	 * @param emailUsuario
	 * @param nombre
	 * @param usuario
	 * @param pass
	 * @param foto
	 */
	public void AñadirEmpleado(@Param("emailUsuario") String emailUsuario, @Param("nombre") String nombre,
			@Param("usuario") String usuario, @Param("password") String pass, @Param("foto") String foto);

	/**
	 * elimina un usuario por su email en nuestra pagina
	 * 
	 * @param emailUsuario
	 */
	public void eliminarUsuario(@Param("emailUsuario") String emailUsuario);

	/**
	 * eliminar empleados por su email de usuario
	 * 
	 * @param emailUsuario
	 */

	public void eliminarEmpleado(@Param("emailUsuario") String emailUsuario);

	/**
	 * elimina la clave relaciona con email del usuario eliminado
	 * 
	 * @param emailUsuario
	 */
	public void eliminarClave(@Param("emailUsuario") String emailUsuario);

	/**
	 * activa el usuario por el codigo que envia en un enlace al correo
	 * 
	 * @param codigo
	 */

	public void activarUsuario(@Param("codigo") Integer codigo);

	/**
	 * hace una cuenta total de los usuario creado en nuestra pagina
	 * 
	 * @return
	 */
//
//	public int contarUsuarios();

	/**
	 * hace un update ne valor pantala de BBDD segun el valor que tenga puesto ,
	 * relacionado con el usuario que esta logeado en ese momento
	 * 
	 * @param pantalla
	 * @param usuario
	 */

	/**
	 * modifica la pantalla del usuario al usuairo asociado al cambio
	 * 
	 * @param pantalla
	 * @param usuario
	 */
	public void pantallaUsuario(@Param("pantalla") String pantalla, @Param("usuario") String usuario);

	/**
	 * modifica la contraseña del usuario
	 * 
	 * @param usu
	 */
	public void updateContraseña(UsuarioPojo usu);

	/**
	 * modifica la imagen de usuario
	 * 
	 * @param usu
	 */
	public void updateImagen(UsuarioPojo usu);

	/**
	 * este metodo cmabia la imagen del empleado
	 * 
	 * @param usu
	 */
	public void updateImagenEmpleado(UsuarioPojo usu);

}
