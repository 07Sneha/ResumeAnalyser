package com.analyser.resumeanalyzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	
	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendOtp(String toEmail, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(toEmail);
	        message.setSubject("Your OTP Code");
	        message.setText("Hello,\n\nYour OTP code is: " + otp + "\n\nThis code is valid for 1 hour.\n\nThanks!");
	        message.setFrom("your_email@gmail.com");

	        mailSender.send(message);
	        System.out.println("Email sent successfully to " + toEmail);
	    }
}
