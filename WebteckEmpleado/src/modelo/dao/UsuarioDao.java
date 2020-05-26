package modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import modelo.dao.MyBatisUtil;
import modelo.Pojo.UsuarioPojo;
import modelo.dao.mappers.UsuarioMapper;

public class UsuarioDao {
	public UsuarioPojo leerDatos(String user, String paswd) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper leerDatosUsu = sqlSession.getMapper(UsuarioMapper.class);
			UsuarioPojo a = leerDatosUsu.leerDatos(user, paswd);

			return a;

		} finally {
			sqlSession.close();
		}

	}

	
	public UsuarioPojo comprobarUsuario(String NombreUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper leerDatosUsu = sqlSession.getMapper(UsuarioMapper.class);
			UsuarioPojo a = leerDatosUsu.comprobarUsuario(NombreUsuario);

			return a;

		} finally {
			sqlSession.close();
		}

	}
	
	public UsuarioPojo comprobarEmailUsuario(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper leerDatosUsu = sqlSession.getMapper(UsuarioMapper.class);
			UsuarioPojo a = leerDatosUsu.comprobarEmailUsario(emailUsuario);

			return a;

		} finally {
			sqlSession.close();
		}

	}
	
	
	
	public ArrayList<UsuarioPojo> getDatosUsuarioporEmailUsuario(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper datosUsu = sqlSession.getMapper(UsuarioMapper.class);
			return datosUsu.getDatosUsuarioporEmailUsuario(emailUsuario);

		} finally {
			sqlSession.close();
		}

	}
	
	
	/**
	 * este metodo recojo la foto del usuario que hace entra ne la pagina
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
	 * este metodo añade usuario a nuestra pagina pasando un usuario pojo con todos
	 * los datos que necesita para podeer añadirlo
	 * 
	 * @param usuario
	 */
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

	/**
	 * este metodo elimina la clave del usuario que va ser eliminar de la tabla de
	 * usuario
	 * 
	 * @param emailUsuario
	 */
	public void eliminarClave(String emailUsuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper eliUsu = sqlSession.getMapper(UsuarioMapper.class);
			eliUsu.eliminarClave(emailUsuario);
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

	/**
	 * este metodo activa el usuario y modifica la columna de activacion
	 * 
	 * @param codigo
	 * @throws SQLException
	 */
	public void activarUsuario(int codigo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			UsuarioMapper usuActi = sqlSession.getMapper(UsuarioMapper.class);
			usuActi.activarUsuario(codigo);
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

	/**
	 * este metodo retonra la cuenta de los usuario que tenemos en la pagina
	 * 
	 * @return
	 * @throws SQLException
	 */
//	public int contarUsuarios() {
//		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
//		try {
//
//			UsuarioMapper contaUsu = sqlSession.getMapper(UsuarioMapper.class);
//			return contaUsu.contarUsuarios();
//
//		} finally {
//			sqlSession.close();
//		}
//	}

	/**
	 * este metodo hace un update del valor de la pantalla del usuario que tiene su
	 * cuenta
	 * 
	 * @param pantalla
	 * @param usuario
	 */
	public void pantallaUsuario(String pantalla, String usuario) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {

			UsuarioMapper pantallaUsuario = sqlSession.getMapper(UsuarioMapper.class);
			pantallaUsuario.pantallaUsuario(pantalla, usuario);
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}

	}
	
	
	public void updateContraseña(UsuarioPojo usu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper accidenteEdi = sqlSession.getMapper(UsuarioMapper.class);
			accidenteEdi.updateContraseña(usu);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	
	public void updateImagen(UsuarioPojo usu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper accidenteEdi = sqlSession.getMapper(UsuarioMapper.class);
			accidenteEdi.updateImagen(usu);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
