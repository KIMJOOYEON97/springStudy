package com.kh.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * PSA Portable Service Abstraction 이동가능한 서비스추상체
 * 
 *
 *	Slf4j - 스프링이 제공하는 logging 추상체
 *
 * 구현체를 직접적으로 쓰지 않고
 * 추상체를 통해 구현체를 제어
 * -> 이점 : 각각 제각각인 구현체를 직접적으로 사용하면 log4j메소드를 사용한 코드를 logback으로 바꿀 때 코드를 못쓰지만
 *   	    추상체를 통하면 일관되게 코드흐름을 제어할 수 있다.
 * 
 * 구현체
 * 1. log4j
 * 2. java.util.logging
 * 3. apache logging
 * 4. logback
 *	
 */
@Slf4j
public class Slf4jTest {

	private static final Logger log = LoggerFactory.getLogger(Slf4jTest.class);
	
	public static void main(String[] args) {
		//log.fatal("fatal"); //slf4j에는 fatal레벨이 없다
		log.error("error - {}" ,"메세지메세지");
		log.warn("warn");
		log.info("info");
		log.debug("debug");
		log.trace("trace");
	}
	
}
