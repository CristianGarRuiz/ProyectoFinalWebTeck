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

public class ProductosDao {
	/**
	 * este metodo recupera una lista de productos
	 * 
	 * @return
	 */
	public ArrayList<ProductoPojo> leerTotalProductos() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			ProductoMapper usuleerProducto = sqlSession.getMapper(ProductoMapper.class);
			return usuleerProducto.leerTotalProductos();

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo recupera una lista de porductos
	 * 
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerTotalTienda() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			ProductoMapper usuleerProducto = sqlSession.getMapper(ProductoMapper.class);
			return usuleerProducto.leerTotalTienda();

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo recupera una lista de productos
	 * 
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerTotalProductosMedia() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			ProductoMapper usuleerProducto = sqlSession.getMapper(ProductoMapper.class);
			return usuleerProducto.leerTotalProductosMedia();

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo lee el producto por su id
	 * 
	 * @param id
	 * @return
	 */
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

	/**
	 * este metodo recupera las categoria por la id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<CategoriaPojo> leerCategoriaId(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			ArrayList<CategoriaPojo> a = leerProducto.leerCategoriaId(id);

			return a;

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo recupera las marcas por la id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<MarcaPojo> leerMarcaId(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			ArrayList<MarcaPojo> a = leerProducto.leerMarcaId(id);
			return a;

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo recupera una lista de productos por su id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerProductosTienda(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			return leerProducto.leerProductosTienda(id);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo filtra por valores para recuperar un producto
	 * 
	 * @param idMarca
	 * @param idCategoria
	 * @param precioIni
	 * @param precioFin
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> productosFiltro(int idMarca, int idCategoria, int precioIni, int precioFin) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			return leerProducto.productosFiltro(idMarca, idCategoria, precioIni, precioFin);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo le los productos por id de la categoria
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerProductosTiendaCategoriaid(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			return leerProducto.leerProductosCategoriaid(id);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo lee los porductos por la id de la marca
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerProductosTiendaMarcaid(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			return leerProducto.leerProductosMarcaid(id);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo cuenta los porductos por id de categoria
	 * 
	 * @param id
	 * @return
	 */
	public ProductoTiendaPojo contarProductoCategoria(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			return leerProducto.contarProductoCategoria(id);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo cuenta los porductos por la id de la marca
	 * 
	 * @param id
	 * @return
	 */
	public ProductoTiendaPojo contarProductoMarca(int id) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper leerProducto = sqlSession.getMapper(ProductoMapper.class);
			return leerProducto.contarProductoMarca(id);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo busca un porducto por su nombre
	 * 
	 * @param titulo
	 * @return
	 */
	public ArrayList<BusquedaPojo> BuscarProductoporNombre(String titulo) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper nombreProd = sqlSession.getMapper(ProductoMapper.class);
			return nombreProd.BuscarProductoporNombre(titulo);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo busqueda los productos por el nombre
	 * 
	 * @param titulo
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> BuscarProductoporNombreTienda(String titulo) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper nombreProd = sqlSession.getMapper(ProductoMapper.class);
			return nombreProd.BuscarProductoporNombreTienda(titulo);

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo muestra una lista de todas las marcas
	 * 
	 * @return
	 */
	public ArrayList<MarcaPojo> leerTotalMarcas() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			ProductoMapper usuleerProducto = sqlSession.getMapper(ProductoMapper.class);
			return usuleerProducto.leerTotalMarcas();

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo recupera una lista de todas las categorias
	 * 
	 * @return
	 */
	public ArrayList<CategoriaPojo> leerTotalCategorias() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			ProductoMapper usuleerProducto = sqlSession.getMapper(ProductoMapper.class);
			return usuleerProducto.leerTotalCategorias();

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo elimina los productos por su id
	 * 
	 * @param id
	 */
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

	/**
	 * este metodo modifica los productos
	 * 
	 * @param producto
	 */
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

	/**
	 * este metodo modifica el stock de los porductos
	 * 
	 * @param stock
	 * @param cantidad
	 * @param idProducto
	 */
	public void updateProductoCantidad(int stock, int cantidad, int idProducto) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ProductoMapper accidenteEdi = sqlSession.getMapper(ProductoMapper.class);
			accidenteEdi.updateProductoCantidad(stock, cantidad, idProducto);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * este metodo inserta productos nuevos
	 * 
	 * @param producto
	 */
	
	
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
