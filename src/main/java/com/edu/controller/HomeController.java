package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 이 클래스는 MVC 웹 프로젝트를 최초로 생성시 자동으로 생성되는 클래스
 * 웹브라우저의 요청사항을 view단(jsp)에 연결시켜주는 클래스 @Conroller
 * 스프링에서 관리하는 클래스를 스프링빈을 명시 @Controller 
 * beans 그래프로 프로젝트의 규모를 확인할 수가 있다.
 * 스프링이 관리하는 프로그램 앞에는 S 가 붙는다.
 * 
 */

@Controller
public class HomeController {
	//스프링빈에서는 logger로 debug 함. - 로거 객체를 만듬
//	private Logger logger = Logger.
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
	/**
	 * return 값으로 view를 선택해 화면에 결과를 랜더링 함.
	 * 사용자 요청을 받아 = @RequestMappling 인터페이스를 사용해 메서드명을 스프링이 구현함. , router(루트 rootX)
	 * 폼(자료) 전송시 post(자료 숨김), get(자료노출-URL 쿼리 스트링 : ?)
	 */ 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) { //콜백 메서드, 자동실행됨.
		String jspVar = "@서비스 (DB)에서 처리한 결과";		
		model.addAttribute("jspObject", jspVar ); //home.jsp파일로 자료를 전송하는 기능 model		
		return "home"; //확장자가 생략. JSP가 생략
	}
	
}
