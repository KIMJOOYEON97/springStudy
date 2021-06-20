package com.kh.spring.websocket.config;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebsocketHandler extends TextWebSocketHandler {
	
	/**
	 * multithread 동기화를 지원하는 list
	 * 여러 thread가 접근했을때 여러 thread의 순서를 명확히 구분 => arrayList의 확장판
	 */
	List<WebSocketSession> sessionList = new CopyOnWriteArrayList<WebSocketSession>();
	
	/**
	 * websocket연결 성공후 호출
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		//sessionList.size() => 현재 인원수 
		log.debug("onopen({}) : {}",sessionList.size(),session);
	}

	/**
	 * client가 message를 전송한 경우 호출
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//onmessage메소드 사용 sessionList마다 담겨있는 TextMessage message를 전달
		log.debug("onmessage : {} from {}",message,session);
		
		String sender = session.getId();
		TextMessage msg = new TextMessage(sender + ":" +message.getPayload());
		
		for(WebSocketSession sess : sessionList) {																	//getPayload => 메시지 내용
			sess.sendMessage(msg);
		}
		
	}

	/**
	 * websocket연결 해제후 호출
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		log.debug("onclose({})",sessionList.size());
	}
	
	

	
}
