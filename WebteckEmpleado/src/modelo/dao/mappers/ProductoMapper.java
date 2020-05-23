package modelo.dao.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;

import modelo.Pojo.BusquedaPojo;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.ProductoPojo;
import modelo.Pojo.ProductoTiendaPojo;

public interface ProductoMapper {

	public ProductoPojo leerProductos(@Param("id") int id);

	public ArrayList<CategoriaPojo> leerCategoriaId(@Param("id") int id);

	public ArrayList<MarcaPojo> leerMarcaId(@Param("id") int id);

	public ArrayList<ProductoTiendaPojo> leerProductosTienda(@Param("id") int id);
	
	public ArrayList<ProductoTiendaPojo> productosFiltro(@Param("idMarca") int idMarca,@Param("idCategoria") int idCategoria,
			@Param("precioIni") int precioIni,@Param("precioFin") int precioFin );

	public ArrayList<ProductoTiendaPojo> leerProductosCategoriaid(@Param("id") int id);

	public ArrayList<ProductoTiendaPojo> leerProductosMarcaid(@Param("id") int id);

	public ProductoTiendaPojo contarProductoCategoria(@Param("id") int id);

	public ProductoTiendaPojo contarProductoMarca(@Param("id") int id);

	public ArrayList<BusquedaPojo> BuscarProductoporNombre(@Param("titulo") String titulo);

	public ArrayList<ProductoTiendaPojo> BuscarProductoporNombreTienda(@Param("titulo") String titulo);

	public void eliminarProducto(@Param("id") int id);

	public void updateProducto(ProductoPojo producto);

	public void updateProductoCantidad(@Param("stock") int stock, @Param("cantidad") int cantidad,
			@Param("idProducto") int idProducto);

	public void insertProducto(ProductoPojo producto);

	public ArrayList<ProductoPojo> leerTotalProductos();

	public ArrayList<ProductoTiendaPojo> leerTotalTienda();

	public ArrayList<ProductoTiendaPojo> leerTotalProductosMedia();

	public ArrayList<MarcaPojo> leerTotalMarcas();

	public ArrayList<CategoriaPojo> leerTotalCategorias();

}
