package com.edu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

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
	//dataSource 객체는 데이터베이스 객체를 pool로 저장해서 사용할때 DataSource 클래스를 사용
	@Inject //인젝트는 스프링에서 객체를 만드는 방법
	DataSource dataSource; //Inject로 객체를 만들면 메모리 관리를 스프링이 대신해줌.
	@Test 
	public void oldQueryTest() throws Exception{
		//스프링빈을 사용하지 않을때 예전 방식 : 코테는 스프링설정을 안 쓰고 , 직접 DB의 ID/암호를 입력
		Connection connection =null;
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","XE","apmsetup");
		logger.debug("데이터베이스 직접 접속이 성공했습니다. DB종류는 " + connection.getMetaData().getDatabaseProductName());
		connection=null;//메모리 초기화
	}
	@Test
	public void dbConnectionTest() throws Exception{
		//데이터 베이스 커넥션 테스트 : 설정은 root-context의 빈(스프링클래스)를 이용
		try {
			Connection connection = dataSource.getConnection();
			logger.debug("데이터베이스 접속이 성공했습니다. DB종류는 " + connection.getMetaData().getDatabaseProductName());
		} catch(SQLException e) {
			logger.debug("데이터 베이스 접속이 실패 했습니다.");
			//e.printStackTrace();
		}
		
	}
	@Test
	public void JUnitTest() {
		//로거의 장점) 조건에 따라서 출력을 조정할 수 있다 .
		
	}
}
