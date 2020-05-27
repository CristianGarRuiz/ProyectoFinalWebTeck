package modelo.Ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Pojo.CarritoPojo;
import modelo.dao.CarritoDao;

@Stateless
@LocalBean

/**
 * esta clase tiene todo los metodos que recogen los valores que le llegan la
 * dao
 * 
 * @author cristian
 *
 */
public class CarritoEjb {

	/**
	 * este metodo inserta productos al carro
	 * 
	 * @param carrito
	 */
	public void insertProductoCarrito(CarritoPojo carrito) {
		CarritoDao CarritoDao = new CarritoDao();

		CarritoDao.insertProductoCarrito(carrito);
	}

	/**
	 * este metodo elimina porductos por la id del porductos y el email de usuario
	 * 
	 * @param idProducto
	 * @param emailUsuario
	 */
	public void eliminarProductoCarrito(int idProducto, String emailUsuario) {

		CarritoDao CarritoDao = new CarritoDao();

		CarritoDao.eliminarProductoCarro(idProducto, emailUsuario);

	}

	/**
	 * este metodo recupera una lista de porductos por email de usuario
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CarritoPojo> ProductoCarritoporEmail(String emailUsuario) throws SQLException {

		CarritoDao CarritoDao = new CarritoDao();
		return CarritoDao.ProductoCarritoporEmail(emailUsuario);

	}

	/**
	 * este metodo suma los precios de los porductos del carro
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */
	public CarritoPojo SumaCarrito(String emailUsuario) throws SQLException {

		CarritoDao CarritoDao = new CarritoDao();
		return CarritoDao.SumaCarrito(emailUsuario);

	}

	/**
	 * este metodo cuenta los porductos del carro por el email del usuario
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */
	public CarritoPojo contarProductoCarrito(String emailUsuario) throws SQLException {

		CarritoDao CarritoDao = new CarritoDao();
		return CarritoDao.contarProductoCarrito(emailUsuario);

	}

	/**
	 * este metodo cuenta los porductos la cantida por la id del porductos y por el
	 * email del usuario
	 * 
	 * @param idProducto
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */
	public CarritoPojo contarProductoCarritoCantidad(int idProducto, String emailUsuario) throws SQLException {

		CarritoDao CarritoDao = new CarritoDao();
		return CarritoDao.contarProductoCarritoCantidad(idProducto, emailUsuario);

	}
}
