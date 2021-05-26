package kr.or.test;
/**
 * 내부변수와 배열 사용에 대해서 실습
 * @author 김성중
 */

public class Step1 {
	// 멤버변수 ( 전역변수 )는 Step1클래스에 영향을 모두 주는 변수
	// 내부변수 ( 필드변수 )는 main메서드 내부에서만 영향을 주는 변수
	// private String name;// 멤버변수 사용예, Step2 클래스에서 사용 예정
	public static void main(String[] args) {
		// name, age, phoneNumber 필드 변수 사용
		String name; // 문자열 이름 입력받는 변수
		int age; // 정수형 나이 입력받는 변수
		String phoneNum; // 문자열 핸드폰 번호 받는 변수 
		name = "기르동";
		age = 10; // 자바스크립트보다는 자료형 사용에 엄격함
		phoneNum = "000-0000-0000"; // 1문자 끝을 명시
		printMember(name, age, phoneNum);//프린트 멤버라는 메서드를 호출
		name = "성중향";
		age = 18;
		phoneNum = "111-111-1111";
		printMember(name, age, phoneNum);
		name = "각씨탈";
		age = 29;
		phoneNum = "13123-1231231-1231";
		printMember(name, age, phoneNum);
		//배열을 이용해서 입력을 좀 더 편리하게 변경.
		String[] names = {"홍성중","성중향","성중탈"};
		int[] ages = {27, 18, 29};
		String[] phoneNums = {"000-0000-0000","111-1111-1111","123-1234-1234"};
		printMember(names, ages, phoneNums);//메서드 로드된 파라미터가 다르면 오류나용, Overload
	}// 메서드명이 같다. 단 로드된 파라미터 타입, 개수다른 메서드를 호출하면 오버로드

	private static void printMember(String[] names, int[] ages, String[] phoneNums) {
		// for 반복문으로 3개를 한 번에 출력
		int dataLength = names.length;
		for(int i=0; i<dataLength; i++) {
			System.out.println("입력하신 회원의 이름은 " + names[i] +"이고, 나이는 " + ages[i]+ "살이고, 폰 번호는 " + phoneNums[i] +"입니다." );
		}
		
	}

	private static void printMember(String name, int age, String phoneNum) {
		// printMeber (파라미터 1, param1)
		System.out.println("입력하신 회원의 이름은 " + name +"이고, 나이는 " + age + "살이고, 폰 번호는 " + phoneNum +"입니다." );
		//println 이라는 메서드는 출력 후 줄바꿈 명령
//		System.out.print("")
	}

}
