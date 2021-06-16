package com.edu.service;

import java.util.List;

import com.edu.vo.BoardTypeVO;

/**
 * 이 인터페이스는 DAO클래스를 접근하는 서비스입니다.
 * DAO와 똑같으나 , 나중에는 DAO 10개 -> 서비스 5개로 해결가능 
 * 스프링부트 위과정이 1개로 합쳐져있어상대적으로 간단한 프로젝트에 부트를 사용
 * @author User
 *
 */
public interface IF_BoardTypeService {
	//CRUD 메서드 명세만 생성(아래5개)
		public void deleteBoardType(String board_type) throws Exception;
		public void updateBoardType(BoardTypeVO boardTypeVO) throws Exception;
		public BoardTypeVO readBoardType(String board_type) throws Exception;
		public void insertBoardType(BoardTypeVO boardTypeVO) throws Exception;
		//BoardTypeVO라는 한개의 레코드를 저장한 클래스를 List(제네릭타입)배열형 다중레코드로 받기위해.
		public List<BoardTypeVO> selectBoardType() throws Exception;

}
