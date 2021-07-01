package kr.or.test;

import java.util.List;
import java.util.function.IntSupplier;

import com.edu.service.IF_MemberService;
import com.edu.vo.MemberVO;
import com.edu.vo.PageVO;

/**
 * 람다 테스트 클래스
 * @author 김성중
 *
 */

public class Lamda {
	
	//스태틱 메서드 쓰는 이유 클래스를 컴파일하면 메모리에 등록되는 메서드를 뜻함
	//스태틱을 지정하지 않으면 런타임시 메모리에 등록됨
	// 스태틱 메서드 : 이클래스에서만 메서드로 사용하겠다고 명시
	public static int plus(int x,int y,String lambda) {
		int result=0;
		if(lambda.equals("nonLambda")) {
		IntSupplier intSupplier = new IntSupplier() {
			@Override
			public int getAsInt() {
				int sum = x+y;
				return sum;
			}
		};
		result = intSupplier.getAsInt();
		
		}if (lambda.equals("lambda")) {
		IntSupplier intSupplier = () -> {
			int sum = x+y;
			return sum;
		};
		result = intSupplier.getAsInt();
		}
		return result;
	}
	public String memeberOne() {
		String result = "";
		IF_MemberService memberService = new IF_MemberService() {

			@Override
			public List<MemberVO> selectMember(PageVO pageVO) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int countMember(PageVO pageVO) throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void insertMember(MemberVO memberVO) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deleteMember(String user_id) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public MemberVO readMember(String user_id) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void updateMember(MemberVO memberOne) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			
		}
		result = memberVO.getName();
		return result;
	}
	public static void main(String[] args) {
		// plus 메서드를 호출
		System.out.println("람다식 적용전 메서드 결과: " + plus(3,4,"nonLambda"));
		System.out.println("람다식 적용후 메서드 결과: " + plus(3,4,"lambda"));

	}

}
