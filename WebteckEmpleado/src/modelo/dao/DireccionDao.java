package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.DireccionPojo;
import modelo.dao.mappers.DireccionMapper;

public class DireccionDao {

	/**
	 * este metodo conecta con y bd para insertar una direccion
	 * 
	 * @param direccion
	 */

	public void insertDireccion(DireccionPojo direccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			DireccionMapper Direccion = sqlSession.getMapper(DireccionMapper.class);
			Direccion.insertDireccion(direccion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * este metodo conecta con bd y recupera datos de la direcion por email de
	 * usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public DireccionPojo direccionPorNombre(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			DireccionMapper leerdire = sqlSession.getMapper(DireccionMapper.class);
			DireccionPojo a = leerdire.direccionPorNombre(emailUsuario);

			return a;

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo conecta con bd y recupera un arraylist de la direccion de un
	 * cliente por email usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */

	public ArrayList<DireccionPojo> leerDirecciones(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			DireccionMapper leerDirecciones = sqlSession.getMapper(DireccionMapper.class);
			return leerDirecciones.leerDirecciones(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo conecta con bd y modifica la direccion por email de usuario
	 * 
	 * @param direccion
	 */
	public void updateDireccion(DireccionPojo direccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			DireccionMapper direccionEdi = sqlSession.getMapper(DireccionMapper.class);
			direccionEdi.updateDireccion(direccion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * este metodo conecta con bd y elimina cla direccion por email de usuario
	 * 
	 * @param emailUsuario
	 */
	public void eliminarDireccion(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			DireccionMapper eliUsu = sqlSession.getMapper(DireccionMapper.class);
			eliUsu.eliminarDireccion(emailUsuario);
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

}
