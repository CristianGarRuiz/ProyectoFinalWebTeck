package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import modelo.Pojo.VentasPojo;
import modelo.dao.mappers.VentasMapper;

public class VentasDao {

	/**
	 * este metodo recupera los porducos comprados por dos fechas
	 * 
	 * @param inicio
	 * @param fin
	 * @return
	 */
	public ArrayList<VentasPojo> leerProductosporFecha(String inicio, String fin) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VentasMapper leerProductos = sqlSession.getMapper(VentasMapper.class);
			return leerProductos.leerProductosporFecha(inicio, fin);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo recupera una lista de productos comprados por email del usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public ArrayList<VentasPojo> leerProductosporEmail(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VentasMapper leerProductos = sqlSession.getMapper(VentasMapper.class);
			return leerProductos.leerProductosporEmail(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo inserta ventas nuevas
	 * 
	 * @param venta
	 */
	public void insertarVenta(VentasPojo venta) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VentasMapper AcciMapper = sqlSession.getMapper(VentasMapper.class);
			AcciMapper.insertarVenta(venta);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
