package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.ValorcionPojo;
import modelo.dao.mappers.ValoracionMapper;

public class ValoracionDao {
	
	public void insertComentario(ValorcionPojo valor) {
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

	
	public ArrayList<ValorcionPojo> leerComentariosTienda(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ValoracionMapper leerProducto = sqlSession.getMapper(ValoracionMapper.class);
			return leerProducto.leerComentariosTienda(id);
		} finally {
			sqlSession.close();
		}

	}
	
	
	public ArrayList<ValorcionPojo> leerValoracionesTienda(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ValoracionMapper leerProducto = sqlSession.getMapper(ValoracionMapper.class);
			return leerProducto.leerValoracionesTienda(id);

		} finally {
			sqlSession.close();
		}

	}
}
