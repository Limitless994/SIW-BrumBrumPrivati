package email;

import java.util.*; 
import javax.mail.*; 
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;

public class send_mail_gmail {
	
		public static void sendEmail(String email) {
		String emailUtente = email;
		final String username = "brumweb97@gmail.com";
		final String password = "Milena_97";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
			}
		  });
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("brumweb97@gmail.com"));
		
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(emailUtente));
			message.setSubject("Conferma Ordine");
			message.setText("Gentile Cliente," + "\n\n Le comunichiamo che il suo ordine � avvenuto con successo!"+ "\n Cordiali saluti, BRUMBRUM");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
	}
}