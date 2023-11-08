package com.bngferoz.encryption.elgamal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.bngferoz.encryption.elgamal.dto.Output;
import com.bngferoz.encryption.elgamal.dto.Message;
import com.bngferoz.encryption.elgamal.service.ElgamalEncryptionService;

import lombok.val;


@Controller
public class EncryptionController {
	
	@Autowired
	ElgamalEncryptionService elgamalEncryptionService;
	
	@MessageMapping("/chat")
	@SendTo("/topic/greetings")
	public Output greet(Message message) throws InterruptedException {
		Thread.sleep(2000);
		
		Output returnThis =  elgamalEncryptionService.elgamal(message.getMessage());
		return returnThis;
	}
	
	@MessageMapping("/verify")
	public String verify(Message message) throws InterruptedException {
		
		Output returnThis =  elgamalEncryptionService.elgamal(message.getMessage());
		String[] values;
		if(message!=null && message.getMessage()!=null) {
			String str = message.getMessage();
			values = str.split("$");
		}
		return "";
	}
}
