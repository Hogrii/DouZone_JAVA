/*
static 초기화
 1. static variable : 공유자원(객체간 공유자원) : 객체마다 같은 값을 공유하겠다
 2. instance variable : 생성되는 객체마다 다른 값을 갖게 하겠다
  >> 두 자원은 default 값이 있다
  >> 초기화는 필요에 따라 할수도 있고 안할수도 있다.
*/

class Test2 {
	static int cv = 10; // 초기화
	static int cv2; // default 0
	int iv = 9;
	// 위 3개의 변수 값은 default가 있어서 초기화를 하지 않아도 사용하는데 문제 없다
	
	// 1. static 자원에 대한 초기화 블럭 >> static { } >> static 초기화 블럭
	static { // 생성자보다도 먼저 생성
		// 실행되는 시점 : static int cv = 10, static int cv2가 메모리에 올라간 직후 자동 실행 
		cv = 1111;
		// **조작된 표현이 가능 -> 제어문도 사용 가능
		cv2 = cv + 2222;
	}
	
	// 2. 일반 자원(member field) 초기화 블럭 >> { } >> member field 초기화 블럭
	// >> 생성자 함수와 기능이 동일
	{
		// int iv = 9; >> 메모리에 올라가려면 객체가 생성되어야 한다(new) >> Test2 t = new Test2();
		// { } 초기화 >> member field가 heap에 올라간 직후 실행
		// 조작된 값을 사용할 수 없음 >> 예) if(iv>10) iv = 100; 이런거 안됨
		// 그래서 블럭을 사용한다
		System.out.println("초기화 블럭 실행");
		if(iv<10) iv = 10000;
	}
	// 클래스 안에는 제어문을 사용할 수 없다
	// 제어문은 메소드 안에서만 선언이 가능
//	for(int i=0; i<10; i++) {}	
}

public class Ex07_Static_Init {
	public static void main(String[] args) {
		System.out.println(Test2.cv);
		System.out.println(Test2.cv2);
		Test2 t = new Test2();
		
		System.out.println(t.iv);
	}
}
