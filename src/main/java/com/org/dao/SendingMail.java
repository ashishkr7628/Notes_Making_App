package com.org.dao;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendingMail {
	
	public static void  mail(String otp, String email)throws MessagingException {
		
		Properties p = new Properties();
		p.setProperty("mail.smtp.host", "smtp.gmail.com");
		p.setProperty("mail.smtp.port", "465");
		p.setProperty("mail.smtp.ssl.enable", "true");
		p.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(p, new Authenticator() {
			@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			// TODO Auto-generated method stub
			return new PasswordAuthentication("aashidare123@gmail.com", "ceeq pzwx ksjh lquw");
		} 
			
			
			
		});
		
		session.setDebug(true);
		
		MimeMessage message= new MimeMessage(session);
		message.setFrom("aashidare123@gmail.com");
		message.addRecipient(RecipientType.TO, new InternetAddress(email));
		message.setSubject("Forgot password ");
		message.setText("OTP:"+otp);
		
		
		Transport.send(message);
		
	
		
		
		
	}

}
