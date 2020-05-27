package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.Pojo.PreguntaPojo;

public interface PreguntaMapper {
	/**
	 * este metodo recupera una lista de preguntas frecuentes por email usuario
	 * 
	 * @param nombre
	 * @return
	 */
	public ArrayList<PreguntaPojo> getRespuestaPreguntas(@Param("nombre") String nombre);

}
