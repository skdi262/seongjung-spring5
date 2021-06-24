package com.edu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IF_BoardDAO;
import com.edu.vo.AttachVO;
import com.edu.vo.BoardVO;
import com.edu.vo.PageVO;

/**
 * 이 클래스는 DAO 메서드를 호출하는 기능함
 * @author 김성중
 *
 */
@Service
public class BoardServiceImpl implements IF_BoardService {

	@Inject
	private IF_BoardDAO boardDAO;
	
	@Override
	public List<AttachVO> readAttach(Integer bno) throws Exception {
		// 첨부파일 List형으로 조회 DAO 호출
		return boardDAO.readAttach(bno);
	}

	@Override
	public int countBoard(PageVO pageVO) throws Exception {
		//페이징 처리시 PageVO 의 TotalCount 변수에 사용된 값을 리턴값으로 호출 
		return boardDAO.countBoard(pageVO);
	}
	@Transactional
	@Override
	public void deleteBoard(int bno) throws Exception {
		//게시물 삭제할 때 , 여기서는 총 3개의 메서드(댓글,첨부파일 삭제이후 게시물삭제)가 필요함.
		//트랜젝션이 필요한 순간, 작업순서 :1. 첨부파일 삭제,2. 게시물삭제
		//만약 게시물삭제가 에러가 있을 때 방지하려고 @Transantional을 씀
		//*나중에 특이사항 : 첨부파일은 DB만 삭제하는 게 아니라 업로드된 파일을 삭제해야함
		boardDAO.deleteAttachAll(bno);
		//댓글삭제는 나중에...
		boardDAO.deleteBoard(bno);
	}
	@Transactional
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		// 첨부파일 처리 + 게시물 업데이트, 2개의 메서드 실행
		// 첨부파일이 있으면 updateAttach 실행 후 updateBoard실행
		boardDAO.updateBoard(boardVO);
		// 첨부파일 DB처리
		AttachVO attachVO = new AttachVO();
		int bno = boardVO.getBno();
		String[] save_file_names = boardVO.getSave_file_names();
		String[] real_file_names = boardVO.getReal_file_names();
		if(save_file_names == null) {return;}
		int index = 0;
		String real_file_name = "";
		for(String save_file_name:save_file_names) {
			if(save_file_name != null) {//컨트롤러에서 null이 들어갈 수 있는 로직이라 추가
				real_file_name = real_file_names[index];							
				attachVO.setBno(bno);
				attachVO.setSave_file_name(save_file_name);
				attachVO.setReal_file_name(real_file_name);
				boardDAO.updateAttach(attachVO);
				index=index+1;
			}
		}
	}
	@Transactional 
	@Override
	public BoardVO readBoard(int bno) throws Exception {
		// 게시물 상세보기시 2개이상 메서드를 가져오려면 트랜잭션이 필요함
		boardDAO.updateViewCount(bno);
		BoardVO boardVO = boardDAO.readBoard(bno);		
		return boardVO;
	}
	
	@Transactional
	@SuppressWarnings("null")
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		//게시물 insertBoard가 실행 되고 Attach를 입력함
		//게시물등록 + 반환값으로 bno
		int bno  = boardDAO.insertBoard(boardVO);
		//첨부파일등록  : 첨부파일이 1개 이상일때 가정
		String[] save_file_names=boardVO.getSave_file_names(); // 폴더에 저장될 배열 파일명
		String[] real_file_names=boardVO.getReal_file_names(); // UI용 배열파일명
		if(save_file_names == null) {return;} // 리턴이 발생되면 이후 실행안됨
		//첨부파일이 null이 아닐때 진행 null이면 취소
		int index = 0;
		String real_file_name=""; //UI용 1개의 파일명
		AttachVO attachVO = new AttachVO();
		for (String save_file_name:save_file_names){
			if(save_file_name != null) {
			real_file_name = real_file_names[index];			
			attachVO.setBno(bno);
			attachVO.setReal_file_name(real_file_name);
			attachVO.setSave_file_name(save_file_name);			
			boardDAO.insertAttach(attachVO);
			}
			index=index+1;
	}
}
	@Override
	public List<BoardVO> selectBoard(PageVO pageVO) throws Exception {
		// DAO 하나만 실행
		return boardDAO.selectBoard(pageVO);
	}

}
