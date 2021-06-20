package com.kh.spring.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration //�� class������ springbean�� ���� �������� �Ͻ�
@EnableWebSocket //websocket Ȱ��ȭ
//websocket���
public class WebsocketConfig implements WebSocketConfigurer {

	//��������
	@Autowired
	WebsocketHandler websocketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//const ws = new WebSocket("ws://localhost:9090/spring/websoooooocket");�� �����Ѵ�.
		//websocket�� ��� �Ұ����� �� �ٸ� ������� ���������� �����ϰ� �ͽ��ϴ�.
		registry
			.addHandler(websocketHandler, "/websoooooocket")
			.withSockJS(); //server side������ sockjs����
		
	}
	
}
