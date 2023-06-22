package com.example.ses.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.AmazonSimpleEmailServiceException;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailRequest;
import com.example.ses.model.EmailSendingResult;

@Service
public class TemplatedEmailService {

	@Autowired
	private AmazonSimpleEmailService simpleEmailService;

	@SuppressWarnings("unchecked")
	public EmailSendingResult sendTemplatedEmail() {

		EmailSendingResult result = new EmailSendingResult();
		try {
			
			//Setting up destination address
			Destination destination = new Destination();
			String email = "siddharth11bhatt@gmail.com";
			List<String> toAddresses = new ArrayList<>();
			toAddresses.add(email);
			destination.setToAddresses(toAddresses);
			

			//Setting up template dynamic data to JSON object
			JSONObject templateData = new JSONObject();
			templateData.put("name", "Benchmark");
			templateData.put("url", "https://www.youtube.com/");
			

			SendTemplatedEmailRequest templatedEmailRequest = new SendTemplatedEmailRequest();
			templatedEmailRequest.withDestination(destination);
			templatedEmailRequest.withTemplate("Academian");
			templatedEmailRequest.withTemplateData(templateData.toString());
			templatedEmailRequest.withSource("sbhatt@academian.com");
			simpleEmailService.sendTemplatedEmail(templatedEmailRequest);
			
			
			result.setSuccess(true);
			
		} //end of try block
		
		//AmazonSimpleEmailServiceException-Base exception for all service exceptions thrown by Amazon Simple Email Service
		catch (AmazonSimpleEmailServiceException ex) {
			result.setSuccess(false);
			result.setErrorCode(ex.getErrorCode());
			result.setErrorMessage(ex.getErrorMessage());
		}//end of catch block
		return result;
	}
}
