package controlador;

import java.io.IOException;
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
import modelo.Ejb.DireccionesEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.DireccionesPojo;
import modelo.Pojo.UsuariosPojo;

/**
 * este metodo lo utilizaremos para editar un accidente que tenemos en bd
 * 
 * @author cristian
 *
 */
@WebServlet("/EditarDireccion")
public class EditarDireccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger loggerError = (Logger) LoggerFactory.getLogger("Error");
	private static final Logger loggerNormal = (Logger) LoggerFactory.getLogger("Normal");
	@EJB

	DireccionesEjb direccionEjb;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	ProductosEjb productosEjb;

	// Recojo el ejb de accidentes porque lo necessito para realizar un update de un
	// accidente
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Busco session de un usuario si hay
		HttpSession session = request.getSession();

		// creo el redigidor de la pagina editar
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/EditarDireccion.jsp");
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();

		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);

		String emailUsuario = usuario.getEmailUsuario();

		DireccionesPojo direccion = null;
		try {
			direccion = direccionEjb.getDireccion(emailUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// paso la estancia a la pagina
		request.setAttribute("direccion", direccion);
		request.setAttribute("usuario", usuario);
		request.setAttribute("categorias", categorias);
		// Redirijo a la pagina
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Creo las variable que me hacen falta
		String emailUsuario = request.getParameter("emailUsuario");
		String direccion = request.getParameter("Direccion");
		String vivienda = request.getParameter("Vivienda");
		String localidad = request.getParameter("Localidad");
		String provincia = request.getParameter("Provincia");
		String codigo = request.getParameter("CodigoPostal");

		// Pasa las varibale que son String a int por su formato del pojo
		int codigoPostal = Integer.parseInt(codigo);

		// Compruebo que los datos no sean nulos
		try {
			if ((emailUsuario != null) && (direccion != null) && (vivienda != null) && (localidad != null)
					&& (provincia != null) && (codigo != null)) {
				// Creo la instancia del pojo de accidentes.
				DireccionesPojo d = new DireccionesPojo();

//Cambio los valores antiguos por los nuevos
				d.setEmailUsuario(emailUsuario);
				d.setDireccion(direccion);
				d.setLocalidad(localidad);
				d.setProvincia(provincia);
				d.setVivienda(vivienda);
				d.setCodigoPostal(codigoPostal);

//y Modifico los datos
				direccionEjb.updateDireccion(d);
				loggerNormal.debug(" Realizando un update de los datos de la direccion email " + emailUsuario
						+ " Con los datos " + "direccion : " + direccion + "Localidad: " + localidad + "provincia : "
						+ provincia + "Vivienda: " + vivienda + " CodigoPostal :" + codigoPostal);

			}
		} catch (Exception e) {

			loggerError.error("Error al realizar un update de las direcciones  de los clientes");

		}
		// Finalmente enviamos a la página principal
		response.sendRedirect("Principal");
	}

}
