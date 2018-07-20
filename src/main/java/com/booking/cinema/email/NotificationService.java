package com.booking.cinema.email;

 
 

import java.util.Properties;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.booking.cinema.model.User;
 

@Service
public class NotificationService {
	
	 
	private JavaMailSender javaMailSender;
	
	 
	
	public void sendNotification(User user)  {
	 
		//send email
	 
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
	
		mail.setFrom("bootcampstests@gmail.com");
		mail.setSubject("test");
		mail.setText("test");
 
	 
		
		JavaMailSender jsd =getJavaMailSender();
		jsd.send(mail);
	}
	 
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);

	    mailSender.setUsername("bootcampstests@gmail.com");
	    mailSender.setPassword("bootcamp123");

	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");

	    return mailSender;
	}
}
