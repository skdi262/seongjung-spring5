package kr.or.test;
/**
 * 이 클래스는 메서드기반의 Step1클래스를 객체기반의 클래스로 변경한 클래스.
 * @author 진미래
 *
 */
class MemberVO {
	//이 클래스는 회원정보를 저장하는 자료형 클래스(자료) 입니다.
	private String name;
	private int age;
	private String phoneNum;
	//위 프라이빗 멤버변수를 입출력 구현 메서드를 만듭니다.
	//to String생성
	@Override
	public String toString() {
		return "MemberVO 변수값출력 [name=" + name + ", age=" + age + ", phoneNum=" + phoneNum + "]";
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// String을 반환(return)=출력하는 겟 메서드 입니다.(아래)
	public String getPhoneNum() {
		return phoneNum;
	}
	// void한(반환값이 없이) 입력하는 셋 메서드 입니다.(아래)
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;//프라이빗 변수를 직접접근을 못하니까
		//퍼블릿 메서드로 입력하게 만들어 놓은 구조입니다. 
	}
	
}
public class Step2 {

	public static void main(String[] args) {
		// MemberVO클래스자료형 객체를 생성합니다(아래)
		MemberVO memberVO = new MemberVO();
		memberVO.setName("홍길동");
		memberVO.setAge(10);
		memberVO.setPhoneNum("000-0000-0000");
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setName("성춘향");
		memberVO2.setAge(18);
		memberVO2.setPhoneNum("111-1111-1111");
		MemberVO memberVO3 = new MemberVO();
		memberVO3.setName("각시탈");
		memberVO3.setAge(28);
		memberVO3.setPhoneNum("222-2222-2222");
		//MemberVO클래스를 배열 객체로(String[]처럼) 생성했습니다.(아래)
		MemberVO[] members = new MemberVO[3];
		members[0] = memberVO;
		members[1] = memberVO2;
		members[2] = memberVO3;
		//출력도 메서드를 바로 호출하지 않고, 외부 클래스에서 객체로 만들어서 메서드를 호출합니다.
		MemberService memberService = new MemberService();
		memberService.printMember(members);
		//객체로 만들면, 호출(runtime)시 메모리에 로딩됩니다. -> 실행끝나면, 반환.
		//클래스는 아래처럼 직접 접근해서 메서드나 변수를 사용할 수 없음,
		// 외부클래스로 접근하려면, 객체(실행가능한=메모리로딩)
		//Static 예약어는 컴파일시 메모리에 로딩(객체가됨)이 되게 명시
		//매번 static으로 만들면 메모리 가득차서 프로실행이 느려지거나 멈춤.
		//MemberService.printMember(members);
	}
}
class MemberService {

	public void printMember(MemberVO[] members) {
		// 멤버서비스클래스에서 퍼블릿 접근제어로 회원정보를 출력하는 메서드 생성
		// 향상된 for문을 사용합니다.
		for(MemberVO member:members) {
			System.out.println(" 회원의 이름은"+member.getName()
			+" 나이는"+member.getAge()
			+" 폰번호는"+member.getPhoneNum());
		}
	}
	//회원을 출력하는 메서드를 생성 합니다.

}
