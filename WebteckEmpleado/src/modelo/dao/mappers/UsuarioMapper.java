package modelo.dao.mappers;

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
	
	public UsuarioPojo leerDatosEmpleado(@Param("usuario") String user,@Param("password") String paswd);

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
	
	
	public void AñadirEmpleado(@Param("emailUsuario") String emailUsuario, @Param("nombre") String nombre,
			@Param("usuario") String usuario, @Param("password") String pass, @Param("foto") String foto);

	/**
	 * elimina un usuario por su email en nuestra pagina
	 * 
	 * @param emailUsuario
	 */
	public void eliminarUsuario(@Param("emailUsuario") String emailUsuario);

	
	
	
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

	public void ActivarUsuario(@Param("codigo") Integer codigo);

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

	public void pantallaUsuario(@Param("pantalla") String pantalla, @Param("usuario") String usuario);
	
	
	public void updateContraseña(UsuarioPojo usu);

}
