package modelo.dao.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;

import modelo.Pojo.BusquedaPojo;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.ProductoPojo;
import modelo.Pojo.ProductoTiendaPojo;

public interface ProductoMapper {
	/**
	 * este metodo recupera productos por su id
	 * 
	 * @param id
	 * @return
	 */
	public ProductoPojo leerProductos(@Param("id") int id);

	/**
	 * este metodo le las categorias por su id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<CategoriaPojo> leerCategoriaId(@Param("id") int id);

	/**
	 * este metodo le las marcas por su id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<MarcaPojo> leerMarcaId(@Param("id") int id);

	/**
	 * este metodo recupera una lista de productos por su id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerProductosTienda(@Param("id") int id);

	/**
	 * este metodo filtra productos por los datos que le pasamos
	 * 
	 * @param idMarca
	 * @param idCategoria
	 * @param precioIni
	 * @param precioFin
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> productosFiltro(@Param("idMarca") int idMarca,
			@Param("idCategoria") int idCategoria, @Param("precioIni") int precioIni,
			@Param("precioFin") int precioFin);

	/**
	 * este metodo recupera una lista de categorias por la id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerProductosCategoriaid(@Param("id") int id);

	/**
	 * este metodo recupera una lista de marcas por su id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerProductosMarcaid(@Param("id") int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProductoTiendaPojo contarProductoCategoria(@Param("id") int id);

	/**
	 * este metodo cuenta los porductos por la id de la marca
	 * 
	 * @param id
	 * @return
	 */
	public ProductoTiendaPojo contarProductoMarca(@Param("id") int id);

	/**
	 * este metodo filtra por nombre de producto
	 * 
	 * @param titulo
	 * @return
	 */
	public ArrayList<BusquedaPojo> BuscarProductoporNombre(@Param("titulo") String titulo);

	/**
	 * este metodo filtra por nombre de producto
	 * 
	 * @param titulo
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> BuscarProductoporNombreTienda(@Param("titulo") String titulo);

	/**
	 * este metodo elimina un prodcuto por su id
	 * 
	 * @param id
	 */
	public void eliminarProducto(@Param("id") int id);

	/**
	 * este metodo modfica un producto
	 * 
	 * @param producto
	 */
	public void updateProducto(ProductoPojo producto);

	/**
	 * este metodo modifica el stock de los productos
	 * 
	 * @param stock
	 * @param cantidad
	 * @param idProducto
	 */
	public void updateProductoCantidad(@Param("stock") int stock, @Param("cantidad") int cantidad,
			@Param("idProducto") int idProducto);

	public void insertProducto(ProductoPojo producto);

	/**
	 * este metodo recupera una lista de productos
	 * 
	 * @return
	 */
	public ArrayList<ProductoPojo> leerTotalProductos();

	/**
	 * este metodo recupera una lista de porductos
	 * 
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerTotalTienda();

	/**
	 * este metodo recuera los porductos con mejor valoracion
	 * 
	 * @return
	 */
	public ArrayList<ProductoTiendaPojo> leerTotalProductosMedia();

	/**
	 * este metodo recupera una lista de las marcas
	 * 
	 * @return
	 */
	public ArrayList<MarcaPojo> leerTotalMarcas();

	/**
	 * este metodo recupera una lista de las categorias
	 * 
	 * @return
	 */
	public ArrayList<CategoriaPojo> leerTotalCategorias();

}
