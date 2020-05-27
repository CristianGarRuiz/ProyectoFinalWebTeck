package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.ValorcionPojo;
import modelo.dao.mappers.ValoracionMapper;

public class ValoracionDao {

	/**
	 * este metodo inserta comentarios nuevos
	 * 
	 * @param valor
	 */
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

	/**
	 * este metodo inserta valoraciones nuevas
	 * 
	 * @param valor
	 */
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

	/**
	 * este metodo recupera los comentarios por id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ValorcionPojo> leerComentariosTienda(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ValoracionMapper leerProducto = sqlSession.getMapper(ValoracionMapper.class);
			return leerProducto.leerComentariosTienda(id);
		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo recupera una lista con las valoraciones por id
	 * 
	 * @param id
	 * @return
	 */
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
