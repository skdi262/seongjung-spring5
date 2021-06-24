package com.edu.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edu.dao.IF_BoardDAO;
import com.edu.service.IF_MemberService;
import com.edu.vo.MemberVO;

/**
 * 이 클래스는 이 프로젝트에서 공통으로 사용하는 유틸리티기능을 모아놓은 클래스. 
 * @author 김성중
 * 컨트롤러 기능 @Controller(jsp와 바인딩이 필요할때는 필수 애노테이션 입니다.)
 * 콤포턴트 @Component는 MVC가 아닌 기능들을 모아놓은 스프링빈 명시, 여기서는 jsp와 바인딩이 필요해서 사용않함 
 */
@Controller
public class CommonUtil {
	//멤버변수생성(아래)
	private Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	@Inject
	private IF_MemberService memberService;//스프링빈을 주입받아서(DI) 객체준비
	@Inject IF_BoardDAO boardDAO;
	//첨부파일 업로드/다운로드/삭제/업데이트/인서트에 모두 사용될 파일저장경로를 지정해 전역으로 사용
		//root-context에 있는 uploadPath에서 resource로 가져와서 private 변수 지정
		@Resource(name="uploadPath")
		private String uploadPath;
		public String getUploadPath() {
			return uploadPath;
		}
		
		//첨부파일 개별삭제 Ajax로 받아서 처리,@ResponseBody 사용
		@RequestMapping(value="/file_delete", method=RequestMethod.POST)
		@ResponseBody
		public String file_delete(@RequestParam("save_file_name")String save_file_name) { //Ajax는 예외처리를 스프링에 던지지 않고, try~catch문으로 처리.
			String result = "";//Ajax로 보내는 값변수
			try {
				boardDAO.deleteAttach(save_file_name);
				File target = new File(uploadPath + "/" + save_file_name);
				if(target.exists()) {
					target.delete();
				}
				result = "success";
			} catch (Exception e) {
				result = "fail: " + e.toString();
			}
			return result;//Ajax에서 바로확인 가능
		}
		//다운로드 처리 ResponseBody 사용
	@RequestMapping(value="/download", method=RequestMethod.GET)
	@ResponseBody
	public FileSystemResource download(@RequestParam("save_file_name") String save_file_name, @RequestParam("real_file_name") String real_file_name, HttpServletResponse response) throws Exception {
		//FileSystemResource는 스프링 코어에서 제공하는 파일 다운로드 처리전용 클래스
		File file = new File(uploadPath + "/" + save_file_name);
		//아래한글 , ppt 문서에서 한글이 깨지는 것을 방지하는 코드
		response.setContentType("application/download; utf-8");
		real_file_name = URLEncoder.encode(real_file_name);//IE에서 한글이 안 꺠지게
		response.setHeader("Content-Disposition", "attachment;filename=" + 
				real_file_name);
		return new FileSystemResource(file);
	}		
		
	//같은 페이지에 페이지 이동이 아닌 결과값만 반환 @ResponseBody 
	@RequestMapping(value="/image_preview", method=RequestMethod.GET)
	@ResponseBody  
	public ResponseEntity <byte[]> imagePreview(@RequestParam("save_file_name") String save_file_name, HttpServletResponse reponse ) throws Exception{
		//파일을 입출력할 때는 파일을 byte 형식으로 입출력할 때 발생되는 통로 : 스트링
		FileInputStream fis = null;//입력통로
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//출력통로
		fis = new FileInputStream(uploadPath + "/" + save_file_name);
		int readCount = 0;
		byte[] buffer = new byte[1024];//임시 저장소
		byte[] fileArray = null; // 추력 스트링 결과를 저장하는 공간
		//반복문 - fis 로 입력받는 save_file_name을 byte값(배열)이 -1일 때 까지 반복
		while((readCount = fis.read(buffer)) != -1) {
			//입력통로 fis에서 출력통로로 보냄 (baos) 파일입출력은 바이트단위로만 가능
			baos.write(buffer, 0, readCount);//rawData, 종료조건, 길이
			//결과는 baos에 누적이 됨 - jsp로 보내주면 됨
		}
		fileArray = baos.toByteArray();//baos 객체를  byte 배열로 파싱
		fis.close();//메모리 초기화
		baos.close();//메모리 초기화
		//fileArray 값을 jsp로 보내주는 준비작업, final 이 메서드에서만 사용하겠다고 명시
		final HttpHeaders headers= new HttpHeaders();
		String ext = FilenameUtils.getExtension(save_file_name);
		//이미지 확장자에 따라서 매칭되는 헤더값이 변해야만 이미지 미리보기가 정상으로 보임.
		switch(ext.toLowerCase()) {//확장자가 뭐든 일단 소문자로 바꿔서 비교
		case "png":
			headers.setContentType(MediaType.IMAGE_PNG);
			break;
		case "jpg" :
			headers.setContentType(MediaType.IMAGE_JPEG);
			break;
		case "gif" :
			headers.setContentType(MediaType.IMAGE_GIF);
			break;
		case "jpeg":
			headers.setContentType(MediaType.IMAGE_JPEG);
			break;
		case "bmp":
			headers.setContentType(MediaType.parseMediaType("image/bmp"));
			break;			
			default:break;
		}
		return new ResponseEntity<byte[]>(fileArray,headers,HttpStatus.CREATED);//객체 생성시 초기값('rawData',header,HTTP상태값)
	}
	
	//XSS 크로스사이트 스크립트 방지용코드를 파싱하는 메서드 생성
	public String unScript(String data) {
//		if(data==null || data.trim().equals(""))
		if(data.isEmpty()) {
			return "";
		}
		String ret = data;
		ret = ret.replaceAll("<(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;script");
        ret = ret.replaceAll("</(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;/script");
        ret = ret.replaceAll("<(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;object");
        ret = ret.replaceAll("</(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;/object");
        ret = ret.replaceAll("<(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;applet");
        ret = ret.replaceAll("</(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;/applet");
        ret = ret.replaceAll("<(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
        ret = ret.replaceAll("</(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
        ret = ret.replaceAll("<(F|f)(O|o)(R|r)(M|m)", "&lt;form");
        ret = ret.replaceAll("</(F|f)(O|o)(R|r)(M|m)", "&lt;form");
		return ret;
	}
	
	//첨부파일이 이미지인지 아닌지 체크하는 데이터 생성
	private ArrayList<String> checkImgArray = new ArrayList<String> () {
		{
		add("gif");
		add("jpg");
		add("jpeg");
		add("png");
		add("bmp");
		}
	};
	public ArrayList<String> getCheckImgArray() {
		return checkImgArray;
	}
	
	//RestAPI서버 맛보기ID중복체크(제대로 만들면 @RestController 사용)
	@RequestMapping(value="/id_check", method=RequestMethod.GET)
	@ResponseBody //반환받은 값의 헤더값을 제외하고, 내용(body)만 반환하겠다는 명시
	public String id_check(@RequestParam("user_id")String user_id) throws Exception {
		//중복아이디를 체크로지(아래)
		String memberCnt = "1";//중복ID가 없을때, 기본값 0
		if(!user_id.isEmpty()) {//user_id가 공백이 아니라면,
		MemberVO memberVO = memberService.readMember(user_id);
		logger.info("디버그"+memberVO);
		if(memberVO == null) {// 중복아이디가 존재하지않으면 {} 실행
			memberCnt = "0";
		}
		}
		return memberCnt;//0.jsp 이렇게 작동하지 않습니다. 이유는 @ResponseBody때문이고, RestAPI는 값만 반환
	}
	//파일 업로드 공통 (Admin컨트롤러 + Home 컨트롤러에서 사용)메서드
	public String fileUpload(MultipartFile file) throws IOException {
		// TODO UUID클래스로 저장될 고유식별 파일명을 생성 후 물리적으로 저장
		String realFileName= file.getOriginalFilename();
		// 폴더에 저장할 PK 파일명을 생성
		UUID uid = UUID.randomUUID();//유니크 ID값 생성
		String saveFileName = uid.toString()+"."+ StringUtils.getFilenameExtension(realFileName);
		//file의 MultipartFile클래스 객체. 클래스형 자료는 직접 저장할 수 없음
		//그래서 바이트형으로 변환해서 저장해야함 - > bit형 자료로 파싱
		// 자바자료형 정수 : byte < short <int <long, 실수형 : float<double
		byte[] fileData = file.getBytes();
		File target = new File(uploadPath, saveFileName);
		FileCopyUtils.copy(fileData, target);//물리적으로 폴더에 저장됨
		return saveFileName;
	}
}