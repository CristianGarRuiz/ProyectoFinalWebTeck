package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import modelo.Pojo.VentasPojo;

public interface VentasMapper {

	/**
	 * este metodo recupera los porductos vendidos por sus fechas de ini y fin
	 * 
	 * @param inicio
	 * @param fin
	 * @return
	 */
	public ArrayList<VentasPojo> leerProductosporFecha(@Param("inicio") String inicio, @Param("fin") String fin);

	/**
	 * estem metodo recupera una lista de ventas por el emai lde usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public ArrayList<VentasPojo> leerProductosporEmail(@Param("emailUsuario") String emailUsuario);

	/**
	 * este metodo inserta nuevas ventas
	 * 
	 * @param venta
	 */
	public void insertarVenta(VentasPojo venta);
}
