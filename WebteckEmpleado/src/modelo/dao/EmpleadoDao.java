package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.Pojo.UsuarioPojo;
import modelo.dao.mappers.UsuarioMapper;

public class EmpleadoDao {

	/**
	 * este metodo recupera un empleado por usuario y password
	 * 
	 * @param user
	 * @param paswd
	 * @return
	 */

	public UsuarioPojo leerDatosEmpleado(String user, String paswd) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper leerDatosUsu = sqlSession.getMapper(UsuarioMapper.class);
			UsuarioPojo a = leerDatosUsu.leerDatosEmpleado(user, paswd);

			return a;

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo comprueba el nombre de usuario
	 * 
	 * @param NombreUsuario
	 * @return
	 */
	public UsuarioPojo comprobarUsuarioEmpleado(String NombreUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper leerDatosUsu = sqlSession.getMapper(UsuarioMapper.class);
			UsuarioPojo a = leerDatosUsu.comprobarUsuarioEmpleado(NombreUsuario);

			return a;

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo comprubea el emial del usuario
	 * 
	 * @param emailUsuario
	 * @return
	 */
	public UsuarioPojo comprobarEmailUsuarioEmpleado(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper leerDatosUsu = sqlSession.getMapper(UsuarioMapper.class);
			UsuarioPojo a = leerDatosUsu.comprobarEmailUsarioEmpleado(emailUsuario);

			return a;

		} finally {
			sqlSession.close();
		}

	}

	/**
	 * este metodo recupera la foto del usuario
	 * 
	 * @param usuario
	 * @return
	 */
	public String getFoto(UsuarioPojo usuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			UsuarioMapper usuarioImagen = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioImagen.getFoto(usuario);

		} finally {

			sqlSession.close();
		}
	}

	/**
	 * este meotdo añade un empleado nuevo
	 * 
	 * @param usu
	 */
	public void AñadirEmpleado(UsuarioPojo usu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			UsuarioMapper AñadirEmpleado = sqlSession.getMapper(UsuarioMapper.class);
			AñadirEmpleado.AñadirEmpleado(usu.getEmailUsuario(), usu.getNombre(), usu.getUsuario(), usu.getPassword(),
					usu.getFoto());
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

	/**
	 * este metodo elimina un usuario por su cuenta de correo
	 * 
	 * @param correo
	 * @throws SQLException
	 */
	public void eliminarEmpleado(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper eliUsu = sqlSession.getMapper(UsuarioMapper.class);
			eliUsu.eliminarEmpleado(emailUsuario);
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

}
