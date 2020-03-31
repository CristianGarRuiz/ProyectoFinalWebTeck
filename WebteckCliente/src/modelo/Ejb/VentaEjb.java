package modelo.Ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import modelo.Pojo.VentaPojo;

@Stateless
@LocalBean
public class VentaEjb {

	public ArrayList<VentaPojo> leerProductosporEmail(String emailUsuario) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckCliente/ControladorRest/leerProductosporEmail/patata23/"
						+ emailUsuario);

		ArrayList<VentaPojo> lista = (ArrayList<VentaPojo>) target1.request().get(new GenericType<List<VentaPojo>>() {
		});

		return lista;
	}
}