package modelo.Ejb;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import modelo.Pojo.ValorcionesPojo;

@Stateless
@LocalBean
public class ValoracionesEjb {

	/**
	 * apartir de un nuevo accidente del pojo crea un accidente
	 * 
	 * @param accidente
	 */
	public void newValoraciones(ValorcionesPojo valor) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target2 = cliente.target("http://localhost:8080/WebteckEmpleado/ControladorRest/newValoracion/patata23");

		target2.request().put(Entity.json(valor));
	}

}
