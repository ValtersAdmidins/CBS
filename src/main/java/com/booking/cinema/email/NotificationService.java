package com.booking.cinema.email;

 
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.booking.cinema.model.User;
 

@Service
public class NotificationService {
	
	 
	private JavaMailSender javaMailSender;
	
	 
	
	public void sendNotification(String email) throws MailException{
	 
		//send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom("sisirepasts123@gmail.com");
		mail.setSubject("test");
		mail.setText("test");
		System.out.println("pazinojums");
		javaMailSender.send(mail);
		
//		JavaMailSender jsd =getJavaMailSender();
//		jsd.send(mail);
	}
	 
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//
//	    mailSender.setUsername("bootcampstests@gmail.com");
//	    mailSender.setPassword("bootcamp123");
//
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//
//	    return mailSender;
//	}
}
