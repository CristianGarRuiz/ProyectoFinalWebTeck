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

	/**
	 * este metodo añade un comentario nuevo
	 * 
	 * @param valor
	 * @throws SQLException
	 */
	public void AñadirComentario(ValorcionPojo valor) throws SQLException {
		ValoracionDao ValorDao = new ValoracionDao();
		ValorDao.insertComentario(valor);
	}

	/**
	 * este metodo añade una valoracion nueva
	 * 
	 * @param valor
	 * @throws SQLException
	 */
	public void AñadirValoracion(ValorcionPojo valor) throws SQLException {
		ValoracionDao ValorDao = new ValoracionDao();
		ValorDao.insertValoracion(valor);
	}

	/**
	 * este metodo recupera una lista de comentarios por id del producto
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ValorcionPojo> leerComentarioTienda(int id) throws SQLException {

		ValoracionDao ProductoDao = new ValoracionDao();
		return ProductoDao.leerComentariosTienda(id);

	}

	/**
	 * este metodo recupera las valoraciones por la id del producto
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ValorcionPojo> leerValoracionTienda(int id) throws SQLException {

		ValoracionDao ProductoDao = new ValoracionDao();
		return ProductoDao.leerValoracionesTienda(id);

	}
}
