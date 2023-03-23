/*
OOP 객체 지향 프로그래밍(여러개의 작은 조각(작은 설계도)들을 만들어서 조합(큰 설계도)하는 행위)
 >> 설계도를 재사용

1. 상속(재사용성) >> 부모의 변화에 의한 자식의 변화가 심하기 때문에 점점 배제하는 분위기
2. 캡슐화(은닉화) >> private .. >> getter, setter(직접 할당을 막고 간접 할당을 통해 데이터를 보호하고 제어한다)
3. 다형성 >> 하나의 타입으로 여러 객체의 주소를 가질 수 있는 것

>> method overloading(오버로딩)
>> 하나의 이름으로 여러가지 기능을 하는 함수
>> System.out.println(); 이름은 1개, 기능은 여러개(함수 parameter 개수, 타입)
1. 오버로딩을 사용하면 성능 향상 (x)
2. 개발자가 편하게 사용하기 위함
3. 오버로딩을 사용하지 않아도 객체 지향에는 문제가 없다

문법)
1. 함수의 이름은 같고 파라미터의 [개수]와 [타입]을 달리하면 오버로딩 메소드라고 부른다
1.1 함수의 이름 동일
1.2 파라미터의 개수, 타입을 다르게 한다
1.3 return type은 오버로딩의 타입 기준이 아니다
1.4 파라미터의 순서가 다름을 인정한다 >> m(int i, String s), m(String s, int i) >> 둘은 다른 메소드

*/

class Human {
	String name;
	int age;
}

class OverT { // 설계도
	int add(int i) {
		return 100 + i;
	}
	
//	void add(int i) { } 파라미터가 같으면 충돌 >> 오버로딩이 안됨
	int add(int i, int j) { // 파라미터의 개수가 다르기 때문에 오버로딩 인정
		return i + j;
	}
	
	String add(String str) { // 파라미터의 데이터 타입이 다르기 떄문에 오버로딩 인정
		return str;
	}
	
	String add(String s, int i) {
		return "hello" + s;
	}
	
	String add(int i, String s) { // 파라미터의 순서가 달라도 오버로딩 인정
		return "hello" + s;
	}
	
	// Point
	void add(Human human) { // Human도 타입이기 때문에 오버로딩 인정
		human.age = 100;
		human.name = "홍길동";
	}
}

public class Ex11_Method_Overloading {
	public static void main(String[] args) {
		System.out.println();
		
		OverT overt = new OverT();
		overt.add(10, 10); // 파라미터에 대한 정의가 일치하는 메소드가 자동으로 호출
//		overt.add(10.1f, 10); // 파라미터에 실수를 받는 값이 없기 때문에 에러 발생
		overt.add("A");

		// 방법 1
		Human human = new Human();
		overt.add(human);

		// 방법 2. Point
		overt.add(new Human()); // 대신 재사용이 불가
	}
}
