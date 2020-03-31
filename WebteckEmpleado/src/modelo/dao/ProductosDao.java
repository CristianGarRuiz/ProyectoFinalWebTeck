package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.dao.MyBatisUtil;
import modelo.Pojo.BusquedaPojo;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.ProductoPojo;
import modelo.Pojo.ProductoTiendaPojo;
import modelo.dao.mappers.ProductoMapper;
import modelo.dao.mappers.UsuarioMapper;

public class ProductosDao {
	
	public ArrayList<ProductoPojo> leerTotalProductos() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			ProductoMapper usuleerProducto = sqlSession.getMapper(ProductoMapper.class);
			return usuleerProducto.leerTotalProductos();

		} finally {
			sqlSession.close();
		}

	}
	

	
	public ProductoPojo leerProductos(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			ProductoPojo a = leerProducto.leerProductos(id);

			return a;

		} finally {
			sqlSession.close();
		}

	}
	
	public ArrayList<BusquedaPojo> BuscarProductoporNombre(String titulo) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper nombreProd = sqlSession.getMapper(ProductoMapper.class);
			return  nombreProd.BuscarProductoporNombre(titulo);

		} finally {
			sqlSession.close();
		}

	}
	public ArrayList<ProductoTiendaPojo> BuscarProductoporNombreTienda(String titulo) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper nombreProd = sqlSession.getMapper(ProductoMapper.class);
			return  nombreProd.BuscarProductoporNombreTienda(titulo);

		} finally {
			sqlSession.close();
		}

	}
	
	public ArrayList<MarcaPojo> leerTotalMarcas() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			ProductoMapper usuleerProducto = sqlSession.getMapper(ProductoMapper.class);
			return usuleerProducto.leerTotalMarcas();

		} finally {
			sqlSession.close();
		}

	}
	
	public ArrayList<CategoriaPojo> leerTotalCategorias() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			ProductoMapper usuleerProducto = sqlSession.getMapper(ProductoMapper.class);
			return usuleerProducto.leerTotalCategorias();

		} finally {
			sqlSession.close();
		}

	}
	
	public void eliminarProducto(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper eliminarAccidente = sqlSession.getMapper(ProductoMapper.class);
			eliminarAccidente.eliminarProducto(id);
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

	public void updateProducto(ProductoPojo producto) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper accidenteEdi = sqlSession.getMapper(ProductoMapper.class);
			accidenteEdi.updateProducto(producto);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void insertProducto(ProductoPojo producto) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper AcciMapper = sqlSession.getMapper(ProductoMapper.class);
			AcciMapper.insertProducto(producto);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	

}
