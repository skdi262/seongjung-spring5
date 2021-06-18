package com.edu.service;

import java.util.List;

import com.edu.vo.AttachVO;
import com.edu.vo.BoardVO;
import com.edu.vo.PageVO;

/**
 * 이 인터페이스는 게시판에 관련된 Service
 * DAO클래스의 12개 메서드가 7개로 줄음. 나머지 5개는 구현클래스에 사용
 * @author 김성중
 *
 */
public interface IF_BoardService {
	//DAO 클래스에 있는 CRUD 메서드 제외 -> 대신 구현클래스에서 사용만 함
	public List<AttachVO> readAttach(Integer bno) throws Exception;
	// 상세보기 시 조회수 올리는 메서드 제외 > 구현클래스에서 만 사용
	//페이징 없는 검색됨(board_type) 게시물 개수
	public int countBoard(PageVO pageVO) throws Exception;
	//기본 CRUD
	public void deleteBoard(int bno) throws Exception;
	public void updateBoard(BoardVO boardVO) throws Exception;
	public BoardVO readBoard(int bno) throws Exception;
	public void insertBoard(BoardVO boardVO) throws Exception;
	public List<BoardVO> selectBoard(PageVO pageVO) throws Exception;
}
