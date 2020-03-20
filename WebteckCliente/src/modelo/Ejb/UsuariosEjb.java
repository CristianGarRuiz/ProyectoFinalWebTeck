package modelo.Ejb;

import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import modelo.Pojo.UsuariosPojo;

@LocalBean
@Stateless
public class UsuariosEjb {
	
	public UsuariosPojo leerDatos(String user, String pass) {
		Client cliente = ClientBuilder.newClient();

		WebTarget target1 = cliente.target("http://localhost:8080/SeguridadVial/controlador/getUsuario/patata23/" + user + "/" + pass);


		UsuariosPojo usuario = target1.request().get(UsuariosPojo.class);

		return usuario;

	}
	

}
