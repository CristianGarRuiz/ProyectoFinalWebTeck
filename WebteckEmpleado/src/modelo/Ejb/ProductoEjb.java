package modelo.Ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.dao.ProductosDao;
import modelo.Pojo.BusquedaPojo;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.ProductoPojo;
import modelo.Pojo.ProductoTiendaPojo;

@Stateless
@LocalBean
public class ProductoEjb {

	/**
	 * este metodo recupera los productos
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductoPojo> leerTotalProductos() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalProductos();
	}

	/**
	 * este metodo recupera los productos
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductoTiendaPojo> leerTotalTienda() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalTienda();
	}

	public ArrayList<ProductoTiendaPojo> leerTotalProductosMedia() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalProductosMedia();
	}

	/**
	 * este metodo recupera todas las marcas
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MarcaPojo> leerTotalMarcas() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalMarcas();
	}

	/**
	 * este metodo recupera todas las categorias
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CategoriaPojo> leerTotalCategorias() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalCategorias();
	}

	/**
	 * este metodo recupera un producto por su id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ProductoPojo leerProducto(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductos(id);

	}

	/**
	 * este netodo recupera una lista de categorias por su id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */

	public ArrayList<CategoriaPojo> leerCategoriaId(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerCategoriaId(id);

	}

	/**
	 * este metodo recupera una lista de marcas por su id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MarcaPojo> leerMarcaId(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerMarcaId(id);

	}

	/**
	 * este metodo le los porductos por id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductoTiendaPojo> leerProductoTienda(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductosTienda(id);

	}

	/**
	 * este metodo filtra por los valores pasado y recupera una lista de porductos
	 * asociada
	 * 
	 * @param idMarca
	 * @param idCategoria
	 * @param precioIni
	 * @param precioFin
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductoTiendaPojo> productosFiltro(int idMarca, int idCategoria, int precioIni, int precioFin)
			throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.productosFiltro(idMarca, idCategoria, precioIni, precioFin);

	}

	/**
	 * este metodo recupera una lista de porductos por la id de la categoria
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductoTiendaPojo> leerProductoTiendaCategoriaid(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductosTiendaCategoriaid(id);

	}

	/**
	 * este metodo recupera una lista de porductos por la id de la marca
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductoTiendaPojo> leerProductoTiendaMarcaid(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductosTiendaMarcaid(id);

	}

	/**
	 * este metodo cuenta los productos por la id de la categoria
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ProductoTiendaPojo contarProductoCategoria(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.contarProductoCategoria(id);

	}

	/**
	 * este metodo cuenta los productos por la id de la marca
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ProductoTiendaPojo contarProductoMarca(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.contarProductoMarca(id);

	}

	/**
	 * este metod recupera una lista filtrando por nombre de producto
	 * 
	 * @param titulo
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<BusquedaPojo> BuscarProductoporNombre(String titulo) throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.BuscarProductoporNombre(titulo);

	}

	/**
	 * este metodo recupera una lista filtrado por nombre de producto
	 * 
	 * @param titulo
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductoTiendaPojo> BuscarProductoporNombreTienda(String titulo) throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.BuscarProductoporNombreTienda(titulo);

	}

	/**
	 * este metodo elimina un producto por su id
	 * 
	 * @param id
	 */
	public void eliminarProducto(int id) {

		ProductosDao ProductoDao = new ProductosDao();

		ProductoDao.eliminarProducto(id);

	}

	/**
	 * este metodo modifica un producto
	 * 
	 * @param accidente
	 */
	public void updateProducto(ProductoPojo producto) {
		ProductosDao Productodao = new ProductosDao();

		Productodao.updateProducto(producto);
	}

	/**
	 * este metodo modifica el stock de los productos
	 * 
	 * @param stock
	 * @param cantidad
	 * @param idProducto
	 */
	public void updateProductoCantidad(int stock, int cantidad, int idProducto) {
		ProductosDao Productodao = new ProductosDao();

		Productodao.updateProductoCantidad(stock, cantidad, idProducto);
	}

	/**
	 * este metodo inserta un producto nuevo
	 * 
	 * @param accidente
	 */

	public void insertProducto(ProductoPojo producto) {
		ProductosDao Productodao = new ProductosDao();

		Productodao.insertProducto(producto);
	}

}
