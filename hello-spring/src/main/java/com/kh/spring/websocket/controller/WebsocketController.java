<<<<<<< HEAD
package com.kh.spring.websocket.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring.websocket.vo.Notice;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/ws")
@Slf4j
public class WebsocketController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@GetMapping("/websocket.do")
	public void websocket() {
	}
	
	@GetMapping("/sockjs.do")
	public void sockjs() {
		
	}
	
	@GetMapping("/stomp.do")
	public void stomp() {
		
	}
	
	@GetMapping("/someRequest.do")
	@ResponseBody
	public Map<String, Object> someRequest() {
		//MessageBroker 이용하기
		Notice notice = new Notice();
		notice.setFrom("Foo어패럴");
		notice.setTo("abcde");
		notice.setMessage("Foo어패럴의 신상품이 등록되었습니다.");
		notice.setType("NewProduct");
		notice.setTime(System.currentTimeMillis());
		
		simpMessagingTemplate.convertAndSend("/notice/abcde", notice);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("msg", "신상품이 정상 등록되었습니다. 신상품을 고객들에게 공지했습니다.");
		
		return map;
	}
	
}
=======
package com.kh.spring.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/ws")
@Slf4j
public class WebsocketController {

	@GetMapping("/websocket.do")
	public void websocket() {
	}
	
	@GetMapping("/sockjs.do")
	public void sockjs() {
		
	}
	
	@GetMapping("/stomp.do")
	public void stomp() {
		
	}
	
}
>>>>>>> 7a04f908a0464ec4af7e667610d5efcd93df2a19
