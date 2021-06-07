package com.edu.vo;

import java.sql.Date;

/**
 * 이 클래스는 dB에서 Model 클래스로 입출력, Model 에서 Service클래스로 입출력
 * Service에서 Controller클래스 데이터를 입출력,
 * Controller에서 jsp로 데이터를 주고 받을 때 사용하는 데이터 클래스
 * @author 김성중
 *
 */
public class MemberVO {
	//ERD에서 멤버변수를 만듭니다.
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private Integer point; // 정수형 int를 사용하지않고, integer를 사용한느 이유는 클래스 데이터는 Null을 허용하기에
	private Boolean enabled; //불린형
	private String levels;
	private Date reg_date;
	private Date update_date;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
}
