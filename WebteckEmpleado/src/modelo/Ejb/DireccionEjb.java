package modelo.Ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Pojo.DireccionPojo;
import modelo.dao.DireccionDao;

@LocalBean
@Stateless
public class DireccionEjb {

	/**
	 * este metodo inserta direcciones nuevas
	 * 
	 * @param direccion
	 */
	public void insertDireccion(DireccionPojo direccion) {
		DireccionDao direccionDao = new DireccionDao();

		direccionDao.insertDireccion(direccion);
	}

	/**
	 * este metodo recupera una lista de direcciones por email de usuario
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */

	public ArrayList<DireccionPojo> leerDirecciones(String emailUsuario) throws SQLException {
		DireccionDao direccionDao = new DireccionDao();
		return direccionDao.leerDirecciones(emailUsuario);

	}

	/**
	 * este metodo modifica las direcciones
	 * 
	 * @param direccion
	 */
	public void updateDireccion(DireccionPojo direccion) {
		DireccionDao direccionDao = new DireccionDao();

		direccionDao.updateDireccion(direccion);
	}

	/**
	 * este metodo recupera una direccion por email del usuario
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */
	public DireccionPojo direccionPorNombre(String emailUsuario) throws SQLException {

		DireccionDao direccionDao = new DireccionDao();
		return direccionDao.direccionPorNombre(emailUsuario);

	}

	/**
	 * este metodo elimina las direcciones por el emial de usuario
	 * 
	 * @param emailUsuario
	 * @throws SQLException
	 */
	public void eliminarDireccion(String emailUsuario) throws SQLException {
		DireccionDao direeDao = new DireccionDao();
		direeDao.eliminarDireccion(emailUsuario);
	}

}
