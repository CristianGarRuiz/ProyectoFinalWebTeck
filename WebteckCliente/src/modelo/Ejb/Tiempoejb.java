package modelo.Ejb;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.mail.MessagingException;


@Stateless

public class Tiempoejb {

	@EJB
	UsuariosEjb usuariosEJB;

	@EJB
	MailsEjb mailEJB;

	// esto nos sirve para el tiempo de envio del correo que vamos a hacer
	@Schedule(hour = "*/2", minute = "0", persistent = false)
	/**
	 * este metodo lo que hace es enviar un email con los usuario que teenemos en la
	 * base de datos con el tiempo es decir la fecha y el asunto del mensaje
	 * 
	 * @throws SQLException
	 * @throws MessagingException
	 */
	public void myTimer() throws SQLException, MessagingException {

		Date date = new Date();

		Timestamp fecha = new Timestamp(date.getTime());

		int nomUsuario = usuariosEJB.contarUsuarios();
		String mensaje = "Tenemos de usuarios totales " + nomUsuario;
		mailEJB.sendMail("webteck@mail.ee", mensaje, " Usuarios Registrados " + fecha);

	}
}
