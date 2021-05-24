package com.kh.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // 빈 등록
@Aspect // aspect클래스 등록. pointcut, advice를 가지고 있음.
public class LoggerAspect {
	
	@Pointcut("execution(* com.kh.spring.memo..selectMemoList(..))")
	public void loggerPointcut() {}
	
	/**
	 * Around Advice ->자유도가 높아서(filter(서블릿 앞뒤), interceptor(핸들러 앞뒤, jsp뒤)에 비해) 원하는 곳에 낑겨넣을 수 있다.
	 * - JoinPoint 실행전, 실행후에 삽입되어 처리되는 advice(보조업무)
	 * 
	 * ProceedingJoinPoint joinPoint
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable 
	 */
	//advice 연결 pointcut선언한 메소드의 이름을 해주면된다.
	@Around("loggerPointcut()")
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		
		//before
		log.debug("----- {} start -----", signature);
		
		
		//주업무 joinPoint실행
		Object returnObj = joinPoint.proceed();
		
		//after
		log.debug("----- {} end -----", signature);
		
		return returnObj;
	}
	
}

