package com.edu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.edu.dao.IF_MemberDAO;
import com.edu.vo.MemberVO;

/**
 * 이 클래스는 회원관리 서비스 인터페이스를 구현하는 클래스
 * 상송 extends, 구현 implements 키워드를 사용
 * @Service 애노테이선을 명시, 스프링 빈 등록해야댐
 * @author 김성중, 
 *
 */
@Service
public class MemberServiceImpl implements IF_MemberService {
	@Inject //IF_MemberDAO를 주입해서 객체로 사용
	private IF_MemberDAO memberDAO;

	@Override
	public List<MemberVO> selectMember() throws Exception {
		// 인터페이스에서 상속받은 메서드를 구현
//		List<MemberVO> listMember = memberDAO.selectMember();
		return memberDAO.selectMember();
	}

}
