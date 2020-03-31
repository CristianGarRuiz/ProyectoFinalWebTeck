package modelo.Ejb;

import java.util.ArrayList;

import modelo.Pojo.PreguntaPojo;
import modelo.dao.PreguntaDao;

public class PreguntaEjb {
	
	public ArrayList<PreguntaPojo> getRespuestaPreguntas(String pregunta){
		
		PreguntaDao preguntaDao = new PreguntaDao();
		
		return preguntaDao.getRespuestaPreguntas(pregunta);
		
	}
	

}
