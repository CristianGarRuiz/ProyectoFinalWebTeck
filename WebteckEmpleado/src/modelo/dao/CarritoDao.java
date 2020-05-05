package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.CarritoPojo;
import modelo.dao.mappers.CarritoMapper;

public class CarritoDao {

	public void eliminarProductoCarro( int idProducto,String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper eliminarProductoCarro = sqlSession.getMapper(CarritoMapper.class);
			eliminarProductoCarro.eliminarProductoCarrito(idProducto, emailUsuario);
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

	public void insertProductoCarrito(CarritoPojo carrito) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper AcciMapper = sqlSession.getMapper(CarritoMapper.class);
			AcciMapper.insertProductoCarrito(carrito);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	
	public CarritoPojo SumaCarrito(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper sumaCarro = sqlSession.getMapper(CarritoMapper.class);
			return sumaCarro.SumaCarrito(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

	public ArrayList<CarritoPojo> ProductoCarritoporEmail(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper nombreProd = sqlSession.getMapper(CarritoMapper.class);
			return nombreProd.ProductoCarritoporEmail(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

	public CarritoPojo contarProductoCarrito(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper leerProducto = sqlSession.getMapper(CarritoMapper.class);
			return leerProducto.contarProductoCarrito(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}
	
	
	public CarritoPojo contarProductoCarritoCantidad(int idProducto,String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper leerProductoCarrito = sqlSession.getMapper(CarritoMapper.class);
			return leerProductoCarrito.contarProductoCarritoCantidad(idProducto, emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

}
