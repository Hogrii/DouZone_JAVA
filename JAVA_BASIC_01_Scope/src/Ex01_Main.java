import kr.or.kosa.common.Car;

/*
클래스 == 설계도 == 타입(사용자 정의)

클래스의 구성 요소(설계도라고 판단 하려면 최소한 무엇을 가지고 있어야 한다)
 -> [필드 + 메서드] + 생성자
 -> (속성 + 함수(기능))
 
필드(member field) >> 데이터, 자료 정보를 담고 있다
 -> 고유 정보 : 변하지 않는 정보(색상, 차 일련번호)
 -> 상태 정보 : 변할 수 있는 정보(속도)
 -> 부품 정보 : 메소드로 쪼갤 수 있는 정보(엔진 -> 연료 등등)
함수(method) >> 기능(행위)
 -> 자동차 : 달린다, 멈춘다, 소리가 난다, 문을 연다
+ 생성자(함수) >> 특수한 목적의 함수
 -> 객체가 생성되면 member field를 초기화하는 목적으로 생성
 -> getter, setter를 통해 읽고(read), 쓰기(write) 위한 함수

Class 설계도 {
	고유 정보
	상태 정보
	부품 정보
	
	기능(행위) 정보 
}

클래스, 필드, 생성자 함수, 메서드 : 영역(범위) >> 생성되는 장소(위치) 또는 접근자(한정자, 수정자)

장소(위치) : 폴더(package) 기반 >> 클래스 내부, 함수 내부, 제어문 내부
접근자 : public, private, default, protected

kr.or.kosa.common 안에 생성한 Car 클래스는 >> public class Car() >> 나 다 오픈할거야
kr.or.kosa.common 안에 생성한 AirPlane 클래스는 >> class AirPlane{} >> 같ㅇ른 폴더 안에서만 사용

>> default는 같은 폴더(패키지)에서만 공유
>> 연습용으로 .. 또는 특정클래스에 도움을 줄 때 사용

연습용으로 빠르게 작업하려면 어떤 것이 편할까?
하나의 물리적 Java파일(Ex01_Main.java)은 여러개의 클래스를 가질 수 있다.
 -> Ex01_Main.java 파일은 그 안에 public class Ex01_Main 클래스를 가지고 있다.
 1. 개발에서 필요한 크래스는 package를 생성하고 그 안에 만들어서 사용합니다. >> Car 클래스처럼
 2. 그냥 연습하는건데 굳이 폴더, 물리적 파일 여러개를 생성할 필요가 있을까?
 3. 하나의 물리적 파일에 어러 개의 클래스를 만들어 쓸 수 있게 해줄게 >> 단, 연습할때만
 3.1 대신에 public 접근자는 하나만 가져야 한다.
 */

class Emp{ // 연습, 공부할때만 사용
	
}

class Dept{ // 컴파일러가 default class Dept로 해석
	int deptNo;	// 컴파일러가 default int deptNo로 해석
	public String dname; // 에러는 아니지만 다른 폴더에서는 사용이 불가하다. 의미 없음
	private int count; // private >> 캡슐화(은닉)
					   // 같은 폴더 같은 클래스 내에 있어도 감춰져버림
					   // 설계자의 의도 >> 클래스내부에서만 사용하는 변수, 직접 할당을 막고 간접 할당을 통해 제어
	// private을 사용하려면 특수한 함수가 필요 >> getter(읽기), setter(쓰기)
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) { // 간접 할당
		if(count < 0) {
			this.count = 0;
		}else {
			this.count = count;
		}		
	}
}

/*
class Apt{ // 같은 폴더 내에 같은 이름의 클래스가 있기 때문에 오류가 발생
	
}
 */

// 연습용 클래스
class Test{ // default
	int data; // default, 클래스가 가지는 변수(member field) >> instance variable
	// Test test = new Test(); 했을 때 생성된다.
	void print() { // default
		int num = 0; // local variable
		// print가 호출되었을 때 생성된다.
		for(int i=0; i<=100; i++) {
			// i는 for문이 시작될 때 생성된다.			
		}
		for(int i=0; i<=100; i++) {
			
		}
		int k = 0;
		for(k=0; k<=100; k++) {
			
		}
		System.out.println(k); // 101
	}
}

/*
// 실전용 클래스
폴더
kr.or.kosa.dto.Test

public class Test {
	private int i;
	
	public void setI(int i) { this.i = i; }
	public int getI() { return this.i; }
	public void print() {}
}
 */

public class Ex01_Main {
	public static void main(String[] args) {
		// 같은 폴더 안에 있는 클래스
		// new : Apt를 짓는 방법
		Apt apt = new Apt();
		Car car = new Car(); // 클래스 설계시 public Car{ }로 만들었기 때문에 사용 가능, 폴더에 구분없이 어디서나 사용 가능하다
//		kr.or.kosa.common.Car car = new kr.or.kosa.common.Car(); // 원래 이렇게 사용해야 하는데 중복 제거를 위해 import를 사용한다.
		
		Dept dept = new Dept();
//		dept.count >> 캡슐화
		dept.deptNo = 100; // 삼각형 : dafault, 녹색 동그라미 : public
		System.out.println(dept.deptNo);
		
		dept.dname = "IT";
		System.out.println(dept.dname);
		
		dept.setCount(-100);
		System.out.println(dept.getCount());
		
		Test test = new Test();
		test.print(); // 호출
	}
}
