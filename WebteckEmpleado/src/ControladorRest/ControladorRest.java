package ControladorRest;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Ejb.PreguntaEjb;
import modelo.Ejb.ProductoEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Ejb.ValoracionEjb;
import modelo.Ejb.VentasEjb;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.PreguntaPojo;
import modelo.Pojo.ProductoTiendaPojo;
import modelo.Pojo.UsuarioPojo;
import modelo.Pojo.ValorcionPojo;
import modelo.Pojo.VentasPojo;

@Path("/ControladorRest")
public class ControladorRest {

	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	ProductoEjb productoEjb;

	@EJB
	ValoracionEjb valoracionEjb;

	@EJB
	PreguntaEjb preguntaEjb;

	@EJB
	VentasEjb ventasEjb;

	@GET
	@Path("/getUsuario/{token}/{nombre}/{pass}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioPojo getJugador(@PathParam("token") String token, @PathParam("nombre") String nombre,
			@PathParam("pass") String pass) throws SQLException {
		UsuarioPojo usuario = null;
		if (token.equals("patata23")) {

			usuario = usuarioEjb.leerDatos(nombre, pass);
		}
		return usuario;
	}
	@GET
	@Path("/getProductoTienda/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProductoTiendaPojo> getProductoTienda(@PathParam("token") String token, @PathParam("id") int id)
			throws SQLException {

		ArrayList<ProductoTiendaPojo> producto = null;
		if (token.equals("patata23")) {
			producto = productoEjb.leerProductoTienda(id);
		}
		return producto;
	}
	
	@GET
	@Path("/getProductoTiendaCategoriaid/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProductoTiendaPojo> getProductoTiendaCategoriaId(@PathParam("token") String token, @PathParam("id") int id)
			throws SQLException {

		ArrayList<ProductoTiendaPojo> producto = null;
		if (token.equals("patata23")) {
			producto = productoEjb.leerProductoTiendaCategoriaid(id);
		}
		return producto;
	}
	@GET
	@Path("/contarProductoporCategoria/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductoTiendaPojo contarProductoCategoria(@PathParam("token") String token, @PathParam("id") int id)
			throws SQLException {

		ProductoTiendaPojo producto = null;
		if (token.equals("patata23")) {
			producto = productoEjb.contarProductoCategoria(id);
		}
		return producto;
	}
	
	
	@GET
	@Path("/getComentarios/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ValorcionPojo> getComentariosTienda(@PathParam("token") String token, @PathParam("id") int id)
			throws SQLException {

		ArrayList<ValorcionPojo> leerComentarios = null;
		if (token.equals("patata23")) {
			leerComentarios = valoracionEjb.leerComentarioTienda(id);
		}
		return leerComentarios;
	}
	
	
	@GET
	@Path("/getValoraciones/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ValorcionPojo> getValoracionTienda(@PathParam("token") String token, @PathParam("id") int id)
			throws SQLException {

		ArrayList<ValorcionPojo> leerValoraciones = null;
		if (token.equals("patata23")) {
			leerValoraciones = valoracionEjb.leerValoracionTienda(id);
		}
		return leerValoraciones;
	}
	
	
	
	
	@GET
	@Path("/getCategoriaId/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CategoriaPojo> getCategoriaporId(@PathParam("token") String token, @PathParam("id") int id)
			throws SQLException {

		ArrayList<CategoriaPojo> leerCategoriaId = null;
		if (token.equals("patata23")) {
			leerCategoriaId = productoEjb.leerCategoriaId(id);
		}
		return leerCategoriaId;
	}
	
	/**
	 * este metodo retorna todos los tipos de accidentes
	 * 
	 * @return
	 * @throws SQLException
	 */
	@GET
	@Path("/getTipoMarca/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<MarcaPojo> leerTipoAccidente(@PathParam("token") String token) throws SQLException {

		ArrayList<MarcaPojo> tipoMarca = null;

		if (token.equals("patata23")) {
			tipoMarca = productoEjb.leerTotalMarcas();
		}

		return tipoMarca;

	}

	/**
	 * este metodo retorna todos los sexo que hay
	 * 
	 * @return
	 * @throws SQLException
	 */
	@GET
	@Path("/getTipoCategoria/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CategoriaPojo> leerTipoCategoria(@PathParam("token") String token) throws SQLException {

		ArrayList<CategoriaPojo> tipoCategoria = null;
		if (token.equals("patata23")) {
			tipoCategoria = productoEjb.leerTotalCategorias();
		}
		return tipoCategoria;

	}

	@PUT
	@Path("/updateContraseña/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void updateContraseña(@PathParam("token") String token, UsuarioPojo usu) {

		if (token.equals("patata23")) {
			usuarioEjb.updateContraseña(usu);
		}

	}

	@PUT
	@Path("/newUsuario/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public void newUsuario(@PathParam("token") String token, UsuarioPojo usu) throws SQLException {

		if (token.equals("patata23")) {
			usuarioEjb.añadirUsuario(usu);
		}
	}

	@PUT
	@Path("/newValoracion/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public void newValoracion(@PathParam("token") String token, ValorcionPojo valor) throws SQLException {

		if (token.equals("patata23")) {
			valoracionEjb.AñadirValoracion(valor);
		}
	}
	
	
	@PUT
	@Path("/newComentario/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public void newComentario(@PathParam("token") String token, ValorcionPojo valor) throws SQLException {

		if (token.equals("patata23")) {
			valoracionEjb.AñadirComentario(valor);
		}
	}
	
	

	/**
	 * este metodo borra un accidente por la id
	 * 
	 * @param id
	 * @throws SQLException 
	 */
	@DELETE
	@Path("/dropUsuarios/{token}/{emailUsuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void dropUsuarios(@PathParam("token") String token, @PathParam("emailUsuario") String emailUsuario) throws SQLException {
		if (token.equals("patata23")) {
			usuarioEjb.eliminarUsuario(emailUsuario);
		}
	}
	
	

	@GET
	@Path("/getTotalProductos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProductoTiendaPojo> leerTotalProductos(@PathParam("token") String token) throws SQLException {

		ArrayList<ProductoTiendaPojo> productos = null;

		if (token.equals("patata23")) {
			productos = productoEjb.leerTotalTienda();
		}
		return productos;

	}

	@GET
	@Path("/getTopMediaProductos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProductoTiendaPojo> leerTotalProductosMedia(@PathParam("token") String token) throws SQLException {

		ArrayList<ProductoTiendaPojo> productos = null;

		if (token.equals("patata23")) {
			productos = productoEjb.leerTotalProductosMedia();
		}
		return productos;

	}

	@GET
	@Path("/getProductoporNombre/{token}/{titulo}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProductoTiendaPojo> getProductoporNombre(@PathParam("token") String token,
			@PathParam("titulo") String titulo) throws SQLException {
		ArrayList<ProductoTiendaPojo> producto = null;
		if (token.equals("patata23")) {

			producto = productoEjb.BuscarProductoporNombreTienda(titulo);
		}
		return producto;
	}

	@GET
	@Path("/getVenta/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<VentasPojo> leerProductosporEmail(@PathParam("token") String token,
			@PathParam("emailUsuario") String emailUsuario) throws SQLException {
		ArrayList<VentasPojo> venta = null;

		if (token.equals("patata23")) {

			venta = ventasEjb.leerProductosporEmail(emailUsuario);
		}
		return venta;
	}

	@GET
	@Path("/getRespuesta/{token}/{pregunta}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<PreguntaPojo> getRespuestaPreguntas(@PathParam("token") String token,
			@PathParam("pregunta") String pregunta) throws SQLException {
		ArrayList<PreguntaPojo> respuesta = null;

		if (token.equals("patata23")) {

			respuesta = preguntaEjb.getRespuestaPreguntas(pregunta);
		}
		return respuesta;
	}
	
	@GET
	@Path("/leerProductosporEmail/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<VentasPojo> getproductosPorEmail(@PathParam("token") String token,
			@PathParam("emailUsuario") String emailUsuario) throws SQLException {
		ArrayList<VentasPojo> respuesta = null;

		if (token.equals("patata23")) {

			respuesta = ventasEjb.leerProductosporEmail(emailUsuario);
		}
		return respuesta;
	}

}
