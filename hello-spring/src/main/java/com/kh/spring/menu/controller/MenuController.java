package com.kh.spring.menu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {

	@GetMapping("/menu.do")
	public void menu() {
		
	}
	
	/**
	 * 현재서버를 proxy로 RestServer에 요청을 보낸다.
	 * 응답 data를 그대로 client에게 다시 응답한다.
	 * 
	 * produces => 최종적으로 무엇을 리턴하느냐
	 * @return
	 * @throws IOException 
	 */
	@GetMapping(
			value = "/selectMenuList.do",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE
			)
	@ResponseBody
	public String selectMenuList() throws IOException {
		//String => json문자를 그대로 보내줌
		
		try {
			//1.rest server요청
			String menuUrl = "http://localhost:10000/springboot/menus";
			URL url = new URL(menuUrl);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			//2. 응답메시지 : 자바변수에 기록
			String data = "";
			StringBuilder sb = new StringBuilder();
			while((data = br.readLine()) != null) {
				sb.append(data);
			}
			log.debug("응답 json ={}",sb.toString());
			
			//3. client에 전송
			return sb.toString();
		} catch (Exception e) {
			log.error("menu 전체 조회 오류!",e);
			throw e;
		}
	}
	
	@GetMapping(
			value ="/selectListType.do",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE
			)
	@ResponseBody
	public String selectListType(@RequestParam String type,@RequestParam String taste) throws IOException {
		
		try {
			log.debug("type={},taste={}",type,taste);
			
			String menuUrl ="http://localhost:10000/springboot/menus/"+type+"/"+taste;
			URL url = new URL(menuUrl);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			String data ="";
			StringBuilder sb = new StringBuilder();
			while((data=br.readLine()) != null) {
				sb.append(data);
			}
			log.debug("응답 json ={}",sb.toString());
			return sb.toString();
		} catch (Exception e) {
			log.error("menu type 조회 오류!",e);
			throw e;
		} 
	}
	
	@GetMapping(
			value ="/selectOneMenu/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE
			)
	@ResponseBody
	public String selectOneMenu(@PathVariable String id) throws IOException {
		try {
			String menuUrl = "http://localhost:10000/springboot/menu/"+id;
			URL url = new URL(menuUrl);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			String data="";
			StringBuilder sb = new StringBuilder();
			while((data=br.readLine()) != null) {
				sb.append(data);
			}
			log.debug("응답 json ={}",sb.toString());
			return sb.toString();
		} catch (Exception e) {
			log.error("menu one 조회 오류!",e);
			throw e;
		} 
	}
	
	//?post 방식이 되는지 모르겠다...어떻게 하지??
	
	@PostMapping(
			value ="/insertMenu.do",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE
			)
	@ResponseBody
	public String insertMenu(@RequestBody Object menu) throws Exception{
		try {
			log.debug("menu={}",menu);
			String menuUrl = "http://localhost:10000/springboot/menu";
			URL url = new URL(menuUrl);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			String data="";
			StringBuilder sb = new StringBuilder();
			while((data=br.readLine()) != null) {
				sb.append(data);
			}
			log.debug("응답 json ={}",sb.toString());
			return sb.toString();
		} catch (Exception e) {
			log.error("menu 등록 오류!",e);
			throw e;
		} 
	}
	
}
