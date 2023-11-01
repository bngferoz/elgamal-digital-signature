package com.bngferoz.encryption.elgamal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.bngferoz.encryption.elgamal.dto.Greetings;
import com.bngferoz.encryption.elgamal.dto.Message;

@Controller
public class EncryptionController {
	@MessageMapping("/chat")
	@SendTo("/topic/greetings")
	public Greetings greet(Message message) throws InterruptedException {
		Thread.sleep(2000);
		return new Greetings("Hello,"+
				HtmlUtils.htmlEscape(message.getName()));
	}
}
