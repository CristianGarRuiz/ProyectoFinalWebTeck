package modelo.dao;

import org.apache.ibatis.session.SqlSession;

import modelo.Pojo.UsuarioPojo;
import modelo.dao.mappers.UsuarioMapper;

public class EmpleadoDao {

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

	public String getFoto(UsuarioPojo usuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			UsuarioMapper usuarioImagen = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioImagen.getFoto(usuario);

		} finally {

			sqlSession.close();
		}
	}

	public void AñadirUsuarios(UsuarioPojo usuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			UsuarioMapper usuAñadirUsuario = sqlSession.getMapper(UsuarioMapper.class);
			usuAñadirUsuario.AñadirUsuarios(usuario.getEmailUsuario(), usuario.getNombre(), usuario.getUsuario(),
					usuario.getPassword(), usuario.getFoto(), usuario.getActivado());
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
	public void eliminarUsuario(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper eliUsu = sqlSession.getMapper(UsuarioMapper.class);
			eliUsu.eliminarUsuario(emailUsuario);
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

}
