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
		mail.setTo("sisirepasts123@gmail.com");
		mail.setFrom("sisirepasts123@gmail.com");
		mail.setSubject("test");
		mail.setText("test");
		
		javaMailSender.send(mail);
	}
}
