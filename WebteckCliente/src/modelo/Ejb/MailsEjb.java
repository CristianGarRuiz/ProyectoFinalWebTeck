package modelo.Ejb;

import java.io.File;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Stateless
@LocalBean
public class MailsEjb {

	public void sendMail(String para, String mensaje, String ausnto) throws MessagingException {

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("garciaruizcristian50@gmail.com", "Cristiano_7");
			}
		});

		Message message = new MimeMessage(session);

		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
		message.setSubject(ausnto);

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(mensaje, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);

		message.setContent(multipart);
		Transport.send(message);
	}
	public void sendMail1(String para, String nombre,String remitente, String asunto, String mensaje) {

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
            	return new PasswordAuthentication("garciaruizcristian50@gmail.com", "Cristiano_7");
            }
        });

        try {
                Message message = new MimeMessage(session);
                
                message.setFrom(new InternetAddress(remitente));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
                message.setSubject(asunto);
                message.setText(nombre);

                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(mensaje, "text/html");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);    	                

                message.setContent(multipart);
                Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
