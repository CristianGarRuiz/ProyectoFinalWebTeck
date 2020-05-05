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

	public void añadirProductoCarro(CarritosPojo carrito) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/insertCarro/patata23");

		target2.request().put(Entity.json(carrito));
	}

	public ArrayList<CarritosPojo> leerCarrito(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getCarrito/patata23/" + emailUsuario);

		ArrayList<CarritosPojo> lista = (ArrayList<CarritosPojo>) target1.request()
				.get(new GenericType<List<CarritosPojo>>() {
				});
		return lista;
	}

	public void eliminarProductoCarro(int idProducto, String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente.target("http://localhost:8080/WebteckEmpleado/ControladorRest/dropCarrito/patata23/"
				+ idProducto + "/" + emailUsuario);

		target2.request().delete(CarritosPojo.class);
	}

	public CarritosPojo contarProductosCarrito(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/contarProductoCarrito/patata23/" + emailUsuario);

		CarritosPojo Totalcarrito = target1.request().get(CarritosPojo.class);

		return Totalcarrito;
	}

	public CarritosPojo contarProductosCantidadCarro(int idProducto, String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/CountProductoCarritoCantidad/patata23/"
						+ idProducto + "/" + emailUsuario);

		CarritosPojo Totalcarrito = target1.request().get(CarritosPojo.class);

		return Totalcarrito;
	}
	

	public CarritosPojo sumaCarro(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/contarSumaCarrito/patata23/" + emailUsuario);

		CarritosPojo prod = target1.request().get(CarritosPojo.class);

		return prod;
	}


}
