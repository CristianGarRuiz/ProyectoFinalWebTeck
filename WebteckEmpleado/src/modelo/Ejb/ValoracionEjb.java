package modelo.Ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Pojo.ValorcionPojo;
import modelo.dao.ValoracionDao;

@Stateless
@LocalBean
public class ValoracionEjb {

	public void AñadirComentario(ValorcionPojo valor) throws SQLException {
		ValoracionDao ValorDao = new ValoracionDao();
		ValorDao.insertComentario(valor);
	}

	public void AñadirValoracion(ValorcionPojo valor) throws SQLException {
		ValoracionDao ValorDao = new ValoracionDao();
		ValorDao.insertValoracion(valor);
	}
	
	public ArrayList<ValorcionPojo> leerComentarioTienda(int id) throws SQLException {

		ValoracionDao ProductoDao = new ValoracionDao();
		return ProductoDao.leerComentariosTienda(id);

	}
	public ArrayList<ValorcionPojo> leerValoracionTienda(int id) throws SQLException {

		ValoracionDao ProductoDao = new ValoracionDao();
		return ProductoDao.leerValoracionesTienda(id);

	}
}
