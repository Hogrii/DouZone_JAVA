/*
생성자 함수(constructor)
1. 특수한 목적의 함수
2. 목적(member field 초기화) >> static { }(static 초기화), { }(일반 초기화)
3. 일반 함수와 다른점
3.1 함수 이름이 고정(class 이름 동일)
3.2 return type이 없다(객체 생성과 동시에 호출)(return을 받을 대상이 없다)
3.3 실행 시점 >> new를 통해 객체를 생성 >> heap에 객체가 생성 >> member field 자리 >> 자동으로 생성자 호출
3.4 return type(x) >> void >> public (void) 클래스명(){}
4. 왜 만들까? : [생성되는 객체]마다 [강제적]으로 member field를 초기화하고 싶다.

class Car { String color; }
>> 설계도를 만든이는 "자동차의 색상 정도는 니가 알아서 해"
>> 근데 안할수도..

class Car { String color = "blue"; }
>> 객체를 생성하면 무조건 자동차의 색상은 "blue"가 된다

문제) 자동차의 색상을 정하지 않고 출고
설계도를 사용하는 사람이 자동차를 만들 때 색상을 넣지 않으면 출고 안되게 하고 싶음
>> 생성자를 이용해 설계하면 입력이 안되었을 때 객체가 안만들어진다

5. 생성자 함수는 1개만 만들까? -> No
Today Point
6. 생성자 함수는 overloading 가능(강제 구현) **
**** 생성자 함수를 쓰는 가장 중요한 목적은 member field의 [강제 초기화]이다
 */

class Car {
	String carname = "포니";
	
	// 생성자(default constructor) >> 기본 생성자
	public Car() {
		// 클래스가 메모리에 올라가고
		// 멤버필드가 메모리에 올라간 뒤
		// 호출
		System.out.println("기본 생성자입니다");
		carname = "내마음";
	}
}

class School {
	String schoolName = "강남";
	
	// public School() { }
	// 만약 School 객체를 생성할 때 생성자 함수가 없다면
	// 컴파일러가 자동으로 기본 생성자(default constructor)를 만들어서 실행한다
}

/////////////////////////////////////////////////////////////////////
class Car2 {
	String carname;
	// 기본 생성자가 생략되어 있다
	// public Car2() {}
}

class Car3 {
	String carname; // null
	public Car3() { // default constructor (method)
		carname = "포니";
	}
}

// Car4는 자동차를 만드는데 있어서 2가지 선택을 부여했다
class Car4 {
	String carname;
	public Car4() { // default constructor
		carname = "기본이름";
	}
	// overloading(함수) >> 생성자 함수(특수 목적) >> 생성자도 Overloading이 가능하다
	public Car4(String name) {
		carname = name;
	}
}

// 설계 의도 >> 사용자에게 차 이름을 반드시 입력하게 강제성을 부여
class Car5 {
	String carname;
	public Car5(String name) {
		carname = name;
	}
}

// 실생활 -> 떡볶이 주문, 자동차 구매, 커피샵 등등..
class Car6 {
	String carcolor;
	int door;
	public Car6(int num) {
		carcolor = "blue";
		door = num;
	}
	public Car6(String color) {
		carcolor = color;
		door = 4;
	}
	public Car6(int num, String color) {
		carcolor = color;
		door = num;
	}
}
/////////////////////////////////////////////////////////////////////

public class Ex13_Constructor {
	public static void main(String[] args) {
		Car car = new Car(); // 마지막 ()는 생성자의 파라미터
		System.out.println(car.carname);
		School school = new School(); // 기본 생성자를 호출하고 있음, new -> 생성자 함수
		
		Car4 car4 = new Car4();
		Car4 car41 = new Car4("홍길동카");
		
	}
}
