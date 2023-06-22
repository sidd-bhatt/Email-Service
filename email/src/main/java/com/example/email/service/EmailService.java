package com.example.email.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.SendTemplatedEmailRequest;

@Service
public class EmailService {

	@Autowired
    private SesClient sesClient;

    public void sendTemplatedEmail() {
    	
    	JSONObject templateData = new JSONObject();
		templateData.put("name", "Benchmark");
		templateData.put("url", "https://www.youtube.com/");
    	
            SendTemplatedEmailRequest request = SendTemplatedEmailRequest.builder()
                .template("Academian")
                .destination(builder -> builder.toAddresses("siddharth11bhatt@gmail.com"))
                .source("sbhatt@academian.com")
                .templateData(templateData.toString())
                .build();

        sesClient.sendTemplatedEmail(request);
    }
}
