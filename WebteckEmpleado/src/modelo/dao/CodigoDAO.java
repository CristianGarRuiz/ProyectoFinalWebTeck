package modelo.dao;

import org.apache.ibatis.session.SqlSession;
import modelo.dao.mappers.CodigoMapper;

public class CodigoDAO {

	/**
	 * este metodo conecta con base dato para inserta un codigo random con el
	 * usuario relacionado
	 * 
	 * @param codigo
	 * @param emailUsuario
	 */

	public void insertCodigo(int codigo, String emailUsuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CodigoMapper codigoUsuario = sqlSession.getMapper(CodigoMapper.class);
			codigoUsuario.insertCodigo(codigo, emailUsuario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
