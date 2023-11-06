package com.woori.myapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//여기서 수정사항이 발행해서 수정을 하면
@Controller
public class ChatController {

	@MessageMapping("/hello")
	@SendTo("/topic/greeting")
	public Message send_message(Message msg) throws InterruptedException {
		//잠깐 cpu 를 릴리즈한다 
		Thread.sleep(1000); //스레드가 1초동안 대기를 타도록 한다
		//서비스 읽고 쓰기 
		return msg;
	}
	
	@GetMapping("chat")
	public String chat() {
		return "index";
	}
}
