/*
추상 클래스
>> 미완성 클래스(설계도)
1. 완성된 코드 + 미완성 코드
2. 미완성(함수) >> 실행블럭이 없는 함수 >> public void run();
3. 미완성된 클래스(스스로 객체 생성이 불가능)

설계도를 만드는 입장
 >> 미완성 설계도 제작(미완성 함수) >> 의도 >> 서로 믿지 못해서 >> 재정의에 대한 강제성 부여

상속을 기반으로 하기 때문에 상속이 없으면 사용할 수 없다
 */

class Car {
	void run() { // { 블럭만 있으면 객체를 생성하고 사용하는데 아무 문제가 없다 }
		// 설계자는 run()을 재정의 했으면 좋겠다는 의도를 가지고 있음.. >> 근데 강제성이 없다
	}
}

class Hcar extends Car {	
	// 믿음
	@Override
	void run() {
		System.out.println("재정의 했어요");
	}
}
// 재정의에 대한 강제성(의무)이 없다
// 그래서 설계도를 통해 반드시 재정의를 하게 만든다
abstract class Abclass { // 클래스 안에는 최소 1개 이상의 추상 함수를 가지고 있겠다
	int pos;
	void run() {
		pos++;
	}
	
	// 재정의가 필요한 함수를 추상 함수로 설계
	abstract void stop(); // 실행블럭이 없다 >> 사용할 때 반드시 상속을 통해서만 구현이 가능
						  // 상속을 통해 재정의를 구현해라!
}

class Child extends Abclass {
	// The type Child must implement the inherited abstract method Abclass.stop()
	// 추상메소드를 구현하라고 에러를 띄워준다
	
	@Override
	void stop() {
		// 구현하는 사람 마음대로..
		this.pos = 0;
		System.out.println("stop : " + this.pos);
	}
	
}

class Child2 extends Abclass {
	
	@Override
	void stop() {
		this.pos = -1;
		System.out.println("stop : " + this.pos);
	}
}

public class Ex01_abstract_class {
	public static void main(String[] args) {
		Hcar hc = new Hcar();
		hc.run();
		
//		Abclass ab = new Abclass(); Cannot instantiate the type Abclass : 미완성된 자원은 객체로 만들 수 없다
		
		Child child = new Child();
		child.run();
		child.stop();
		
		Child2 child2 = new Child2();
		child2.run();
		child2.stop();
		///////////////////////////////////////
		
		// 다형성
		Abclass ab = child;
		// 상속 관계에서 부모 타입의 참조 변수가 자식 타입 객체들의 주소값을 받을 수 있다
		// 단, 부모는 자신의 자원만 볼 수 있다.
		// 단, 재정의된 자원은 볼 수 있다
		ab.run();
		ab.stop(); // 부모의 것이라 볼 수 있지만 내용이 없기 때문에 자식 함수를 호출한다
	}
}
