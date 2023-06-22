package com.example.ses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ses.model.EmailSendingResult;
import com.example.ses.service.TemplatedEmailService;

@RestController
public class TemplatedEmailController {

	@Autowired
	private TemplatedEmailService templatedEmailService;

	@GetMapping("/sendTemplatedEmail")
	public EmailSendingResult sendTemplatedEmail() {
		return templatedEmailService.sendTemplatedEmail();
	}

}
