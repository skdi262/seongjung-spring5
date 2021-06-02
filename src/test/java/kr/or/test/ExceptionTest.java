package kr.or.test;
/**
 * 이 클래스는 자바앱에서 개발자가 예외를 처리하는 방법을 실습하는 Class 입니다 .
 * @author KING성중
 *
 */
public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 외부 CLASS 형 변수에 값을 저장해서 출력하는 프로그램
		MemberVO memberVO = new MemberVO();
		// 동일 패키지 안의 CLASS는 IMPORT 없이 사용가능하다 .
		memberVO.setName("김성중");
		memberVO.setAge(27);
		memberVO.setPhoneNum("010-4516-9279");
		System.out.println("한번에 출력하고 싶을 때 toString()메서드를 만듭니다.");
		System.out.println(memberVO.toString());
		//배열 변수 선언
		String[] stringArray = {"10","2a","100"};
		int indexValue = 0;
		for(int cnt=0;cnt <=3;cnt++) {
			// 개발자가 예외처리하는 기본형식 try {구현 프로그램에서 에러가 발생하면 - 필수} catch() {에러발생 시 구현 내용 - 필수} finally {무조건 실행되는 내용- 선택사항}
			try {
			indexValue = Integer.parseInt(stringArray[cnt]);
			} catch(NumberFormatException ex) {//Exception 대신에 선별적으로 catch 해보기
				System.out.println(cnt + 1 + "숫자형태가 올바르지않습니다. 확인해주세요.");
				System.out.println("에러내용은" + ex.toString());
			} catch(ArrayIndexOutOfBoundsException ex){
				System.out.println(ex.toString());
				System.out.println("배열이 많아여");
			} finally {
				System.out.println(cnt+1 + "프로그램이  종료되었습니다.");
			}
			}
		System.out.println("프로그램이 정상 종료되었습니다.");
	}

}
