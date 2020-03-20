package modelo.dao.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.ProductoPojo;

public interface ProductoMapper {
	
	public ProductoPojo leerProducto(@Param("id") int id);

	public void eliminarProducto(@Param("id") int id);

	public void updateProducto(ProductoPojo producto);

	public void insertProducto(ProductoPojo producto);

	public ArrayList<ProductoPojo> leerTotalAccidentes();

	public ArrayList<MarcaPojo> leerTotalMarcas();

	public ArrayList<CategoriaPojo> leerTotalCategorias();
	
	

}
