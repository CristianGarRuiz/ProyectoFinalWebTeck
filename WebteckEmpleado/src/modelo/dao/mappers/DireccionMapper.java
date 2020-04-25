package modelo.dao.mappers;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import modelo.Pojo.DireccionPojo;

public interface DireccionMapper {

	public void insertDireccion(DireccionPojo direccion);

	public ArrayList<DireccionPojo> leerDirecciones(@Param("emailUsuario") String emailUsuario);

	public void updateDireccion(DireccionPojo direccion);

	public DireccionPojo direccionPorNombre(@Param("emailUsuario") String emailUsuario);

	public void eliminarDireccion(@Param("emailUsuario") String emailUsuario);

}
