package modelo.Ejb;

import java.sql.SQLException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Pojo.ValorcionPojo;
import modelo.dao.ValoracionDao;

@Stateless
@LocalBean
public class ValoracionEjb {

	public void AñadirCometario(ValorcionPojo valor) throws SQLException {
		ValoracionDao ValorDao = new ValoracionDao();
		ValorDao.insertCometario(valor);
	}

	public void AñadirValoracion(ValorcionPojo valor) throws SQLException {
		ValoracionDao ValorDao = new ValoracionDao();
		ValorDao.insertValoracion(valor);
	}
}
