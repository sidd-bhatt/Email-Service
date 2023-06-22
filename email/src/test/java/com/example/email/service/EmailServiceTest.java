package com.example.email.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.SendTemplatedEmailRequest;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private SesClient sesClient;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void testSendTemplatedEmail() throws JSONException {

        //Arrange
        JSONObject templateData = new JSONObject();
        templateData.put("name", "Benchmark");
        templateData.put("url", "https://www.youtube.com/");

        SendTemplatedEmailRequest expectedRequest = SendTemplatedEmailRequest.builder()
                .template("Academian")
                .destination(builder -> builder.toAddresses("siddharth11bhatt@gmail.com"))
                .source("sbhatt@academian.com")
                .templateData(templateData.toString())
                .build();

        // Act
        emailService.sendTemplatedEmail();

        // Assert
        verify(sesClient).sendTemplatedEmail(expectedRequest);
    }
}
