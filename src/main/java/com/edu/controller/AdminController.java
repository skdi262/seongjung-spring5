package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 이 클래스는 Admin 관리자단에 접근하는 Class입니다
 * 변수 Object를 만들어서 JSP로 전송 + jsp에서 값을 받아서 Object로 처리
 * @author User King 성중
 *수정자 : 아무개 날짜~
 */

@Controller
public class AdminController {
	//URL 요청 경로는 @RequestMappling는 반드시 절대경로로 표시해야함.
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		//아래 상대경로에서 /WEB-INF/views폴더가  루트(최상위)
		//아래 상대경로에서 home.jsp는 생략됨 이미 들어가있음(suffix로)
		return "admin/home"; // 리턴경로(접근경로)는 상대경로로 표시해야한다.
	}
}
