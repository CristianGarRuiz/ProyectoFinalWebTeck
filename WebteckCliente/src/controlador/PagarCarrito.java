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
		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String error = request.getParameter("error");
		String emailUsuario = usuario.getEmailUsuario();
		String id = request.getParameter("id");
		Integer idProducto = Integer.valueOf(id);

		String formato = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
		LocalDateTime ahora = LocalDateTime.now();

		int codigo = (int) (Math.random() * 10000 + 1);

		String data = formateador.format(ahora);

		String correoEmpresa = "garciaruizcristian50@gmail.com";

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emailUsuario", emailUsuario);

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emailUsuario", emailUsuario);
		

		DireccionesPojo direccion = direccionEjb.getDireccion(emailUsuario);

		if ((direccion != null) && (direccion.getDireccion() != null)) {

			try {

				ProductosTiendaPojo prod = productoEjb.ProductoporSuID(idProducto);
				
				CarritosPojo cantidad1=  carritoEjb.contarProductosCantidadCarro(idProducto, emailUsuario);
				
				int stock = prod.getStock();
				int cantidad= cantidad1.getIdProducto();
				
				   productoEjb.updateCarritoCantidad(stock,cantidad, idProducto);
				
				  CarritosPojo totalVenta=   carritoEjb.sumaCarro(emailUsuario);
				   
				   
				
				carritoEjb.eliminarProductoCarro(idProducto, emailUsuario);
				
				VentaPojo ven = new VentaPojo();

				ven.setEmailUsuario(emailUsuario);
				ven.setFecha(data);
				ven.setIdProducto(idProducto);
				ven.setCodigoPedido(codigo);

				ventaEjb.añadirVenta(ven);
				


				String mensaje = " Buenas Tardes " + ven.getEmailUsuario() + " \n " + " Su pedido Ya estas en marcha "
						+ "\n" + " Codigo de PEDIDO : " + ven.getCodigoPedido() + " \n " + " Ticket de la Compra"
						+ " \n " + " Producto comprado : " + prod.getTitulo() + " Precio Pagado : " + prod.getPrecio()
						+ " Cantidad de Productos 1 : " + cantidad1 + " Total de la Compra : " +totalVenta +  " Fecha de la compra  : " + ven.getFecha();

				String mensaje1 = "WEBTECK venta hecha en fecha de : " + ven.getFecha() + " Producto Vendido : "
						+ prod.getTitulo() + " \n " + " Precio de producto de la venta : " + prod.getPrecio() + " \n "
						+ "Usuario de la compra : " + ven.getEmailUsuario() + " \n "
						+ " Cantidad de Productos 1 : " + cantidad1 + " \n "
						+ " Total de la Venta : " +totalVenta 
						+ "------------------------> Codigo de PEDIDO : " + ven.getCodigoPedido();

				mailsEjb.sendMail(emailUsuario, mensaje, "Realizacion de su Compra");
				mailsEjb.sendMail(correoEmpresa, mensaje1, "Relalizacion de una Venta ");

			} catch (Exception e) {
//			loggerError.error(e.getMessage() + "Error al eliminar una direccion de un usuario con el email propio");

			}
//		loggerNormal.debug("Eliminado Correctamente");
			response.sendRedirect("VerCarrito");

			

		} else {

			response.sendRedirect("VerCarrito?error=Error No");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
