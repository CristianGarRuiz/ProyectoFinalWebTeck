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
import modelo.Pojo.DireccionesPojo;

@LocalBean
@Stateless
public class DireccionesEjb {

	public void añadirDireccion(DireccionesPojo direccion) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/newDireccion/patata23");

		target2.request().put(Entity.json(direccion));
	}

	public ArrayList<DireccionesPojo> leerDatosporMail(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target(
				"http://localhost:8080/WebteckEmpleado/ControladorRest/getDireccion/patata23/" + emailUsuario);

		ArrayList<DireccionesPojo> lista = (ArrayList<DireccionesPojo>) target1.request()
				.get(new GenericType<List<DireccionesPojo>>() {
				});

		return lista;
	}

	public DireccionesPojo getDireccion(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getDirecciones/patata23/" + emailUsuario);

		DireccionesPojo diree = target1.request().get(DireccionesPojo.class);

		return diree;
	}
	public void updateDireccion(DireccionesPojo direccion) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente.target("http://localhost:8080/WebteckEmpleado/ControladorRest/updateDireccion/patata23");

		target2.request().put(Entity.json(direccion));
	}
	
	public void eliminarDireccion(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/dropDireccion/patata23/" + emailUsuario);

		target2.request().delete(DireccionesPojo.class);
	}

	
}
