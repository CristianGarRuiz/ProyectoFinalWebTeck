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

@Stateless
@LocalBean
public class ProductoEjb {

	public ArrayList<ProductoPojo> leerTotalProductos() throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerTotalProductos();
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
	
	public ArrayList<ProductoPojo> leerProductosporNombre(String nombre)  throws SQLException {
		ProductosDao ProductoDao = new ProductosDao();
		return ProductoDao.leerProductosporNombre(nombre);

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