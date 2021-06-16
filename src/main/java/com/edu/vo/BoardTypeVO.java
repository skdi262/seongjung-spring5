package com.edu.vo;
/**
 * 이 클래스는 게시판 생성관리의 데이터를 입출력하는 클래스
 * 이 클래스를 이용해 AOP : Aspect Oriented programming(관점지향 프로그램)
 * @author 김성중
 *
 */
public class BoardTypeVO {
	private String board_type; //고유값, 식별자
	private String board_name;
	private Integer board_sun; //int > Integer null을 허용 nullpoint 예외처리방지
	//입출력가능한 메서드를 만듬
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public Integer getBoard_sun() {
		return board_sun;
	}
	public void setBoard_sun(Integer board_sun) {
		this.board_sun = board_sun;
	}
	
	
}
