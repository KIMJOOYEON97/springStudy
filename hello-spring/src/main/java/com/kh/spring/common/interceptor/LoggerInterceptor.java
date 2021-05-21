package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter{

	/**
	 * Handler 호출전
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.debug("=========================start========================");
		//요청 주소
		log.debug(request.getRequestURI());
		log.debug("------------------------------------------------------");
		
		return super.preHandle(request, response, handler); //무조건 true를 리턴 만약 false가 되면 이후 코드 실행X
	}

	/**
	 * Handler 리턴이후
	 * (ModelAndView객체 확인 가능) -> ModelAndView로 통합된 것 여기서 볼 수 있음
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		log.debug("------------------------------------------------------");
		log.debug("modelAndView ={}",modelAndView);
	}

	/**
	 * view단(jsp) 작업이후
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.debug("------------------------view--------------------------");
		super.afterCompletion(request, response, handler, ex);
		log.debug("________________________end___________________________\n");
		
	}

	
}
