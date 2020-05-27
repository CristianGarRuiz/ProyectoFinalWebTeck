package modelo.Ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import modelo.Pojo.CarritosPojo;

@LocalBean
@Stateless
public class CarritosEjb {

	/**
	 * Este metodo añade un producto al carro
	 * 
	 * @param carrito
	 */
	public void añadirProductoCarro(CarritosPojo carrito) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/insertCarro/patata23");

		target2.request().put(Entity.json(carrito));
	}

	/**
	 * este metodo le los porductos del carro por el emai lde usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */

	public ArrayList<CarritosPojo> leerCarrito(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getCarrito/patata23/" + emailUsuario);

		ArrayList<CarritosPojo> lista = (ArrayList<CarritosPojo>) target1.request()
				.get(new GenericType<List<CarritosPojo>>() {
				});
		return lista;
	}

	/**
	 * este metodo elimina los productos edl carro por id de producto y por email de
	 * usuario
	 * 
	 * @param idProducto
	 * @param emailUsuario
	 */
	public void eliminarProductoCarro(int idProducto, String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente.target("http://localhost:8080/WebteckEmpleado/ControladorRest/dropCarrito/patata23/"
				+ idProducto + "/" + emailUsuario);

		target2.request().delete(CarritosPojo.class);
	}

	/**
	 * este porducto cuenta los prodcutos del carro
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public CarritosPojo contarProductosCarrito(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/contarProductoCarrito/patata23/" + emailUsuario);

		CarritosPojo Totalcarrito = target1.request().get(CarritosPojo.class);

		return Totalcarrito;
	}

	/**
	 * este metodo cuenta la cantidad de porductos del carro
	 * 
	 * @param idProducto
	 * @param emailUsuario
	 * @return
	 */
	public CarritosPojo contarProductosCantidadCarro(int idProducto, String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/CountProductoCarritoCantidad/patata23/"
						+ idProducto + "/" + emailUsuario);

		CarritosPojo Totalcarrito = target1.request().get(CarritosPojo.class);

		return Totalcarrito;
	}

	/**
	 * este metodo suma el precio total de los productos
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public CarritosPojo sumaCarro(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/contarSumaCarrito/patata23/" + emailUsuario);

		CarritosPojo prod = target1.request().get(CarritosPojo.class);

		return prod;
	}

}
