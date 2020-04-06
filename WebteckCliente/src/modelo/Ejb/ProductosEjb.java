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

	public ArrayList<ProductosTiendaPojo> leerTotalProductos() {

		Client cliente = ClientBuilder.newClient();
		
		WebTarget target1 = cliente.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getTotalProductos/patata23");

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
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

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/leerTotalMarcas/patata23");

		ArrayList<MarcasPojo> lista = (ArrayList<MarcasPojo>) target1.request()
				.get(new GenericType<List<MarcasPojo>>() {
				});

		return lista;
	}

	public ArrayList<CategoriasPojo> leerTotalCategorias() {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getTipoCategoria/patata23");

		ArrayList<CategoriasPojo> lista = (ArrayList<CategoriasPojo>) target1.request()
				.get(new GenericType<List<CategoriasPojo>>() {
				});

		return lista;
	}


	public ArrayList<ProductosTiendaPojo> BuscarProductoporNombreTienda(String titulo) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/getProductoporNombre/patata23/" + titulo);

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});

		return lista;
	}

	public ArrayList<ProductosTiendaPojo> leerProducto(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getProductoTienda/patata23/" + id);

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});
		return lista;
	}

}
