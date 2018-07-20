package com.booking.cinema.email;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.booking.cinema.model.User;
 

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
				
	}
	public void sendNotification() {
		//send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("arturskristapurs@gmail.com");
		mail.setFrom(mail.getFrom());
		mail.setSubject("test");
		mail.setText("test");
		System.out.println(mail.getFrom());
		javaMailSender.send(mail);
	}
}
