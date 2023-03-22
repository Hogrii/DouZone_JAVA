import kr.or.kosa.AirPlane;

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
	/*
  	1. member field , instance variable
  	2. iv 언제 사용가능 할까요 (메모리에 언제 올라 갈까요) 
  	2.1 VariableClass v = new VariableClass(); >> heap 객체 생성 >> 객체 안에 iv 생성
        VariableClass v2 = new VariableClass();>> heap 객체 생성 >> 객체 안에 iv 생성
    3. 목적 : 데이터 (정보) ,자료 를 담을 목적
    3.1 정보 : 고유 , 상태 , 부품(class)
    -생성되는 객체마다 다른 값을 가질 수 있다
    -그래서 초기화를 해서 값을 강제하지 않는다 
    -default 값을 가지고 있다 (int > 0 , double > 0.0 , char > 빈문자'\u0000' , 
                         boolean >false , String > null, Car > null)
    -iv 변수의 생성 시점 : new 라는 연산자를 통해서 heap  Variable 이름의 객체가 만들어지고 나서 바로생성(그 안에)
      */
	static int cv; // static variable
	/*
	   1. class variable (클래스 변수) , 일반적으로는 static variable (객체간 공유자원)
	   2. 목적 : 정보를 담는 것 (생성되는 모든 객체가 공유하는 자원)
	      >> 생성되는 모든 객체 (heap영역에 생성된 객체들이 공유하는 자원)
	   3. 접근방법 
	      1. class 이름.static변수명 >> VariableClass.cv >> why(객체가 생성되기 전에 ...접근)
	      2. VariableClass v = new VariableClass(); >> v.cv  
	         VariableClass v2 = new VariableClass(); >> v2.cv
	         >> v.cv == v2.cv (같은 주소를 바라본다 : static 변수 주소)
	   4. 생성시점
	      Hello.java > javac Hello.java > Hello.class
	      >java.exe Hello 엔터 실행
	      >JVM > OS > Memory 빌려 > 정리(영역을 나누어요) > class Loader System 분석
	      >클래스 정보(metadata:설명) >> class area(method area) 메모리에 올려요 (
	                                                        언제 ,어떤 자원, 버전..)
	      >그 클래스안에 static variable 또는 static method 있다면 
	      >두 녀석을 class area(method area) 영역에 할당합니다 
	      >그런데 함수의 이름 만약에 main() 이라면 정해진 규칙에 따라서 실행합니다 (Stack 영역) 자원 할당 ..
	  */
	void method() {
		int lv = 0; // local variable
		
		// local variable (함수 안에 : 지역변수 : 사용 전 반드시 초기화)
		// 생명주기) 함수가 호출되면 생성되고 끝나면 소멸
		for(int i=0; i<100; i++) { // block variable
			
		}
	}
}

public class Ex05_Variable_Scope {
	public static void main(String[] args) {
		VariableClass.cv = 100; // 클래스이름.static자원
								// heap에 없기 때문에 클래스 이름에 접근해서 사용한다
		
		VariableClass vc = new VariableClass();
		// vc는 stack에 만들어지고 주소값이 heap에 만들어진다.
		// cv가 만들어질때는 class area에 생성된 cv의 주소값을 가져온다
		
		vc.iv = 100;
		vc.method();
		// stack에 메모리 할당 받아 수행 후 반납
		
		vc.cv = 200;
		// heap에 있는 cv를 찾아갔더니 class area의 주소값만 있다
		// 따라서 class area로 찾아가 바꾼다
		
		VariableClass vc2 = new VariableClass();
		System.out.println(vc.cv); // 200
		vc2.cv = 400;
		
		//////////////////////////////////////////////
		AirPlane airPlane = new AirPlane();
		airPlane.setAirPlaneNameAndNum("대한항공", 101);
		airPlane.getAirPlaneCnt();
		
		AirPlane airPlane2 = new AirPlane();
		airPlane2.setAirPlaneNameAndNum("진에어", 102);
		airPlane.getAirPlaneCnt();
		
		airPlane.getAirPlaneDisplay();		
		airPlane2.getAirPlaneDisplay();

	}
}
