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

import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.ValorcionesPojo;

@Stateless
@LocalBean
public class ValoracionesEjb {

	/**
	 * apartir de un nuevo accidente del pojo crea un accidente
	 * 
	 * @param accidente
	 */
	public void añadirValoracion(ValorcionesPojo valor) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/newValoracion/patata23");

		target2.request().put(Entity.json(valor));
	}

	public void añadirComentario(ValorcionesPojo valor) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/newComentario/patata23");

		target2.request().put(Entity.json(valor));
	}

	public ArrayList<ValorcionesPojo> leerComentario(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getComentarios/patata23/" + id);

		ArrayList<ValorcionesPojo> lista = (ArrayList<ValorcionesPojo>) target1.request()
				.get(new GenericType<List<ValorcionesPojo>>() {
				});
		return lista;
	}

	public ArrayList<ValorcionesPojo> leerValoracion(int id) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getValoraciones/patata23/" + id);

		ArrayList<ValorcionesPojo> lista = (ArrayList<ValorcionesPojo>) target1.request()
				.get(new GenericType<List<ValorcionesPojo>>() {
				});
		return lista;
	}

}
