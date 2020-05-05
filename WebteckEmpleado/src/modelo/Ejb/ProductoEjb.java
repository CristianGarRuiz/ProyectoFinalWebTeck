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

	public ArrayList<ProductoPojo> leerTotalProductos() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalProductos();
	}
	
	public ArrayList<ProductoTiendaPojo> leerTotalTienda() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalTienda();
	}
	
	public ArrayList<ProductoTiendaPojo> leerTotalProductosMedia() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalProductosMedia();
	}

	public ArrayList<MarcaPojo> leerTotalMarcas() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalMarcas();
	}

	public ArrayList<CategoriaPojo> leerTotalCategorias() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalCategorias();
	}
	
	public ProductoPojo leerProducto(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductos(id);

	}
	
	
	
	
	public ArrayList<CategoriaPojo> leerCategoriaId(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerCategoriaId(id);

	}
	
	
	public ArrayList<MarcaPojo> leerMarcaId(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerMarcaId(id);

	}
	
	public ArrayList<ProductoTiendaPojo> leerProductoTienda(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductosTienda(id);

	}
	public ArrayList<ProductoTiendaPojo> leerProductoTiendaCategoriaid(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductosTiendaCategoriaid(id);

	}
	
	public ArrayList<ProductoTiendaPojo> leerProductoTiendaMarcaid(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductosTiendaMarcaid(id);

	}
	
	public ProductoTiendaPojo contarProductoCategoria(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.contarProductoCategoria(id);

	}
	
	public ProductoTiendaPojo contarProductoMarca(int id) throws SQLException {

		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.contarProductoMarca(id);

	}
	
	
	
	public ArrayList<BusquedaPojo> BuscarProductoporNombre(String titulo)  throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.BuscarProductoporNombre(titulo);

	}
	
	public ArrayList<ProductoTiendaPojo> BuscarProductoporNombreTienda(String titulo)  throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.BuscarProductoporNombreTienda(titulo);

	}
	
	
	public void eliminarProducto(int id) {

		ProductosDao ProductoDao = new ProductosDao();

		ProductoDao.eliminarProducto(id);

	}

	/**
	 * este metodo modifica un accidente
	 * 
	 * @param accidente
	 */
	public void updateProducto(ProductoPojo producto) {
		ProductosDao Productodao = new ProductosDao();

		Productodao.updateProducto(producto);
	}

	
	public void updateProductoCantidad(int stock, int cantidad,int idProducto) {
		ProductosDao Productodao = new ProductosDao();

		Productodao.updateProductoCantidad(stock,cantidad,idProducto);
	}
	
	/**
	 * este metodo inserta un accidente
	 * 
	 * @param accidente
	 */

	public  void insertProducto(ProductoPojo producto) {
		ProductosDao Productodao = new ProductosDao();

		Productodao.insertProducto(producto);
	}
	

	
}
