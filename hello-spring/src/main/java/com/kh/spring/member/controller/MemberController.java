package com.kh.spring.member.controller;

import java.beans.PropertyEditor;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.kh.spring.demo.controller.DemoController;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

/**
 * Model
 * MVC패턴의 Model이 아니다.
 * view단에 전달하기 위한 데이터를 저장하는 Map
 * 
 * HandlerMapping이 제어해서 제공
 * 1. Model<<interface>>
 * 		-addAttribute(name, value) -> 데이터를 넣는 메소드
 * 		-viewName:String을 리턴
 * 2. ModelMap
 * 		-Model interface의 구현체
 * 		-addAttribute(name, value) -> 데이터를 넣는 메소드
 * 		-viewName:String을 리턴
 * 3. ModelAndView
 * 		-addObject(name, value)
 * 		-setViewName를 이용해서 viewName설정
 * 		-ModelAndView객체를 리턴
 * 
 * -> 결국은 ModelAndView로 통합되서 spring container에 의해 관리된다.
 *
 * @ModelAttribute | @SessionAttribute
 * - handler의 메개변수 앞에 사용
 * - 모델에 저장된 속성에 대한 getter
 * - name, required(기본값 :  true) 지정이 가능하다
 *
 * @ModelAttribute
 * - method레벨에 작성
 * - 이 메소드에서 model속성 setter로 사용
 * - 현재 controller클래스의 모든 handler에 앞서 실행되며, 모든 요청에서 해당 데이터 접근 가능
 * 
 *
 */
@Controller
@RequestMapping("/member")
@Slf4j
@SessionAttributes({"loginMember","next"})
public class MemberController {

	//private static final Logger log = LoggerFactory.getLogger(DemoController.class);
	//=>@Slf4j
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	/**
	 * view단에서는 ${common.adminEmail}, ${common.adminPhone} 사용가능
	 * 
	 * @return
	 */
	@ModelAttribute("common")
	public Map<String, Object> common(){
		log.info("@ModelAttribute(\"common\")");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("adminEmail","admin@kh.or.kr");
		map.put("adminPhone","070-1234-5678");
		return map;
	}
	
	
	@GetMapping("/memberEnroll.do")
	public void memberEnroll() {
		// /WEB-INF/views/member/memberEnroll.jsp로 자동포워딩됨.
		// DefaultRequestToViewNameTranslator빈이 요청주소에서 viewName을 유추함.
	}

	@PostMapping("/memberEnroll.do")
	public String memberEnroll(Member member, RedirectAttributes redirectAttr) {
		try {
			//0. 비밀번호 암호화 처리
			String rawPassword = member.getPassword();
			String encodedPassword = bcryptPasswordEncoder.encode(rawPassword);
			member.setPassword(encodedPassword);
			log.info("member 암호화 처리 이후 ={}", member);
			
			log.info("member ={}",member);
			//1. 업무로직
			int result = memberService.insertMember(member);
			
			//2. 사용자피드백
			redirectAttr.addFlashAttribute("msg","회원가입성공");
			
		}catch(Exception e) {
			log.error("회원가입오류",e);
			throw e;
		}
		
		return "redirect:/";
	}
	/**
	 * java.sql.Date, java.util.Date 필드에 값대입시
	 * 사용자 입력값이 ""인 경우 null로 처리될 수 있도록 설정하는 것
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//springframework.beans.propertyeditors.CustomDateEditor.CustomDateEditor(DateFormat dateFormat, boolean allowEmpty)
		PropertyEditor editor = new CustomDateEditor(format,true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@GetMapping("/memberLogin.do")
	public void memberLogin(
			//next 이전에 요청했던(가려고했던) 페이지
			@SessionAttribute(required = false) String next,
			//referer 이번에 요청했던(가려고했던) 페이지 
			@RequestHeader(name="referer", required=false) String referer, 
			Model model) {
		log.info("referer = {}",referer);
		if(next == null && referer != null)
			 model.addAttribute("next",referer);
	}
	
	@PostMapping("/memberLogin.do")
	public String memberLogin(
			@RequestParam String id, 
			@RequestParam String password, 
			@SessionAttribute(required=false) String next,
			Model model,
			RedirectAttributes redirectAttr) {
		
		String str = "홍길동";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("str", str);
		
		map.put("str", null);
		log.info("{},{}",str,str ==null); //홍길동, false
		log.info("map = {}",map); //map = {str=null}
		//map.put("str", null); 을 주석했을 경우 map = {str=홍길동} 
		
		
		//1. 업무로직
		Member member = memberService.selectOneMember(id);
		log.info("memberLogin={}",member);
		
		//비밀번호 1234로 되어있는 회원정보 암호화비번으로 바꾸는 작업을 하기위한 암호화비번 알아내기
		log.info("encryptedPassword = {}",bcryptPasswordEncoder.encode(password));
		
		//2. 로그인여부 분기처리
//		&& password.equals(member.getPassword())
		//boolean org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.matches(CharSequence rawPassword, String encodedPassword)
		if(member != null && bcryptPasswordEncoder.matches(password, member.getPassword())) {
			log.info("로그인 성공");
			//로그인 성공
			
			//model request session 둘다 처리 가능
			//loginMember 세션속성으로 저장하려면, class에 @SessionAttributes로 등록
			model.addAttribute("loginMember", member);
		}
		else {
			//로그인 실패
			redirectAttr.addFlashAttribute("msg","아이디 또는 비밀번호가 틀립니다.");
			return "redirect:/member/memberLogin.do";
		}
		
		//사용한 next값은 제거 //String next에 referer값이 저장되어있음으로 제거해도 무방
		model.addAttribute("next",null); //여기에 담긴 next는 일종의 키값
		//model은 일종의 map이기 때문에 next라는이름에 값을 null로 만든 것이다
		//String next랑은 다르다.
		
		log.info("next ={}",next); //로그인 전에 있던 페이지.
		//model의 속성 next가 아니라, 문자열 변수 next에 담긴 값을 출력하니까요
		
		return "redirect:"+(next != null? next:"/");
	}

	/**
	 * @SessionAttributes를 통해서 등록한 session속성은
	 * SessionStatus객체에 대해서 complete처리해야한다.
	 *  						다썼어요!
	 * @return
	 */
	@GetMapping("/memberLogout.do")
	public String memberLogout(SessionStatus status) {
		if(!status.isComplete())
			status.setComplete();
		return "redirect:/";
	}
	
	/**
	 * 로그인한 사용자 정보 열람하기
	 */
	@GetMapping("/memberDetail.do")
	public ModelAndView memberDetail(
			ModelAndView mav, 
			@SessionAttribute(name ="loginMember") Member loginMember,
			
			//여기서 referer값을 주어야 update취소시 이전 페이지로 넘어갈 수 있다.
			Model model,
			@SessionAttribute(required=false) String next, 
			@RequestHeader(name="referer", required=false) String referer
			) {
		//session에 저장된 속성을 꺼내서 볼 수 있다.
		log.info("loginMember = {}",loginMember);
		//속성 저장
		mav.addObject("time",System.currentTimeMillis());
		//viewName 설정
		mav.setViewName("member/memberDetail");
		
		//update 취소시
		log.info("next = {}",next); // 이전에 요청했던 페이지 만약 로그인전에 다른 페이지에 있었다면 그 페이지
		log.info("referer = {}",referer); // 이번에 요청하는 페이지에서 말하는 전에 가고자 했던 페이지
		//문제는 여기
		//@SessionAttribute(required=false) String next 이것의 의미를 모르겠다. -> 이전 요청에서 이전에 가고자했던 페이지
		//if(next == null && referer != null)
		//next가 null이 나오지 않는 이유는?
		if(referer != null)
			 model.addAttribute("next",referer);
		
		return mav;
	}
	
/*	@PostMapping("/memberUpdate.do")
	public String memberUpdate(
			Model model, 
			Member member, 
			RedirectAttributes redirectAttr) {
			//@RequestHeader(name="referer", required=false) String referer) { 취소시 원래 페이지로 돌아가는 referer 여기가 아님
		try {
			int result = memberService.updateMember(member);
			redirectAttr.addFlashAttribute("msg","회원정보 수정 성공");
			
			log.info("updateMember = {}",member);

			model.addAttribute("loginMember",member);
	
			
		} catch(Exception e) {
			log.error("회원정보 수정 오류!",e);
			throw e;
		}
		

		return "redirect:/";
		
	}
*/	
	
	@PostMapping("/memberUpdate.do")
	public ModelAndView memberUpdate(
			ModelAndView mav, 
			@ModelAttribute Member member, 
//			@ModelAttribute("loginMember") Member loginMember, 
//			RedirectAttributes redirectAttr,
			HttpServletRequest request) {
			//@RequestHeader(name="referer", required=false) String referer) { 취소시 원래 페이지로 돌아가는 referer 여기가 아님
		log.debug("updateMember member= {}",member);
//		log.debug("updateMember loginmember= {}",loginMember);
		try {
			//1. 업무로직
			int result = memberService.updateMember(member);
			
			//2. 사용자 피드백 & 리다이렉트
//			mav.setViewName("redirect:/member/memberDetail.do");
			
			//리다이렉트시 자동생성되는 queryString 방지
			RedirectView view = new RedirectView(request.getContextPath()+"/member/memberDetail.do");
			//url관련한 것을 자동으로 붙여주는 속성
			view.setExposeModelAttributes(false); //이 설정을 할려고 view객체를 사용함
			mav.setView(view);
			

			//ModelAndView와 RedirectAttributes 충돌시 FlashMap을 직접 사용
			FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
			flashMap.put("msg","사용자 정보 수정 성공!!!!!");
//			redirectAttr.addFlashAttribute("msg","사용자정보 수정 성공");
			

			mav.addObject("loginMember",member);
	
			
		} catch(Exception e) {
			log.error("회원정보 수정 오류!",e);
			throw e;
		}
		

		return mav;
		
	}
	
	@GetMapping("/updateCancel.do")
	public String updateCancel(
			@SessionAttribute(required=false) String next,
			Model model,
			RedirectAttributes redirectAttr) {
		
			model.addAttribute("next",null);
			
			log.info("updateCancel next={}",next);
		
			return "redirect:"+(next != null? next:"/");
	}
}
