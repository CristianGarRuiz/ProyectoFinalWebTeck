package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.PreguntaPojo;
import modelo.dao.mappers.PreguntaMapper;


public class PreguntaDao {

	
	public ArrayList<PreguntaPojo> getRespuestaPreguntas(String pregunta) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PreguntaMapper preguntaNombre = sqlSession.getMapper(PreguntaMapper.class);
			return  preguntaNombre.getRespuestaPreguntas(pregunta);

		} finally {
			sqlSession.close();
		}

	}
}
