package modelo.dao;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.ValorcionPojo;
import modelo.dao.mappers.ValoracionMapper;

public class ValoracionDao {
	
	public void insertCometario(ValorcionPojo valor) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ValoracionMapper AcciMapper = sqlSession.getMapper(ValoracionMapper.class);
			AcciMapper.insertComentario(valor);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertValoracion(ValorcionPojo valor) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ValoracionMapper AcciMapper = sqlSession.getMapper(ValoracionMapper.class);
			AcciMapper.insertValoracion(valor);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
