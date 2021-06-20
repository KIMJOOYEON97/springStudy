package com.kh.spring.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 
 * Stomp
 * - MessageBroker 방식 처리
 * - publish 발행/subscribe 구독 패턴 처리 
 * 	 	-특정url을 구독하는 subscriber에게 발행한 메시지를 전달
 *  
 *  
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer{

	/**
	 * client에서 최초 websocket 접속 url을 설정
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
		// .enableSimpleBroker("/topic","/animal","/coffee"); // 접두어이다! /coffee/maxim =>지나감
		//Type null of the last argument to method enableSimpleBroker(String...)
		// String.. -> 가변인자(String개수제한 없이 사용가능)
		
		//2.MessageHandler : /app/a ---> @MessageMapping("/a") 
		//					@MessageMapping=>websocket개열의 RequestMapping
		registry
			.setApplicationDestinationPrefixes("/app");
	}
	
	
	
}
