<<<<<<< HEAD
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
	 * multithread ï¿½ï¿½ï¿½ï¿½È­ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½ list
	 * ï¿½ï¿½ï¿½ï¿½ threadï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ threadï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½È®ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ => arrayListï¿½ï¿½ È®ï¿½ï¿½ï¿½ï¿½
	 */
	List<WebSocketSession> sessionList = new CopyOnWriteArrayList<WebSocketSession>();
	
	/**
	 * websocketï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ È£ï¿½ï¿½í•œê¸€
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		//sessionList.size() => ï¿½ï¿½ï¿½ï¿½ ï¿½Î¿ï¿½ï¿½ï¿½ 
		log.debug("onopen({}) : {}",sessionList.size(),session);
	}

	/**
	 * clientï¿½ï¿½ messageï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ È£ï¿½ï¿½
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//onmessageï¿½Þ¼Òµï¿½ ï¿½ï¿½ï¿½ sessionListï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½Ö´ï¿½ TextMessage messageï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		log.debug("onmessage : {} from {}",message,session);
		
		String sender = session.getId();
		TextMessage msg = new TextMessage(sender + ":" +message.getPayload());
		
		for(WebSocketSession sess : sessionList) {																	//getPayload => ï¿½Þ½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
			sess.sendMessage(msg);
		}
		
	}

	/**
	 * websocketï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ È£ï¿½ï¿½
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		log.debug("onclose({})",sessionList.size());
	}
	
	

	
}
=======
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
	 * multithread µ¿±âÈ­¸¦ Áö¿øÇÏ´Â list
	 * ¿©·¯ thread°¡ Á¢±ÙÇßÀ»¶§ ¿©·¯ threadÀÇ ¼ø¼­¸¦ ¸íÈ®È÷ ±¸ºÐ => arrayListÀÇ È®ÀåÆÇ
	 */
	List<WebSocketSession> sessionList = new CopyOnWriteArrayList<WebSocketSession>();
	
	/**
	 * websocket¿¬°á ¼º°øÈÄ È£Ãâ
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		//sessionList.size() => ÇöÀç ÀÎ¿ø¼ö 
		log.debug("onopen({}) : {}",sessionList.size(),session);
	}

	/**
	 * client°¡ message¸¦ Àü¼ÛÇÑ °æ¿ì È£Ãâ
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//onmessage¸Þ¼Òµå »ç¿ë sessionList¸¶´Ù ´ã°ÜÀÖ´Â TextMessage message¸¦ Àü´Þ
		log.debug("onmessage : {} from {}",message,session);
		
		String sender = session.getId();
		TextMessage msg = new TextMessage(sender + ":" +message.getPayload());
		
		for(WebSocketSession sess : sessionList) {																	//getPayload => ¸Þ½ÃÁö ³»¿ë
			sess.sendMessage(msg);
		}
		
	}

	/**
	 * websocket¿¬°á ÇØÁ¦ÈÄ È£Ãâ
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		log.debug("onclose({})",sessionList.size());
	}
	
	

	
}
>>>>>>> 7a04f908a0464ec4af7e667610d5efcd93df2a19
