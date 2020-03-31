package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import modelo.Pojo.VentasPojo;
import modelo.dao.mappers.VentasMapper;

public class VentasDao {
	
	public ArrayList<VentasPojo> leerProductosporFecha(String inicio, String fin) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VentasMapper leerProductos = sqlSession.getMapper(VentasMapper.class);
			return  leerProductos.leerProductosporFecha(inicio, fin);

		} finally {
			sqlSession.close();
		}

	}
	
	public ArrayList<VentasPojo> leerProductosporEmail(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VentasMapper leerProductos = sqlSession.getMapper(VentasMapper.class);
			return  leerProductos.leerProductosporEmail(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

}
