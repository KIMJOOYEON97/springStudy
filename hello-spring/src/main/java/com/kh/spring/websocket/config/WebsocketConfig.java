package com.kh.spring.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration //이 class내용이 springbean에 대한 내용임을 암시
@EnableWebSocket //websocket 활성화
//websocket등록
public class WebsocketConfig implements WebSocketConfigurer {

	//의존주입
	@Autowired
	WebsocketHandler websocketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//const ws = new WebSocket("ws://localhost:9090/spring/websoooooocket");에 대응한다.
		//websocket이 사용 불가능할 때 다른 방식으로 양방향통신을 구현하고 싶습니다.
		registry
			.addHandler(websocketHandler, "/websoooooocket")
			.withSockJS(); //server side에서도 sockjs선언
		
	}
	
}
