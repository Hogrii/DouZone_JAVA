/*
OOP 특징(여러개의 조각(작은)(클래스)들을 조합해서 하나의 큰 그림(제품)을 만드는 행위
설계도 : 메인 설계도의 부분 설계도, 메인 설게도의 하위 설계도, 별도 독립 설계도 ..

1. 상속
2. 캡슐화(은닉화) >> private
3. 다형성(상속관계에서 부모타입이 자식타입의 주소를 가질 수 있다)

상속
JAVA : child extends Base
C#   : child : Base

특징
1. 다중 상속 불가(단일 상속 원칙 >> 계층적 상속을 통해서 받을 수는 있다)
2. 계층적 상속(여러개의 클래스를 상속)
3. 다중 상속 지원은 Interface(표준, 약속, 규칙, 규약을 정의하고 있는 클래스)만 가능

상속
1. 진정한 의미 : 재사용성
2. 단점 : 비용(초기 설계 비용), 종속성 >> 부모와 자식간의 관계가 너무 끈끈함 >> 최근에는 느슨환 관계를 좋아함
3. 재사용성 >> 설계에 시간이 많이 걸리지만 >> 길게 보면 이득을 보긴함

모든 클래스는 메모리에 올라가야 사용가능하다
메모리에 올라가는 순서 : Object >> GrandFather >> Father >> Child

사용자가 만드는 모든 클래스는 default를 명시하지 않아도 Object를 상속한다
class Car (extends Object) { }
Object >> Root >> 최상위 >> 모든 클래스의 부모 클래스 
 */

class GrandFather { // class GrandFather extends Object
	public int gmoney = 5000;
	private int pmoney = 10000; // 상속관계라고 하더라도 접근 불가 >> 무덤까지 가져간다는 뜻
								// public 함수를 생성해 간접적으로 접근하면 된다
	// 객체 생성과 동시에 호출되는 함수(생성자)
	public GrandFather() {
		System.out.println("할아버지 생성자");
	}
}

class Father extends GrandFather {
	public int fmoney = 3000;
	public Father() {
		System.out.println("아버지 생성자");
	}
}

class Child extends Father {
	public int cmoney = 100;
	
	public Child() {
		System.out.println("아이 생성자");
	}
}

public class Ex01_inherit {
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.gmoney);
		System.out.println(child.fmoney);
		System.out.println(child.cmoney);
		
//		child.pmoney; // The field GrandFather.pmoney is not visible
	}
}
