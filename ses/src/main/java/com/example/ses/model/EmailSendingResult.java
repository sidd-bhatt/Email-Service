package com.example.ses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailSendingResult {
	
	private boolean success;
    private String errorCode;
    private String errorMessage;

}
