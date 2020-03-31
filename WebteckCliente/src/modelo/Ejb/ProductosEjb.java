package modelo.Ejb;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import modelo.Pojo.BusquedasPojo;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.ProductosPojo;
import modelo.Pojo.ProductosTiendaPojo;
@Stateless
@LocalBean
public class ProductosEjb {

	public ArrayList<ProductosPojo> leerTotalProductos() {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckCliente/ControladorRest/leerTotalProductos/patata23");

		ArrayList<ProductosPojo> lista = (ArrayList<ProductosPojo>) target1.request()
				.get(new GenericType<List<ProductosPojo>>() {
				});

		return lista;
	}

	/**
	 * tenemos un arraylist de los tipos de accidentes
	 * 
	 * @return
	 */

	public ArrayList<MarcasPojo> leerTotalMarcas() {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/WebteckCliente/ControladorRest/leerTotalMarcas/patata23");

		ArrayList<MarcasPojo> lista = (ArrayList<MarcasPojo>) target1.request()
				.get(new GenericType<List<MarcasPojo>>() {
				});

		return lista;
	}

	public ArrayList<CategoriasPojo> leerTotalCategorias() {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckCliente/ControladorRest/leerTotalCategorias/patata23");

		ArrayList<CategoriasPojo> lista = (ArrayList<CategoriasPojo>) target1.request()
				.get(new GenericType<List<CategoriasPojo>>() {
				});

		return lista;
	}

	/**
	 * tenemos un arraylist de los tipos de accidentes
	 * 
	 * @return
	 */

	public ArrayList<BusquedasPojo> BuscarProductoporNombre(String titulo) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/SeguridadVial/ControladorRest/BuscarProductoporNombre/patata23/" + titulo);

		ArrayList<BusquedasPojo> lista = (ArrayList<BusquedasPojo>) target1.request()
				.get(new GenericType<List<BusquedasPojo>>() {
				});

		return lista;
	}

	public ArrayList<ProductosTiendaPojo> BuscarProductoporNombreTienda(String titulo) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckCliente/ControladorRest/BuscarProductoporNombre/patata23/" + titulo);

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});

		return lista;
	}

	public ProductosPojo leerProducto(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckCliente/ControladorRest/leerProducto/patata23/" + id);

		ProductosPojo prod = target1.request().get(ProductosPojo.class);

		return prod;
	}

}
