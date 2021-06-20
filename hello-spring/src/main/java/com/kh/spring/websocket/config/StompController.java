package com.kh.spring.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StompController {

	/**
	 * /app/a�� ���޽� , /app�� setApplicationDestinationPrefixes�� ��ϵǾ� �����Ƿ�
	 * @MessageMapping("/a") messageHandler�� ����
	 *  - prefix �����ϰ� �ۼ��� ��.
	 *  
	 * @SendTo("/bpp/a")�� ���� SimpleBroker�� ���޵ȴ�.
	 * - SimpleBroker�� /bpp�� ��ϵǾ� �־�� �Ѵ�.
	 *  
	 */
	@MessageMapping("/a")
	@SendTo("/bpp/a")
	public String app(String msg) {
		log.debug("/app ��û : {}", msg);
		return msg;
	}
	
}
