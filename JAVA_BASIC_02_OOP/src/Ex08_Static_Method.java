/*
static member field : 객체간 공유자원
static method >> public static void main

1. 객체 생성 없이 사용
2. 많이 사용 >> System.out.println(); // static
3. 설계도 : 자원을 많이 사용할 것 같다 >> new를 하고 참조 변수를 이용해서 하기 귀찮다
 >> 편하게 사용하고 싶다(new 없이 사용) >> static 설계
*/

class StaticClass{
	int iv;
	
	static int cv;
	
	static void print() {
		System.out.println("static print");
		// static 함수
		// 일반 자원 int iv;
		// 사용할 수 없음 >> static이 메모리에 올라갈 때 일반 함수는 메모리에 없기 때문
	}
	
	void printIv() {
		// 일반 함수
		// static int cv;
		// 사용할 수 있음 >> static 자원은 객체 생성 이전에 메모리에 존재하기 때문
		
		cv = 100;
	}
}
// 공존의 관계 : 생성 시점에 대한 해결 제시

public class Ex08_Static_Method {
	public static void main(String[] args) {
		// new를 하지 않아도 static으로 선언되었기 때문에
		// 클래스 이름으로 접근해서 함수를 사용할 수 있다.
		StaticClass.print();
		
		StaticClass sc = new StaticClass();
		sc.printIv();
		System.out.println(sc.cv);
	}
}
