/*
클래스 == 설계도 == 데이터 타입

TIP) 하나의 물리적인 java 파일에 여러개의 클래스 생성 가능
원칙적 방법 : 패키지 > kr.or.kosa.utils.Apt, kr.or.kosa.model.Apt
 */

class Apt { // 설계도 == 데이터 타입(사용자(개발자) 정의 타입)(작은 타입을 여러개 가지고 있는 큰타입)
			// 설계도는 구체화 되지 않으면 종이 한 장 >> 의미 없다는 뜻
			// 목적 -> Apt 설계도를 가지고 같은 아파트를 메모리에 무한하게 생성하겠다. >> new 연산자
			// 생성된 설계도는 필요시 재사용이 가능하다
	String doorColor;
}

public class Ex04_Object_Variable {
	public static void main(String[] args) {
		Apt apt; // apt 변수는 Apt 객체의 주소를 담을 수 있는 변수, apt는 Stack에 생성
		apt = new Apt(); // Heap 메모리에 Apt가 한 채 생성 >> 생성된 Apt의 주소가 apt(Stack)에 할당
		// apt가 가지고 있는 것은? >> 참조값(주소값)
		System.out.println("apt 주소 : " + apt); // Apt@75a1cd57
		// Apt@75a1cd57 >> Apt(클래스명) + @(문자) + 주소값(16진수)
		
		Apt apt2 = new Apt();
		System.out.println(apt == apt2); // false
		System.out.println(apt + " : " + apt2); // Apt@75a1cd57 : Apt@515f550a
		
		Apt apt3 = apt2; // 주소값 할당
		System.out.println(apt2 == apt3); // true
		System.out.println(apt2 + " : " + apt3); // Apt@515f550a : Apt@515f550a
		// apt2와 apt3은 같은 주소를 갖게 됨(동거)
		
		apt2.doorColor = "red";
		System.out.println(apt3.doorColor); // red
		apt3.doorColor = "blue";
		System.out.println(apt2.doorColor); // blue
		
		// 동작 원리
		/*
		   Ex04_Object_Variable.java >> javac.exe >> Ex04_Object_Variable.class(실행파일)
		   > java Ex04_Object_Variable 엔터
		   > JVM 동작 >> OS에 메모리를 빌려온다 >> 메모리를 용도에 맞게 정리 >> 각각의 땅에 메모리(자원) 할당 >> 프로그램 종료
		   > 종료시 사용했던 메모리를 OS에 반환 
		   
		   이클립스 >> ctrl + F11
		   1. main 함수 실행 >> 반드시 local variable 초기화
		   2. main 시작점
		 */
	}
}
