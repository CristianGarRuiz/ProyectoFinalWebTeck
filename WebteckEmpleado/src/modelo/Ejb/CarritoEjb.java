package modelo.Ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Pojo.CarritoPojo;
import modelo.dao.CarritoDao;
@Stateless
@LocalBean
public class CarritoEjb {

	public void insertProductoCarrito(CarritoPojo carrito) {
		CarritoDao CarritoDao = new CarritoDao();

		CarritoDao.insertProductoCarrito(carrito);
	}

	public void eliminarProductoCarrito(int idProducto,String emailUsuario) {

		CarritoDao CarritoDao = new CarritoDao();

		CarritoDao.eliminarProductoCarro(idProducto, emailUsuario);

	}

	public ArrayList<CarritoPojo> ProductoCarritoporEmail(String emailUsuario) throws SQLException {

		CarritoDao CarritoDao = new CarritoDao();
		return CarritoDao.ProductoCarritoporEmail(emailUsuario);

	}
	
	public CarritoPojo SumaCarrito(String emailUsuario) throws SQLException {

		CarritoDao CarritoDao = new CarritoDao();
		return CarritoDao.SumaCarrito(emailUsuario);

	}
	

	public CarritoPojo contarProductoCarrito(String emailUsuario) throws SQLException {

		CarritoDao CarritoDao = new CarritoDao();
		return CarritoDao.contarProductoCarrito(emailUsuario);

	}
	
	public CarritoPojo contarProductoCarritoCantidad(int idProducto, String emailUsuario) throws SQLException {

		CarritoDao CarritoDao = new CarritoDao();
		return CarritoDao.contarProductoCarritoCantidad(idProducto, emailUsuario);

	}
}
