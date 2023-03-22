
/*
instance variable >> class Car { private String color; }
 >> 생성되는 객체마다 다른 값을 가질 수 있다
 >> 만약 초기값을 설정한다면 -> 기본적으로 어떤 값을 초기화하겠다 (private String color = "black")

local variable >> class Car { public void move(){ int speed = 100; } }
 >> 값을 사용하기 전에 반드시 초기화
 >> public static void main(String[] args) { 지역 변수(초기화!!) }
 
block variable >> class Car { public void move() { for(int i=0; ..)}}
 >> for문이 시작될 때 생성되었다가 for문이 끝날 때 사라진다

Today Point
static variable >> 공유자원(heap에 생성된 객체간 공유자원)
1. 객체 생성 이전에 메모리에 올라가느 자원(heap, stack, class area)
2. 설계도를 가지고 구체화(메모리) 올리는 방법 유일 : new
3. static 자원은 new없이도 메모리에 올라간다(class(method) area)

Ex05_Variable_Scope 클래스 >> new >> 메모리 >> 이 중에 필요한 자원 사용가능

javac 컴파일
java Ex05_Variable_Scope 엔터
1. Ex05_Variable_Scope 분석(누가, 어떤 자원, 언제 ...) 정보 메모리들을 올린다.
 >> class(method) area에 올린다
2. 안에 static 이런 것이 붙어 있는 member field, method가 보이면 메모리에 올린다.
3. 그런데 static 함수 중에 이름이 main이면 실행하기로 약속 >> main : 진입점, 실행점
 */

class VariableClass{ // default
	int iv;	// instance variable
	static int cv; // static variable
	
	void method() {
		int lv = 0; // local variable
		for(int i=0; i<100; i++) { // block variable
			
		}
	}
}

public class Ex05_Variable_Scope {
	public static void main(String[] args) {
		VariableClass.cv = 100; // 클래스이름.static자원
		VariableClass vc = new VariableClass();
		vc.iv = 100;
		vc.method();
		vc.cv = 200;
	}
}
