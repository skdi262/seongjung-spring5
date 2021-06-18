package com.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.vo.AttachVO;
import com.edu.vo.BoardVO;
import com.edu.vo.PageVO;

/**
 * 이 클래스는 게시물 CRUD를 구현하는 DAO 클래스입니다. 
 * @author User
 *
 */
@Repository
public class BoardDAOImpl implements IF_BoardDAO{
	private Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class); 
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void deleteAttachAll(Integer bno) throws Exception {
		sqlSession.delete("boardMapper.deleteAttachAll", bno);
		//sql 템플릿을 사용한 매퍼쿼리 호출
	}

	@Override
	public void deleteAttach(String save_file_name) throws Exception {
		sqlSession.delete("boardMapper.deleteAttach", save_file_name);
	}

	@Override
	public void updateAttach(AttachVO attachVO) throws Exception {
		sqlSession.insert("boardMapper.updateAttach", attachVO);
		//메서드명은 업데이트지만 insert로 작업하게 실제쿼리를 만듬
	}

	@Override
	public void insertAttach(AttachVO attachVO) throws Exception {
		sqlSession.insert("boardMapper.insertAttach", attachVO);
		
	}

	@Override
	public List<AttachVO> readAttach(Integer bno) throws Exception {
		return sqlSession.selectOne("boardMapper.readAttach", bno);
	}

	@Override
	public void updateViewCount(Integer bno) throws Exception {
		sqlSession.update("boardMapper.updateBoard", bno);
	}

	@Override
	public int countBoard(PageVO pageVO) throws Exception {
		return sqlSession.selectOne("boardMapper.countBoard",pageVO);
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		sqlSession.delete("boardMapper.deleteBoard", bno);
		
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		sqlSession.update("boardMapper.updateBoard", boardVO);
		
	}

	@Override
	public BoardVO readBoard(int bno) throws Exception {
		return sqlSession.selectOne("boardMapper.readBoard", bno);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		logger.info("디버그 : " + boardVO.getBno());
		sqlSession.insert("boardMapper.insertBoard", boardVO);
		return boardVO.getBno();
		
	}

	@Override
	public List<BoardVO> selectBoard(PageVO pageVO) throws Exception {
		// sqlSession을 사용해 매퍼쿼리 시행
		return sqlSession.selectList("boardMapper.selectBoard", pageVO);
	}

}
