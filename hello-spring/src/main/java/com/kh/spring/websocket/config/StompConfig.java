<<<<<<< HEAD
package com.kh.spring.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 
 * Stomp
 * - MessageBroker ë°©ì‹ ì²˜ë¦¬
 * - publish ë°œí–‰/subscribe êµ¬ë… íŒ¨í„´ ì²˜ë¦¬ 
 * 	 	-íŠ¹ì •urlì„ êµ¬ë…í•˜ëŠ” subscriberì—ê²Œ ë°œí–‰í•œ ë©”ì‹œì§€ë¥¼ ì „ë‹¬
 *  
 *  
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer{

	/**
	 * clientì—ì„œ ìµœì´ˆ websocket ì ‘ì† urlì„ ì„¤ì •
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
			.enableSimpleBroker("/notice"); 
		// .enableSimpleBroker("/topic","/animal","/coffee"); // ì ‘ë‘ì–´ì´ë‹¤! /coffee/maxim =>ì§€ë‚˜ê°
		//Type null of the last argument to method enableSimpleBroker(String...)
		// String.. -> ê°€ë³€ì¸ìž(Stringê°œìˆ˜ì œí•œ ì—†ì´ ì‚¬ìš©ê°€ëŠ¥)
		
		//2.MessageHandler : /app/a ---> @MessageMapping("/a") 
		//					@MessageMapping=>websocketê°œì—´ì˜ RequestMapping
		registry
			.setApplicationDestinationPrefixes("/admin");
	}
	
	
	
}
=======
package com.kh.spring.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 
 * Stomp
 * - MessageBroker ¹æ½Ä Ã³¸®
 * - publish ¹ßÇà/subscribe ±¸µ¶ ÆÐÅÏ Ã³¸® 
 * 	 	-Æ¯Á¤urlÀ» ±¸µ¶ÇÏ´Â subscriber¿¡°Ô ¹ßÇàÇÑ ¸Þ½ÃÁö¸¦ Àü´Þ
 *  
 *  
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer{

	/**
	 * client¿¡¼­ ÃÖÃÊ websocket Á¢¼Ó urlÀ» ¼³Á¤
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
		// .enableSimpleBroker("/topic","/animal","/coffee"); // Á¢µÎ¾îÀÌ´Ù! /coffee/maxim =>Áö³ª°¨
		//Type null of the last argument to method enableSimpleBroker(String...)
		// String.. -> °¡º¯ÀÎÀÚ(String°³¼öÁ¦ÇÑ ¾øÀÌ »ç¿ë°¡´É)
		
		//2.MessageHandler : /app/a ---> @MessageMapping("/a") 
		//					@MessageMapping=>websocket°³¿­ÀÇ RequestMapping
		registry
			.setApplicationDestinationPrefixes("/app");
	}
	
	
	
}
>>>>>>> 7a04f908a0464ec4af7e667610d5efcd93df2a19
