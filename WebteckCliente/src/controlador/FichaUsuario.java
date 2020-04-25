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
import modelo.Ejb.DireccionesEjb;
import modelo.Ejb.ProductosEjb;
import modelo.Ejb.SesionesEjb;
import modelo.Ejb.UsuariosEjb;
import modelo.Pojo.CategoriasPojo;
import modelo.Pojo.DireccionesPojo;
import modelo.Pojo.MarcasPojo;
import modelo.Pojo.UsuariosPojo;

@WebServlet("/FichaUsuario")
public class FichaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosEjb usuarioEjb;

	@EJB
	ProductosEjb productoEjb;

	@EJB
	SesionesEjb sesionesEjb;

	@EJB
	DireccionesEjb direccionesEjb;
	
	@EJB
	ProductosEjb productosEjb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuariosPojo usuario = sesionesEjb.usuariosLogeado(session);
		String pantalla = sesionesEjb.getPantalla(session);
		String error = request.getParameter("error");
		String emailUsuario = usuario.getEmailUsuario();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/OpcPerfil.jsp");

		ArrayList<DireccionesPojo> direccionesUsuarios = direccionesEjb.leerDatosporMail(emailUsuario);
		ArrayList<UsuariosPojo> datosUsuario = usuarioEjb.leerDatosUsuario(emailUsuario);
		ArrayList<CategoriasPojo> categorias = productosEjb.leerTotalCategorias();
		ArrayList<MarcasPojo> marcas = productosEjb.leerTotalMarcas();

		request.setAttribute("error", error);
		request.setAttribute("usuario", usuario);
		request.setAttribute("pantalla", pantalla);
		request.setAttribute("direccionesUsuarios", direccionesUsuarios);
		request.setAttribute("datosUsuario", datosUsuario);
		request.setAttribute("categorias", categorias);
		request.setAttribute("marcas", marcas);

		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
