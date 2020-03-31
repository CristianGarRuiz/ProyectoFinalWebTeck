package modelo.Ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import modelo.Pojo.PreguntasPojo;

public class PreguntasEjb {

	public ArrayList<PreguntasPojo> RespuestaPreguntas(String pregunta) {

		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente
				.target("http://localhost:8080/WebteckEmpleado/ControladorRest/getRespuestaPreguntas/patata23/"  + pregunta);

		ArrayList<PreguntasPojo> lista = (ArrayList<PreguntasPojo>) target1.request().get(new GenericType<List<PreguntasPojo>>() {
				});

		return lista;
	}

}
