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

	/**
	 * este metodo recupera una lista de ventas por fechas
	 * 
	 * @param inicio
	 * @param fin
	 * @return
	 */
	public ArrayList<VentasPojo> leerProductosporFecha(String inicio, String fin) {
		VentasDao Ventasdao = new VentasDao();
		return Ventasdao.leerProductosporFecha(inicio, fin);
	}

	/**
	 * este metodo recupera una lista de productos por email
	 * 
	 * @param emailUsuario
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<VentasPojo> leerProductosporEmail(String emailUsuario) throws SQLException {
		VentasDao VentasDao = new VentasDao();
		return VentasDao.leerProductosporEmail(emailUsuario);

	}

	/**
	 * este metodo inserta nuevas ventas
	 * 
	 * @param venta
	 */
	public void insertarVenta(VentasPojo venta) {
		VentasDao Ventasdao = new VentasDao();

		Ventasdao.insertarVenta(venta);
	}
}
