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

import modelo.Ejb.CarritoEjb;
import modelo.Ejb.DireccionEjb;
import modelo.Ejb.PreguntaEjb;
import modelo.Ejb.ProductoEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Ejb.ValoracionEjb;
import modelo.Ejb.VentasEjb;
import modelo.Pojo.CarritoPojo;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.DireccionPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.PreguntaPojo;
import modelo.Pojo.ProductoPojo;
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

	@EJB
	DireccionEjb direccionEjb;

	@EJB
	CarritoEjb carritoEjb;

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
	@Path("/CountProductoCarritoCantidad/{token}/{idProducto}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public CarritoPojo contarProductoCarritoCantidad(@PathParam("token") String token,
			@PathParam("idProducto") int idProducto, @PathParam("emailUsuario") String emailUsuario)
			throws SQLException {
		CarritoPojo carrito = null;
		if (token.equals("patata23")) {

			carrito = carritoEjb.contarProductoCarritoCantidad(idProducto, emailUsuario);
		}
		return carrito;
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
	@Path("/leerProductosFiltro/{token}/{idMarca}/{idCategoria}/{precioIni}/{precioFin}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProductoTiendaPojo> productosFiltro(@PathParam("token") String token,
			@PathParam("idMarca") int idMarca, @PathParam("idCategoria") int idCategoria, @PathParam("precioIni") int precioIni, @PathParam("precioFin") int precioFin)
			throws SQLException {

		ArrayList<ProductoTiendaPojo> producto = null;
		if (token.equals("patata23")) {
			producto = productoEjb.productosFiltro(idMarca, idCategoria, precioIni, precioFin);
		}
		return producto;
	}
	
	

	@GET
	@Path("/getProductoTiendaMarcaid/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProductoTiendaPojo> getProductoTiendaMarcaId(@PathParam("token") String token,
			@PathParam("id") int id) throws SQLException {

		ArrayList<ProductoTiendaPojo> producto = null;
		if (token.equals("patata23")) {
			producto = productoEjb.leerProductoTiendaMarcaid(id);
		}
		return producto;
	}
	
	
	

	@GET
	@Path("/getProductoTiendaCategoriaid/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ProductoTiendaPojo> getProductoTiendaCategoriaId(@PathParam("token") String token,
			@PathParam("id") int id) throws SQLException {

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
	@Path("/contarUsuarios/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public int contarUsuarios(@PathParam("token") String token)
			throws SQLException {

		int usuario = -1;
		if (token.equals("patata23")) {
			usuario = usuarioEjb.contarUsuarios();
		}
		System.out.println(usuario);
		return usuario;
	}
	

	@GET
	@Path("/contarProductoCarrito/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public CarritoPojo contarProductoCarro(@PathParam("token") String token,
			@PathParam("emailUsuario") String emailUsuario) throws SQLException {

		CarritoPojo carrito = null;
		if (token.equals("patata23")) {
			carrito = carritoEjb.contarProductoCarrito(emailUsuario);
		}
		return carrito;
	}

	@GET
	@Path("/contarProductoporMarca/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductoTiendaPojo contarProductoMarca(@PathParam("token") String token, @PathParam("id") int id)
			throws SQLException {

		ProductoTiendaPojo producto = null;
		if (token.equals("patata23")) {
			producto = productoEjb.contarProductoMarca(id);
		}
		return producto;
	}
	
	
	@GET
	@Path("/comprobarnombreUsuario/{token}/{usuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioPojo comprobarUsuario(@PathParam("token") String token, @PathParam("usuario") String NombreUsuario)
			throws SQLException {

		UsuarioPojo usuario = null;
		if (token.equals("patata23")) {
			usuario = usuarioEjb.comprobarUsuario(NombreUsuario);
		}
		return usuario;
	}
	
	
	@GET
	@Path("/comprobaremailUsuario/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioPojo comprobarEmailUsuario(@PathParam("token") String token, @PathParam("emailUsuario") String emailUsuario)
			throws SQLException {

		UsuarioPojo usuario = null;
		if (token.equals("patata23")) {
			usuario = usuarioEjb.comprobarEmailUsario(emailUsuario);
		}
		return usuario;
	}

	@GET
	@Path("/contarSumaCarrito/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public CarritoPojo sumaCarrito(@PathParam("token") String token, @PathParam("emailUsuario") String emailUsuario)
			throws SQLException {

		CarritoPojo sumaCarr = null;
		if (token.equals("patata23")) {
			sumaCarr = carritoEjb.SumaCarrito(emailUsuario);
		}
		return sumaCarr;
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

	@GET
	@Path("/getCarrito/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CarritoPojo> getCarritoporEmail(@PathParam("token") String token,
			@PathParam("emailUsuario") String emailUsuario) throws SQLException {

		ArrayList<CarritoPojo> leerCarritoEmail = null;
		if (token.equals("patata23")) {
			leerCarritoEmail = carritoEjb.ProductoCarritoporEmail(emailUsuario);
		}
		return leerCarritoEmail;
	}

	@GET
	@Path("/getMarcaId/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<MarcaPojo> getMarcaporId(@PathParam("token") String token, @PathParam("id") int id)
			throws SQLException {

		ArrayList<MarcaPojo> leerMarcaId = null;
		if (token.equals("patata23")) {
			leerMarcaId = productoEjb.leerMarcaId(id);
		}
		return leerMarcaId;
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
	@Path("/nuevoUsuario/{token}/{usu}/{codigo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void newUsuario(@PathParam("token") String token, UsuarioPojo usu, @PathParam("codigo") int codigo)
			throws SQLException {

		if (token.equals("patata23")) {
			usuarioEjb.añadirUsuario(usu, codigo);
		}
	}

	@PUT
	@Path("/insertCarro/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void newProductoCarro(@PathParam("token") String token, CarritoPojo carrito) throws SQLException {

		if (token.equals("patata23")) {
			carritoEjb.insertProductoCarrito(carrito);
		}
	}

	@PUT
	@Path("/activarUsu/{token}/{codigo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void activarUsuario(@PathParam("token") String token, @PathParam("codigo") int codigo) throws SQLException {

		if (token.equals("patata23")) {
			usuarioEjb.activarUsuario(codigo);
		}
	}

	@GET
	@Path("/pantallaUsu/{token}/{pantalla}/{usuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public void pantallaUsuario(@PathParam("token") String token, @PathParam("pantalla") String pantalla,
			@PathParam("usuario") String usuario) throws SQLException {

		if (token.equals("patata23")) {
			usuarioEjb.pantallaUsuario(pantalla, usuario);
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

	@PUT
	@Path("/newDireccion/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public void newDireccion(@PathParam("token") String token, DireccionPojo direccion) throws SQLException {

		if (token.equals("patata23")) {
			direccionEjb.insertDireccion(direccion);
		}
	}

	@PUT
	@Path("/insertVenta/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public void newVenta(@PathParam("token") String token, VentasPojo venta) throws SQLException {

		if (token.equals("patata23")) {
			ventasEjb.insertarVenta(venta);
		}
	}

	@GET
	@Path("/getDireccion/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<DireccionPojo> leerDirecciones(@PathParam("token") String token,
			@PathParam("emailUsuario") String emailUsuario) throws SQLException {
		ArrayList<DireccionPojo> direcciones = null;

		if (token.equals("patata23")) {

			direcciones = direccionEjb.leerDirecciones(emailUsuario);
		}
		return direcciones;
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
	public void dropUsuarios(@PathParam("token") String token, @PathParam("emailUsuario") String emailUsuario)
			throws SQLException {
		if (token.equals("patata23")) {
			usuarioEjb.eliminarUsuario(emailUsuario);
		}
	}

	@DELETE
	@Path("/dropCarrito/{token}/{idProducto}/{emailUsuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void dropProductoCarrito(@PathParam("token") String token, @PathParam("idProducto") int idProducto,
			@PathParam("emailUsuario") String emailUsuario) throws SQLException {
		if (token.equals("patata23")) {
			carritoEjb.eliminarProductoCarrito(idProducto, emailUsuario);
		}
	}

	@DELETE
	@Path("/dropDireccion/{token}/{emailUsuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void dropDireccion(@PathParam("token") String token, @PathParam("emailUsuario") String emailUsuario)
			throws SQLException {
		if (token.equals("patata23")) {
			direccionEjb.eliminarDireccion(emailUsuario);
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
	@Path("/getDatosUsuario/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<UsuarioPojo> getDatosUsuarioporEmailUsuario(@PathParam("token") String token,
			@PathParam("emailUsuario") String emailUsuario) throws SQLException {
		ArrayList<UsuarioPojo> datosUsu = null;
		if (token.equals("patata23")) {

			datosUsu = usuarioEjb.getDatosUsuarioporEmailUsuario(emailUsuario);
		}
		return datosUsu;
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

	@PUT
	@Path("/updateDireccion/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void updateJugador(@PathParam("token") String token, DireccionPojo direccion) {

		if (token.equals("patata23")) {
			direccionEjb.updateDireccion(direccion);
		}

	}

	@PUT
	@Path("/updateFoto/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void updateImagen(@PathParam("token") String token, UsuarioPojo usu) {

		if (token.equals("patata23")) {
			usuarioEjb.updateImagen(usu);
		}

	}

	@GET
	@Path("/updateCantidadProducto/{token}/{stock}/{cantidad}/{idProducto}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void updateCantidadProducto(@PathParam("token") String token, @PathParam("stock") int stock,
			@PathParam("cantidad") int cantidad, @PathParam("idProducto") int idProducto) {

		if (token.equals("patata23")) {
			productoEjb.updateProductoCantidad(stock, cantidad, idProducto);
		}

	}

	@GET
	@Path("/getDirecciones/{token}/{emailUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public DireccionPojo direccionPorNombre(@PathParam("token") String token,
			@PathParam("emailUsuario") String emailUsuario) throws SQLException {

		DireccionPojo direccion = null;
		if (token.equals("patata23")) {
			direccion = direccionEjb.direccionPorNombre(emailUsuario);
		}
		return direccion;
	}

	@GET
	@Path("/ProductoporID/{token}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductoPojo ProductoporSuid(@PathParam("token") String token, @PathParam("id") int id) throws SQLException {

		ProductoPojo producto = null;
		if (token.equals("patata23")) {
			producto = productoEjb.leerProducto(id);
		}
		return producto;
	}
}
