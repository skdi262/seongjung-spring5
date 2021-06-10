package com.edu.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.service.IF_MemberService;
import com.edu.vo.MemberVO;
import com.edu.vo.PageVO;

/**
 * 이 클래스는 Admin 관리자단에 접근하는 Class입니다
 * 변수 Object를 만들어서 JSP로 전송 + jsp에서 값을 받아서 Object로 처리
 * @author User King 성중
 *수정자 : 아무개 날짜~
 */
@Controller
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	//이 메서드는 회원 목록을 출력하는 jsp와 매핑이됩니다.
	@Inject
	private IF_MemberService memberService;
	@RequestMapping(value="/admin/member/member_list", method = RequestMethod.GET)
	public String SelectMember(PageVO pageVO) throws Exception {
		//jsp의 검색버튼 클릭 시 sesarch_type, search_keyword 내용이 PageVO클래스에 set됩니다. 
	
	// 위에서 검색어를 받아서 역방향 검색 결과를 jsp로 보내기
	if(pageVO.getPage() == null) {//jsp에서 전송값이 없을 때만 초기값 입력
	pageVO.setPage(1);
	}
	//pageVO의 calcPage라는 메서드를 실행하려면 필수 변수값 입력
	pageVO.setTotalCount(memberService.countMember(pageVO));
	pageVO.setQueryPerPageNum(10);
	pageVO.setPerPageNum(10);//하단 UI에 보여줄 갯수
	List<MemberVO> listMember = memberService.selectMember(pageVO);
	//검색이 되든 안 되든 결과의 전체카운트값(페이징 관련 없는 게)
	logger.info("디버그" + pageVO.toString());//지금까지 jsp->controller 일방통행
	return "admin/member/member_list";//상대경로로 줘야됨	
	}
	//URL 요청 경로는 @RequestMappling는 반드시 절대경로로 표시해야함.
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String admin(Model model) throws Exception { //에러 발생시 Exception 클래스의 정보를 스프링으로 보내버림
		//아래 상대경로에서 /WEB-INF/views폴더가  루트(최상위)
		//아래 상대경로에서 home.jsp는 생략됨 이미 들어가있음(suffix로)
		return "admin/home"; // 리턴경로(접근경로)는 상대경로로 표시해야한다.
	}
}
