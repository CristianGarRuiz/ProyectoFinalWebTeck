package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.DireccionPojo;
import modelo.dao.mappers.DireccionMapper;

public class DireccionDao {

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

	public ArrayList<DireccionPojo> leerDirecciones(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			DireccionMapper leerDirecciones = sqlSession.getMapper(DireccionMapper.class);
			return leerDirecciones.leerDirecciones(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

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
