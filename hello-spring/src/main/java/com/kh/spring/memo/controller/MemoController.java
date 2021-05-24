package com.kh.spring.memo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.kh.spring.memo.model.service.MemoService;
import com.kh.spring.memo.model.vo.Memo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@GetMapping("/memo.do")
	public ModelAndView selectMemoList(
			ModelAndView mav) {
		log.debug("memoService = {}",memoService.getClass()); //memoService = class com.sun.proxy.$Proxy40
		//MemoServiceImpl이 아니다. 의존주입된 객체는 다 proxy객체다(실행할 때 동적으로 만들어짐) 
		
		//1. 업무로직
		List<Memo> list = memoService.selectMemoList();
		log.info("memoList = {}",list);
		
		mav.addObject("list",list);
		mav.setViewName("memo/memo");
		return mav;
	}
	
	@PostMapping("/insertMemo.do")
	public ModelAndView insertMemo(
			ModelAndView mav,
			Memo memo,
			HttpServletRequest request) {
		try {
			//1. 업무로직
			int result = memoService.insertMemo(memo);
			
			log.info("insertmemo = {}",memo);
			
			//2. 사용자 피드백
			//리다이렉트시 자동생성되는 queryString 방지
			RedirectView view = new RedirectView(request.getContextPath()+"/memo/memo.do");
			view.setExposeModelAttributes(false);
			mav.setView(view);
			
			//redirectAttr 대신 FlashMap
			FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
			flashMap.put("msg","메모 등록 성공");
			
			mav.addObject("memo", memo);
			
		}catch(Exception e) {
			log.error("메모 등록 오류",e);
			throw e;
		}
			
		return mav;
	}
	
	@PostMapping("/deleteMemo.do")
	public ModelAndView deleteMemo(
			ModelAndView mav,
			@RequestParam int no,
			HttpServletRequest request) {
		try {
			
			int result = memoService.deleteMemo(no);
			
			log.info("no = {}",no);
			
			FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
			flashMap.put("msg", "메모 삭제 성공");
			
			//리다이렉트시 자동생성되는 queryString 방지
			RedirectView view = new RedirectView(request.getContextPath()+"/memo/memo.do");
			view.setExposeModelAttributes(false);
			mav.setView(view);
			
		}catch(Exception e) {
			log.error("memo 삭제 오류!", e);
			throw e;
		}
		
		return mav;
	}
	
}
