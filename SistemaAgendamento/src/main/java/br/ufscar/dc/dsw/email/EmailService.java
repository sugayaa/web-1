package br.ufscar.dc.dsw.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	public void send(InternetAddress to, String assunto, String corpo) {
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
		
        Session session = Session.getInstance(properties, new Authenticator() {
        	@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dsw1ufscar@gmail.com", "e3Lam@2021");
			}
		});
        
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dsw1ufscar@gmail.com"));
			message.setRecipient(Message.RecipientType.TO, to);
			message.setSubject(assunto);
			message.setText(corpo);
			Transport.send(message);
			System.out.println("Mensagem enviada com sucesso");
			
		}catch (Exception e) {
			System.out.println("Erro no envio");
			e.printStackTrace();
		}
	}
}
