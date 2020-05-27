package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.Pojo.CarritoPojo;
import modelo.dao.mappers.CarritoMapper;

public class CarritoDao {
	
	/**
	 * este metodo conecta a bd para eliminar un producto del carro 
	 * @param idProducto
	 * @param emailUsuario
	 */

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

	
	/**
	 * este metodo conecta con bd para insertar productos al carro
	 * 
	 * @param carrito
	 */
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
	
	/**
	 * este metodo conecta con bd y calcula el precio total de los porductos del carro
	 * @param emailUsuario
	 * @return
	 */
	public CarritoPojo SumaCarrito(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper sumaCarro = sqlSession.getMapper(CarritoMapper.class);
			return sumaCarro.SumaCarrito(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo conecta con bd lee los porductos del carro asociados con cada email de usuario
	 * @param emailUsuario
	 * @return
	 */
	public ArrayList<CarritoPojo> ProductoCarritoporEmail(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper nombreProd = sqlSession.getMapper(CarritoMapper.class);
			return nombreProd.ProductoCarritoporEmail(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}

	
	/**
	 * este conecta con bd y cuenta los porductos del carro por email de usuario
	 * para luego hacer un count de la lista de productos
	 * @param emailUsuario
	 * @return
	 */
	public CarritoPojo contarProductoCarrito(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CarritoMapper leerProducto = sqlSession.getMapper(CarritoMapper.class);
			return leerProducto.contarProductoCarrito(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}
	
	/**
	 * este metodo conecta con bd y cuenta el total de los porductos del carro
	 * @param idProducto
	 * @param emailUsuario
	 * @return
	 */
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
