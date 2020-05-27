package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import modelo.Pojo.ValorcionPojo;

public interface ValoracionMapper {

	/**
	 * este metodo inserta comentarios nuevos
	 * 
	 * @param valor
	 */
	public void insertComentario(ValorcionPojo valor);

	/**
	 * este metodo inserta valoraciones nuevas
	 * 
	 * @param valor
	 */
	public void insertValoracion(ValorcionPojo valor);

	/**
	 * este metodo recupera las valoraciones de los productos
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ValorcionPojo> leerValoracionesTienda(@Param("id") int id);

	/**
	 * este metodo recupera la comentarios de los porductos
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ValorcionPojo> leerComentariosTienda(@Param("id") int id);

}
