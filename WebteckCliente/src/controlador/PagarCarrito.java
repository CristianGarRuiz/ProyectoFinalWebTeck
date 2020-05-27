package controlador;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.Ejb.CarritosEjb;
import modelo.Ejb.DireccionesEjb;
import modelo.Ejb.MailsEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Ejb.VentaEjb;
import modelo.Pojo.CarritosPojo;
import modelo.Pojo.DireccionesPojo;
import modelo.Pojo.ProductosTiendaPojo;
import modelo.Pojo.UsuariosPojo;
import modelo.Pojo.VentaPojo;

@WebServlet("/PagarCarrito")
public class PagarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");

	// EJBS utilizados

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productoEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	CarritosEjb carritoEjb;

	@EJB
	MailsEjb mailsEjb;

	@EJB
	VentaEjb ventaEjb;

	@EJB
	DireccionesEjb direccionEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recojo la session
		HttpSession session = request.getSession();
		// Asocio al usuario loegado
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		// estancio la variable error
		String error = request.getParameter("error");
		// Recojo el email del usuario
		String emailUsuario = usuario.getEmailUsuario();
		// crela variable id que recoge el valor
		String id = request.getParameter("id");
		// la paso a integer
		Integer idProducto = Integer.valueOf(id);

		// Creo un formato de fecha
		String formato = "yyyy-MM-dd HH:mm:ss";
		// lo formateo
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
		// Cojo la hora local actuak
		LocalDateTime ahora = LocalDateTime.now();

		// Genero un numero aleatorio
		int codigo = (int) (Math.random() * 10000 + 1);

		// Cojo la fecha actual
		String data = formateador.format(ahora);

		// Correo de la empresa
		String correoEmpresa = "garciaruizcristian50@gmail.com";

		// Paso los atributos
		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emailUsuario", emailUsuario);

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emailUsuario", emailUsuario);

		// Recojo la direcion de usuario
		DireccionesPojo direccion = direccionEjb.getDireccion(emailUsuario);
		// Compruebo que la direccion no es nula
		if ((direccion != null) && (direccion.getDireccion() != null)) {

			try {

				// recojo los porductos por su id
				ProductosTiendaPojo prod = productoEjb.ProductoporSuID(idProducto);

				// Cuentos los porductos del carrito
				CarritosPojo cantidad1 = carritoEjb.contarProductosCantidadCarro(idProducto, emailUsuario);

				// Recojo el stock
				int stock = prod.getStock();
				// La cantidad
				int cantidad = cantidad1.getIdProducto();

				// Modifico la cantida del producto
				productoEjb.updateCarritoCantidad(stock, cantidad, idProducto);

				// valor de los prodcutos total
				CarritosPojo totalVenta = carritoEjb.sumaCarro(emailUsuario);

				// eliminar el producto del carro
				carritoEjb.eliminarProductoCarro(idProducto, emailUsuario);

				VentaPojo ven = new VentaPojo();

				ven.setEmailUsuario(emailUsuario);
				ven.setFecha(data);
				ven.setIdProducto(idProducto);
				ven.setCodigoPedido(codigo);

				// añadirlo a ventas
				ventaEjb.añadirVenta(ven);

				String mensaje = " Buenas Tardes " + ven.getEmailUsuario() + " \n " + " Su pedido Ya estas en marcha "
						+ "\n" + " Codigo de PEDIDO : " + ven.getCodigoPedido() + " \n " + " Ticket de la Compra"
						+ " \n " + " Producto comprado : " + prod.getTitulo() + " Precio Pagado : " + prod.getPrecio()
						+ " Cantidad de Productos 1 : " + cantidad1 + " Total de la Compra : " + totalVenta
						+ " Fecha de la compra  : " + ven.getFecha();

				String mensaje1 = "WEBTECK venta hecha en fecha de : " + ven.getFecha() + " Producto Vendido : "
						+ prod.getTitulo() + " \n " + " Precio de producto de la venta : " + prod.getPrecio() + " \n "
						+ "Usuario de la compra : " + ven.getEmailUsuario() + " \n " + " Cantidad de Productos 1 : "
						+ cantidad1 + " \n " + " Total de la Venta : " + totalVenta
						+ "------------------------> Codigo de PEDIDO : " + ven.getCodigoPedido();

				// Envio los dos mails tanto el cliente como a la empresa
				mailsEjb.sendMail(emailUsuario, mensaje, "Realizacion de su Compra");
				mailsEjb.sendMail(correoEmpresa, mensaje1, "Relalizacion de una Venta ");

			} catch (Exception e) {
				loggerError.error(e.getMessage() + "Error al pagar");

			}
			loggerNormal.debug("Todo a Funcionado correctamente");
			response.sendRedirect("VerCarrito");

		} else {

			response.sendRedirect("VerCarrito?error=Error No");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
