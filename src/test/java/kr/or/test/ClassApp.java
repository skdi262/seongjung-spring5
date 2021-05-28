package kr.or.test;

/**
 * 이 클래스는 1. 클래스 상속(extends)에 연습, 2. 오브젝트(객체)생성에 필요한 new 키워드(예약어) 생성자메서드 사용 연습,
 * 3. 추상클래스(Abstract) 대한 연습
 * 
 * @author User
 *
 */
//오브젝트생성에 필요한 new 키워드 생성자메서드 사용한 실습 클래스(아래)
class Circle {
	private int r;// 원의 반지름으로 사용할 변수
	// 생성자 메서드(아래)
	// public Circle() { } 만들지 않아도 자동으로 만들어 집니다.

	public Circle(int radius) {
		r = radius;// Get|Set중에 셋 저장 멤버변수 처리
	}

	// 원의 넓이를 구하는 메서드 반환(리턴)값의 크기가 더블형(아래)
	public double getCircle() {
		double result = r * r * 3.14;// 원의 넓이를 구하는 계산식
		return result;
	}
}

//클래스 상속에 대한 연습(아래)
class Employee { // 고용(사원,취업) 부모 클래스
	int mSalary;// m멤버변수 월급에 대한 변수
	String mDept;// 사원 부서 변수

	public void doJop() {
		System.out.println("환영합니다. 직원 여러분");
	}
}

class Salesman extends Employee {// extends 확장 -> 상속
	public Salesman() {// 클래스 명과 똑같은 이름의 메서드가 생성자 함수이다.
		// 자동으로 생성이 되나, 커스터마이징 하기위해 만들어줌
		mDept = "판매부서"; // 부모 클래스에 있는 변수를 상속받아 사용가능
		mSalary = 300;
	}

	public void doJop() {
		System.out.println("환영합니다." + mDept + "여러분.");
	}
}

class Development extends Employee {
	public Development() {
		mDept = "개발 부서";
	}

	public void doJob() {
		System.out.println("환영합니다" + mDept + "여러분");
	}
}

// 추상 클래스에 대한 것
abstract class GraphicObject {
	int x, y;

	abstract void draw();// 구현 내용이 없고 이름만 있음
	// 추상 메서드를 만드는 이유는 메서드가 많은 데 설명해야할 때 구현의 어려움이 존재
//	위 문제를 해소한 기능이 클래스 수백개의 메서드를 이름만 모아서 관리가 편하게 하기위해.
}

// 스프링에서는 추상클래스 보단느 인터페이스를 더 많이 사용함.
class Triangle extends GraphicObject {

	@Override // 부모 클래스의 메서드를 *재정의 한다. = 오버라이드 
//	오버로드는  한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메소드가 있더라도 매개변수의 개수 또는 타입이 다르면, 같은 이름을 사용해서 메소드를 정의할 수 있다.
	void draw() {
		// 삼각형 만들기
		System.out.println("  *  ");
		System.out.println(" * * ");
		System.out.println("*****");
	}
}
class Rectangle extends GraphicObject {

	@Override // 오버라이드에 @에노테이션 있으면, 상속이라는 말
	void draw() {
		// 사각형 그리기
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		
	}
}

public class ClassApp {

	public static void main(String[] args) {
		// 추상 클래스를 사용해 오버라이드 메서드 사용
		GraphicObject triangleObject = new Triangle();
		GraphicObject rectangleObject = new Rectangle();
		triangleObject.draw();
		rectangleObject.draw();
		
		// 개발자가 입력한 반지름의 원의 넓이를 구하는 오브젝트를 생성(아래)
		Circle circle = new Circle(5);// 반지름이 5인 원의 넓이를 구한는 객체생성
		System.out.println("원의 넓이는 " + circle.getCircle());
		circle = null;// 오브젝트(메모리) 반환
		Employee employee = new Employee();
		Salesman salesman = new Salesman();
		Development development = new Development();
		employee.doJop();
		salesman.doJop();
		development.doJob();
	}

}