/**
 * 
 * 익명 클래스
 * 클래스를 정의하지 않고 객체를 만드는 방법 > 1회용 클래스 > 재사용 불가능한 클래스
 * 
 * 이벤트 처리, 스레드 객체(runnable), 람다식, 스트림 사용
 */

/**
 * 
 * inner Class
 * 클래스 안에 클래스가 있다
 * >> 코드를 간소화 할 수 있다
 * ex) awt, swing, 안드로이드 앱
 */

class OuterClass {
	public int pdata = 10;
	private int data = 30;
	
	class InnerClass {
		void msg() {
			// InnerClass는 OuterClass의 자원을 사용할 수 있다
			System.out.println("outerClass data : " + data);
			System.out.println("outerClass pdata : " + pdata);
		}
	}
}
/////////////////////////////////////////////////////////////////////
abstract class Person {
	abstract void eat();
}

class Man extends Person {
	@Override
	void eat() {
		System.out.println("Person의 eat함수 재정의");
	}	
}

interface Eatable {
	void eat();
}

class Test {
	void method(Eatable e) {
		e.eat();
	}
}

public class Ex13_innerClass_AnonymousClass {
	public static void main(String[] args) {
		OuterClass outobj = new OuterClass();
		System.out.println("public field : " + outobj.pdata);
		
		OuterClass.InnerClass innerobj = outobj.new InnerClass();
		innerobj.msg(); // outer 클래스에 대한 자원 접근 용이
		
		////////////////////////////////////////////////////////////
		Man m = new Man();
		m.eat();
		Person p = m;
		p.eat();
		
		Person p2 = new Man();
		p2.eat();
		////////////////////////////////////////////////////////////
		
		// abstract class Person 강제 구현 ..
		// 추상 클래스는 객체 생성 불가능(미완성)
		// 추상클래스를 상속하는 클래스를 만들고 사용 ..
		// 생각) 한번만 사용, 재사용하지 않을건데
		// ex) class Man extends Person
		
		// Person을 상속하는 클래스 없이(이름 없이) 1회성으로 사용 가능하게 하고 싶다
		// >> 익명클래스를 만들자
		
		Person person = new Person() {
			// 생성자 뒤에 바로 실행코드가 붙는다
			// class Man extends.. Man이라는 이름이 없다
			@Override
			void eat() {
				System.out.println("익명 객체 타입으로 구현");
			}
		};
		person.eat();
		///////////////////////////////////////////////////////////
		// Today Point
		Test t = new Test();
		
		t.method(new Eatable() {			
			@Override
			public void eat() {
				System.out.println("일회성 자원으로 인터페이스를 직접 구현");
			}
		});
		// Eatable 인터페이스를 구현하고 있는 객체의 주소
		// class ManEat implements Eatable {}
	}
}
