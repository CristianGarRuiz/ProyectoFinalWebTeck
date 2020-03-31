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
 * este metodo lo utilizaremos para editar un accidente que tenemos en bd
 * 
 * @author cristian
 *
 */
@WebServlet("/Editar")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	@EJB

	ProductoEjb productoEjb;

	@EJB
	UsuarioEjb usuarioEjb;

	@EJB
	SesionEjb sesionesEjb;

	// Recojo el ejb de accidentes porque lo necessito para realizar un update de un
	// accidente
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Busco session de un usuario si hay
		HttpSession session = request.getSession();

		// creo el redigidor de la pagina editar
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Editar.jsp");
		// creo una variable id para recoger la que me pasan
		String id = request.getParameter("id");

		UsuarioPojo usuario = sesionesEjb.usuariosLogeado(session);

		// le cambio el formato a int
		Integer identificador = Integer.valueOf(id);

		// Recojo el metodo del ejb que me hace falta y le paso la id
		ProductoPojo producto = null;
		ArrayList<MarcaPojo> marca = null;
		ArrayList<CategoriaPojo> categoria = null;

		try {
			producto = productoEjb.leerProducto(identificador);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			marca = productoEjb.leerTotalMarcas();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			categoria = productoEjb.leerTotalCategorias();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// paso la estancia a la pagina
		request.setAttribute("producto", producto);
		request.setAttribute("usuario", usuario);
		request.setAttribute("marca", marca);
		request.setAttribute("categoria", categoria);
		// Redirijo a la pagina
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Creo las variable que me hacen falta
		String id = request.getParameter("id");
		String Titulo = request.getParameter("Titulo");
		String año = request.getParameter("Anyo");
		String precio = request.getParameter("Precio");
		String stock = request.getParameter("Stock");
		String Descricion = request.getParameter("Descripcion");
		String marca = request.getParameter("Marca");
		String categoria = request.getParameter("Categoria");

		// Pasa las varibale que son String a int por su formato del pojo
		int Año = Integer.parseInt(año);
		int Precio = Integer.parseInt(precio);
		int Stock = Integer.parseInt(stock);
		int Marca = Integer.parseInt(marca);
		int Categoria = Integer.parseInt(categoria);

		// Compruebo que los datos no sean nulos
		try {
			if ((Titulo != null) && (id != null) && (año != null) && (precio != null) && (Descricion != null)
					&& (marca != null) && (categoria != null)) {
				// Creo la instancia del pojo de accidentes.
				ProductoPojo u = new ProductoPojo();

				Integer identificador = Integer.valueOf(id);
//Cambio los valores antiguos por los nuevos
				u.setId(identificador);
				u.setTitulo(Titulo);
				u.setAnyo(Año);
				u.setPrecio(Precio);
				u.setStock(Stock);
				u.setDescripcion(Descricion);
				u.setIdGenero(Marca);
				u.setIdPlataforma(Categoria);
//y Modifico los datos
				productoEjb.updateProducto(u);

			}
		} catch (Exception e) {
			loggerNormal.debug(" Realizando un update de los datos del accidentecon id " + id + " Con los datos "
					+ "Titulo: " + Titulo + "Año: " + Año + "Precio : " + Precio + "Descripcion: " + Descricion
					+ " Stock" + Stock + " Marca" + Marca + " Categoria" + Categoria);
			loggerError.error("Error al realizar un update de las estadisticas de los jugadores");

		}
		// Finalmente enviamos a la página principal
		response.sendRedirect("Pagina");
	}

}
