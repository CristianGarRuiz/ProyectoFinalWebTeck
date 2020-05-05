package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import modelo.Pojo.CarritoPojo;
public interface CarritoMapper {

	public ArrayList<CarritoPojo> ProductoCarritoporEmail(@Param("emailUsuario") String emailUsuario);

	public void eliminarProductoCarrito(@Param("idProducto") int idProducto,@Param("emailUsuario") String emailUsuario);

	public void insertProductoCarrito(CarritoPojo carrito);

	public CarritoPojo contarProductoCarrito(@Param("emailUsuario") String emailUsuario);
	
	public CarritoPojo SumaCarrito(@Param("emailUsuario") String emailUsuario);
	
	public CarritoPojo contarProductoCarritoCantidad(@Param("idProducto") int idProducto, @Param("emailUsuario") String emailUsuario);

}
