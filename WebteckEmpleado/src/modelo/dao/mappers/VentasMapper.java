package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import modelo.Pojo.VentasPojo;

public interface VentasMapper {

	public ArrayList<VentasPojo> leerProductosporFecha(@Param("inicio") String inicio, @Param("fin") String fin);

	public ArrayList<VentasPojo> leerProductosporEmail(@Param("emailUsuario") String emailUsuario);
}
