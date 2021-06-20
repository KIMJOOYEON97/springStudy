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
	 * multithread ����ȭ�� �����ϴ� list
	 * ���� thread�� ���������� ���� thread�� ������ ��Ȯ�� ���� => arrayList�� Ȯ����
	 */
	List<WebSocketSession> sessionList = new CopyOnWriteArrayList<WebSocketSession>();
	
	/**
	 * websocket���� ������ ȣ��한글
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		//sessionList.size() => ���� �ο��� 
		log.debug("onopen({}) : {}",sessionList.size(),session);
	}

	/**
	 * client�� message�� ������ ��� ȣ��
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//onmessage�޼ҵ� ��� sessionList���� ����ִ� TextMessage message�� ����
		log.debug("onmessage : {} from {}",message,session);
		
		String sender = session.getId();
		TextMessage msg = new TextMessage(sender + ":" +message.getPayload());
		
		for(WebSocketSession sess : sessionList) {																	//getPayload => �޽��� ����
			sess.sendMessage(msg);
		}
		
	}

	/**
	 * websocket���� ������ ȣ��
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		log.debug("onclose({})",sessionList.size());
	}
	
	

	
}
