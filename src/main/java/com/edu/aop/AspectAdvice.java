package com.edu.aop;

import java.util.List;

import javax.inject.Inject;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.edu.service.IF_BoardTypeService;
import com.edu.vo.BoardTypeVO;

/**
 * 이 클래스는 aop기능 중 @Aspect와 @ControllerAdvice 로 구현이 됩니다. 
 * @author 김성중
 *
 */
@Aspect
@ControllerAdvice
public class AspectAdvice {
	@Inject
	private IF_BoardTypeService boardTypeService;
	//이 메서드는 컨트롤러의 메서드가 실행되기 전에 값을 생성해서 모델객체에 담아 jsp로 보내줌.
	//위 @컨트롤러 어디바이스를 이용해서 컨트롤러에서 모든 메서드가 실행되기전에 호출만되면 아래 메서드가 자동실행됨 
	@ModelAttribute("listBoardTypeVO")
	public List<BoardTypeVO> listBoardTypeVO() throws Exception {
		return boardTypeService.selectBoardType();
	}

}
