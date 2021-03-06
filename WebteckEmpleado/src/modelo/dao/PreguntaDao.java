package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.PreguntaPojo;
import modelo.dao.mappers.PreguntaMapper;

public class PreguntaDao {

	/**
	 * este metodo recupera una lista de preguntas por nombre
	 * 
	 * @param nombre
	 * @return
	 */
	public ArrayList<PreguntaPojo> getRespuestaPreguntas(String nombre) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PreguntaMapper preguntaNombre = sqlSession.getMapper(PreguntaMapper.class);
			return preguntaNombre.getRespuestaPreguntas(nombre);

		} finally {
			sqlSession.close();
		}

	}
}
