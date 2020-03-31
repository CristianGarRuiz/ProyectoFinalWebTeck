package modelo.Ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import modelo.Pojo.VentasPojo;
import modelo.dao.VentasDao;

@Stateless
@LocalBean
public class VentasEjb {

	
	public ArrayList<VentasPojo> leerProductosporFecha(String inicio, String fin) {
		VentasDao Ventasdao = new VentasDao();
		return Ventasdao.leerProductosporFecha(inicio, fin);
	}
	
	public ArrayList<VentasPojo> leerProductosporEmail(String emailUsuario)  throws SQLException {
		VentasDao VentasDao = new VentasDao();
		return VentasDao.leerProductosporEmail(emailUsuario);

	}
}
