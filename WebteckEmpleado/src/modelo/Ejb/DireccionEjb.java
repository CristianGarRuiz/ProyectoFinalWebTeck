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

	public void insertDireccion(DireccionPojo direccion) {
		DireccionDao direccionDao = new DireccionDao();

		direccionDao.insertDireccion(direccion);
	}
	
	
	
	public ArrayList<DireccionPojo> leerDirecciones(String emailUsuario)  throws SQLException {
		DireccionDao direccionDao = new DireccionDao();
		return direccionDao.leerDirecciones(emailUsuario);

	}
	
	public void updateDireccion(DireccionPojo direccion) {
		DireccionDao direccionDao = new DireccionDao();

		direccionDao.updateDireccion(direccion);
	}
	
	
	public DireccionPojo direccionPorNombre(String emailUsuario) throws SQLException {

		DireccionDao direccionDao = new DireccionDao();
		return direccionDao.direccionPorNombre(emailUsuario);

	}

	public void eliminarDireccion(String emailUsuario) throws SQLException {
		DireccionDao direeDao = new DireccionDao();
		direeDao.eliminarDireccion(emailUsuario);
	}
	
}
