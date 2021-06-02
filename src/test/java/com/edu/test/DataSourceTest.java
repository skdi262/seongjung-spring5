package com.edu.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 이 클래스는 오라클과 연동해서 CRUD를 테스트하는 클래스입니다.
 * 과장급이 먼저 JUNIT CRUD 까지 만들고 일반사원에게 공개 + 회원관리
 * @author 김성중
 *
 */
//RunWith라는 인터페이스는 J 유닛을 실행하는 클래스라는 것을 명시해줌 .
//경로에서 **는 모든 폴더를 명시, *는 모든 파일을 명시
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class DataSourceTest {
	//디버그용 로그 변수 설정
	private Logger logger = Logger.getLogger(DataSourceTest.class);
	@Test
	public void JUnitTest() {
		//로거의 장점) 조건에 따라서 출력을 조정할 수 있다 .
		logger.debug("JUnit테스트 시작입니다.");
	}
}
