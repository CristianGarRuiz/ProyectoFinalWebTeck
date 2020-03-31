package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.Pojo.PreguntaPojo;

public interface PreguntaMapper {
	
	public ArrayList<PreguntaPojo> getRespuestaPreguntas(@Param("pregunta") String pregunta);

}
