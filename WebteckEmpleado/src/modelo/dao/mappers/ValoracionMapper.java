package modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import modelo.Pojo.ValorcionPojo;

public interface ValoracionMapper {

	public void insertComentario(ValorcionPojo valor);

	public void insertValoracion(ValorcionPojo valor);

	public ArrayList<ValorcionPojo> leerValoracionesTienda(@Param("id") int id);

	public ArrayList<ValorcionPojo> leerComentariosTienda(@Param("id") int id);

}
