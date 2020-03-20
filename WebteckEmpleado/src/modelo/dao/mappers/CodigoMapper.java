package modelo.dao.mappers;

import org.apache.ibatis.annotations.Param;

public interface CodigoMapper {

	/**
	 * inserta el codigo del usuario segun el su email relacionado al codigo
	 * 
	 * @param codigo
	 * @param emailUsuario
	 */
	public void insertCodigo(@Param("codigo") int codigo, @Param("emailUsuario") String emailUsuario);

}