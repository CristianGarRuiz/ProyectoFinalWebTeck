package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import modelo.Ejb.ProductoEjb;
import modelo.Ejb.SesionEjb;
import modelo.Ejb.UsuarioEjb;
import modelo.Pojo.CategoriaPojo;
import modelo.Pojo.MarcaPojo;
import modelo.Pojo.ProductoPojo;
import modelo.Pojo.UsuarioPojo;

/**
 * Clase que crea un accidnete.
 */
@WebServlet("/Crear")
public class Crear extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");

	/**
	 * EJB para trabajar con los servicios
	 */
	@EJB
	ProductoEjb productoEjb;

	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;

	/**
	 * Método que trata las peticiones GET que llegan al servlet.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Busco session de un usuario si hay
		HttpSession session = request.getSession();

		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);

		ProductoPojo producto = new ProductoPojo();
		ArrayList<MarcaPojo> marca = null;
		ArrayList<CategoriaPojo> categoria = null;
		try {
			marca = productoEjb.leerTotalMarcas();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			categoria = productoEjb.leerTotalCategorias();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/NuevoAccidente.jsp");
		request.setAttribute("producto", producto);
		request.setAttribute("usuario", usuario);
		request.setAttribute("marca", marca);
		request.setAttribute("categoria", categoria);
		rs.forward(request, response);

	}

	/**
	 * Método que trata las peticiones POST que llegan al servlet.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Esta todos los parametros del pojo para poder insertar un accidente nuevo
		// -------------------------------------------------------------------------
		String Titulo = request.getParameter("Titulo");
		String año = request.getParameter("Anyo");
		String precio = request.getParameter("Precio");
		String Descripcion = request.getParameter("Descripcion");
		String Imagen = request.getParameter("Imagen");
		String stock = request.getParameter("Stock");
		int Id_Marca = Integer.parseInt(request.getParameter("Marca"));
		int Id_Categoria = Integer.parseInt(request.getParameter("Categoria"));
		int Año = Integer.parseInt(año);
		int Precio = Integer.parseInt(precio);
		int Stock = Integer.parseInt(stock);

		// compruebo que los datos no sean nulos
		if (Titulo != null && Descripcion != null && año != null && precio != null && stock != null) {
			// Si nos dan información de un accidente la insertamos.
			ProductoPojo e = new ProductoPojo();

			e.setTitulo(Titulo);
			e.setAnyo(Año);
			e.setPrecio(Precio);
			e.setDescripcion(Descripcion);
			e.setFoto(Imagen);
			e.setIdGenero(Id_Marca);
			e.setIdPlataforma(Id_Categoria);
			e.setStock(Stock);
			productoEjb.insertProducto(e);
		}
		loggerNormal.debug(" Realizando un insert  Con los datos " + "Titulo: " + Titulo + "Año: " + Año
				+ "Precio : " + Precio + "Descripcion: " + Descripcion + " Imagen" + Imagen + " Marca"+Id_Marca+
				" Plataforma" + Id_Categoria + " Stock" + Stock);
		
		loggerError.error("Error al insertar un producto nuevo");

		// Finalmente enviamos a la página principal
		response.sendRedirect("Pagina");
	}

}
