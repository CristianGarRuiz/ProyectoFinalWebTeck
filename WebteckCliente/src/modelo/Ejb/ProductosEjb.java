package modelo.Ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.ProductosTiendaPojo;

@Stateless
@LocalBean
public class ProductosEjb {

	/**
	 * este metodo recupera todos los productos
	 * 
	 * @return
	 */

	public ArrayList<ProductosTiendaPojo> leerTotalProductos() {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getTotalProductos/patata23");

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});

		return lista;
	}

	/**
	 * este metodo recupera todos los productos mejor valorados
	 * 
	 * @return
	 */
	public ArrayList<ProductosTiendaPojo> leerTotalProductosMedia() {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getTopMediaProductos/patata23");

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});

		return lista;
	}

	/**
	 * tenemos un arraylist de los tipos de marcas
	 * 
	 * @return
	 */

	public ArrayList<MarcasPojo> leerTotalMarcas() {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getTipoMarca/patata23");

		ArrayList<MarcasPojo> lista = (ArrayList<MarcasPojo>) target1.request()
				.get(new GenericType<List<MarcasPojo>>() {
				});

		return lista;
	}

	/**
	 * este metodo recupera una lista de categorias
	 * 
	 * @return
	 */
	public ArrayList<CategoriasPojo> leerTotalCategorias() {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getTipoCategoria/patata23");

		ArrayList<CategoriasPojo> lista = (ArrayList<CategoriasPojo>) target1.request()
				.get(new GenericType<List<CategoriasPojo>>() {
				});

		return lista;
	}

	/**
	 * este metodo recupera una lista de productos por nombre
	 * 
	 * @param titulo
	 * @return
	 */
	public ArrayList<ProductosTiendaPojo> BuscarProductoporNombreTienda(String titulo) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/getProductoporNombre/patata23/" + titulo);

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});

		return lista;
	}

	/**
	 * este metod recupero una lista de productos por id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductosTiendaPojo> leerProducto(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getProductoTienda/patata23/" + id);

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});
		return lista;
	}

	/**
	 * este metodo recupera los productos por id de categoria
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductosTiendaPojo> leerProductoidCategoria(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/getProductoTiendaCategoriaid/patata23/" + id);

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});
		return lista;
	}

	/**
	 * este metodo recupera los productos por la id de la marca
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<ProductosTiendaPojo> leerProductoidMarca(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/getProductoTiendaMarcaid/patata23/" + id);

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});
		return lista;
	}

	/**
	 * este metodo cuenta los prodcutos por la id de la categoria
	 * 
	 * @param id
	 * @return
	 */
	public ProductosTiendaPojo contarProductosporCategoria(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/contarProductoporCategoria/patata23/" + id);

		ProductosTiendaPojo prod = target1.request().get(ProductosTiendaPojo.class);

		return prod;
	}

	/**
	 * este metodo cuenta los productos por la de id de la marca
	 * 
	 * @param id
	 * @return
	 */
	public ProductosTiendaPojo contarProductosporMarca(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/contarProductoporMarca/patata23/" + id);

		ProductosTiendaPojo prod = target1.request().get(ProductosTiendaPojo.class);

		return prod;
	}

	/**
	 * este metodo recupera un producto por su id
	 * 
	 * @param id
	 * @return
	 */
	public ProductosTiendaPojo ProductoporSuID(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/ProductoporID/patata23/" + id);

		ProductosTiendaPojo prod = target1.request().get(ProductosTiendaPojo.class);

		return prod;
	}

	/**
	 * este metodo recuper una lista de categoria por la id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<CategoriasPojo> leerCategoriaId(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getCategoriaId/patata23/" + id);

		ArrayList<CategoriasPojo> lista = (ArrayList<CategoriasPojo>) target1.request()
				.get(new GenericType<List<CategoriasPojo>>() {
				});
		return lista;
	}

	/**
	 * este metod recupera una lista de marcas por id
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<MarcasPojo> leerMarcasId(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getMarcaId/patata23/" + id);

		ArrayList<MarcasPojo> lista = (ArrayList<MarcasPojo>) target1.request()
				.get(new GenericType<List<MarcasPojo>>() {
				});

		return lista;
	}

	/**
	 * este metodo modifca el stock del producto
	 * 
	 * @param stock
	 * @param cantidad
	 * @param idProducto
	 */
	public void updateCarritoCantidad(int stock, int cantidad, int idProducto) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/updateCantidadProducto/patata23/" + stock
						+ "/" + cantidad + "/" + idProducto);

		target2.request().get();
	}

	/**
	 * este metodo aplica los filtro a un producto y recupera ese porducto con los
	 * parametro
	 * 
	 * @param idMarca
	 * @param idCategoria
	 * @param precioIni
	 * @param precioFin
	 * @return
	 */
	public ArrayList<ProductosTiendaPojo> leerProductosFiltro(int idMarca, int idCategoria, int precioIni,
			int precioFin) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/leerProductosFiltro/patata23/" + idMarca
						+ "/" + idCategoria + "/" + precioIni + "/" + precioFin);

		ArrayList<ProductosTiendaPojo> lista = (ArrayList<ProductosTiendaPojo>) target1.request()
				.get(new GenericType<List<ProductosTiendaPojo>>() {
				});
		return lista;
	}

}
