package modelo.Ejb;

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
}
