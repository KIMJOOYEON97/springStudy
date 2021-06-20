package com.kh.spring.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 
 * Stomp
 * - MessageBroker ��� ó��
 * - publish ����/subscribe ���� ���� ó�� 
 * 	 	-Ư��url�� �����ϴ� subscriber���� ������ �޽����� ����
 *  
 *  
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer{

	/**
	 * client���� ���� websocket ���� url�� ����
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry
			.addEndpoint("/stommmp")
			.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//1. SimpleBroker 
		registry
			.enableSimpleBroker("/topic","/bpp"); 
		// .enableSimpleBroker("/topic","/animal","/coffee"); // ���ξ��̴�! /coffee/maxim =>������
		//Type null of the last argument to method enableSimpleBroker(String...)
		// String.. -> ��������(String�������� ���� ��밡��)
		
		//2.MessageHandler : /app/a ---> @MessageMapping("/a") 
		//					@MessageMapping=>websocket������ RequestMapping
		registry
			.setApplicationDestinationPrefixes("/app");
	}
	
	
	
}
