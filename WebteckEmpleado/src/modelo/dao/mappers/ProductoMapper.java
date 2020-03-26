package modelo.dao.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;

import modelo.Pojo.BusquedaPojo;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.ProductoPojo;

public interface ProductoMapper {
	
	public ProductoPojo leerProductos(@Param("id") int id);
	
	public ArrayList<BusquedaPojo> BuscarProductoporNombre(@Param("titulo") String titulo);

	public void eliminarProducto(@Param("id") int id);

	public void updateProducto(ProductoPojo producto);

	public void insertProducto(ProductoPojo producto);

	public ArrayList<ProductoPojo> leerTotalProductos();

	public ArrayList<MarcaPojo> leerTotalMarcas();

	public ArrayList<CategoriaPojo> leerTotalCategorias();
	
}
