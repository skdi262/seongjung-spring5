package com.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.vo.MemberVO;

/**
 * 이 클래스는 IF_memberDAO 인터페이스를 구현하는 클래스
 * implements 키워드로 상속을 받음.
 * 단, DAO 기능의 구현클래스는 스프링 빈으로 등록을 해서 사용해야함.@Repository
 * @author User
 *
 */
@Repository
public class MemberDAOImpl implements IF_MemberDAO {
	@Inject //SQlSession 스프링빈으로 주입.
	private SqlSession sqlSession;
	
	@Override
	public List<MemberVO> selectMember() throws Exception {
		//Sql Session 메서드를 이용해서 매퍼 쿼리를 사용
		List<MemberVO> listMember = sqlSession.selectList("memberMapper.selectMember");
		return listMember;
	}
}
