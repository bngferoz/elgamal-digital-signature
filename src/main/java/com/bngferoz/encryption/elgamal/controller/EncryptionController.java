package com.bngferoz.encryption.elgamal.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.bngferoz.encryption.elgamal.dto.Greetings;
import com.bngferoz.encryption.elgamal.dto.Message;
import com.bngferoz.encryption.elgamal.service.ElgamalEncryptionService;

import jakarta.validation.Valid;

@Controller
public class EncryptionController {
	
	@Autowired
	ElgamalEncryptionService elgamalEncryptionService;
	
	@MessageMapping("/chat")
	@SendTo("/topic/greetings")
	public Greetings greet(@Valid Message message) throws InterruptedException {
		Thread.sleep(2000);
		
		BigInteger output = elgamalEncryptionService.elgamal(HtmlUtils.htmlEscape(message.getName()));
		return new Greetings(output);
	}
}
