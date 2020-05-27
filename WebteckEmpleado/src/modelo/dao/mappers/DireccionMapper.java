package modelo.dao.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import modelo.Pojo.DireccionPojo;

public interface DireccionMapper {

	/**
	 * este metodo inserta una direccion
	 * 
	 * @param direccion
	 */
	public void insertDireccion(DireccionPojo direccion);

	/**
	 * este metodo recupera una lista de la direccion por el email de usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public ArrayList<DireccionPojo> leerDirecciones(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo modficia la direccion
	 * 
	 * @param direccion
	 */
	public void updateDireccion(DireccionPojo direccion);

	/**
	 * este metodo recupera la direccion por email de usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public DireccionPojo direccionPorNombre(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo elimina la direccion por email de usuario
	 * 
	 * @param emailUsuario
	 */
	public void eliminarDireccion(@Param("emailUsuario") String emailUsuario);

}
