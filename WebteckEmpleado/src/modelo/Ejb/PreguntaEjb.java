package modelo.Ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.Pojo.PreguntaPojo;
import modelo.dao.PreguntaDao;

@Stateless
@LocalBean
public class PreguntaEjb {
	
	public ArrayList<PreguntaPojo> getRespuestaPreguntas(String nombre){
		PreguntaDao preguntaDao = new PreguntaDao();
		return preguntaDao.getRespuestaPreguntas(nombre);
		
	}
	

}
