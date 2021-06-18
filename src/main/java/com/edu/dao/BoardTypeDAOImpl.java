package com.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.vo.BoardTypeVO;

/**
 * 이 클래스는 게시판 생성관리 쿼리의 인터페이스를 구현메서드가 있는 클래스
 * @author 김성중
 *
 */
@Repository
public class BoardTypeDAOImpl implements IF_BoardTypeDAO{
	//sqlSession템플릿 의존성 주입
	@Inject //자바8부터 신규로나온 애노테이션
	private SqlSession sqlSession;
	
	@Override
	public void deleteBoardType(String board_type) throws Exception {
		// sqlSession 템플릿을 이용해서 매퍼쿼리를 실행
		sqlSession.delete("boardTypeMapper.deleteBoardType",board_type);
	}// 서식 sqlSession. ~템플릿 메서드 (SQL쿼리위치,데이터객체변수)

	@Override
	public void updateBoardType(BoardTypeVO boardTypeVO) throws Exception {
		sqlSession.update("boardTypeMapper.updateBoardType", boardTypeVO);
		
	}

	@Override
	public BoardTypeVO readBoardType(String board_type) throws Exception {
		return sqlSession.selectOne("boardTypeMapper.readBoardType", board_type);
	}

	@Override
	public void insertBoardType(BoardTypeVO boardTypeVO) throws Exception {
		sqlSession.insert("boardTypeMapper.insertBoardType", boardTypeVO);
	}

	@Override
	public List<BoardTypeVO> selectBoardType() throws Exception {
		// TODO 매퍼 쿼리를 실행 sqlSession 템플릿을 이용해서 실행
		return sqlSession.selectList("boardTypeMapper.selectBoardType");
	}
	
}
