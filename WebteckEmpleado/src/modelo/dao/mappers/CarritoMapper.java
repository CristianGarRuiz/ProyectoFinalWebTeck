package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import modelo.Pojo.CarritoPojo;

public interface CarritoMapper {

	/**
	 * este metodo lee el carrito por email de usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public ArrayList<CarritoPojo> ProductoCarritoporEmail(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo elimina productos del carrito por id del producto y por email de
	 * usuario
	 * 
	 * @param idProducto
	 * @param emailUsuario
	 */
	public void eliminarProductoCarrito(@Param("idProducto") int idProducto,
			@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo inserta porductos al carrito
	 * 
	 * @param carrito
	 */
	public void insertProductoCarrito(CarritoPojo carrito);

	/**
	 * este metodo cuenta los porductos de carro del cliente por su email
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public CarritoPojo contarProductoCarrito(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo suma la cantida del precio del carrito de los porductos
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public CarritoPojo SumaCarrito(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo cuenta la cantida de prodcutos del carro
	 * 
	 * @param idProducto
	 * @param emailUsuario
	 * @return
	 */
	public CarritoPojo contarProductoCarritoCantidad(@Param("idProducto") int idProducto,
			@Param("emailUsuario") String emailUsuario);

}
