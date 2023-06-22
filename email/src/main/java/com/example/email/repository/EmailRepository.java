package com.example.email.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.service.EmailService;

@RestController
public class EmailRepository {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/sendTemplatedEmail")
	public String email() {
		emailService.sendTemplatedEmail();
		return "Email Sent";
	}
	
}
