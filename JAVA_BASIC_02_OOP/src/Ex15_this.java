/*
	this(이것)
	1. 객체 자신을 가리키는 this(앞으로 생성될 객체의 주소를 담을 곳이라고 가정)
	   >> 인스턴스 자신을 가리키는 참조 변수, 인스턴스의 주소가 저장되어 있다
	
	2. this는 객체 자신(주소) : 생성자 호출(원칙적으로 생성자는 객체 생성시 한 개만 호출 가능)
	   >> 그런데 this를 활용하면 예외적으로 this를 통해서 여러 개의 생성자를 호출 할 수 있다
*/

class Test5 { // 모든 클래스에는 extends Object가 숨겨져 있다
	int i;
	int j;
	Test5() { // default constructor
		
	}
	Test5(int i, int j) { // overloading constructor
		this.i = i; // this는 Test5를 가리키고 있다
		this.j = j;
//		i = i;
//		j = j;
	}
}

class Book2 {
	String bookName;
	
	/*
	Book2(String name) {
		bookName = name; // 코드를 이쁘게 >> 가독성
	}
	 */
	Book2(String bookName) {
		this.bookName = bookName; // 가독성이 좋은 코드
	}
}

// Today Point
// 생성자를 호출하는 this >> 중복 코드 감소
class Socar {
	String color;
	String gearType;
	int door;

	Socar() { // 기본 설정
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}

	Socar(String color, String gearType, int door) { // overloading constructor
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

	void socarPrint() {
		System.out.println(this.color + ", " + this.gearType + ", " + this.door);
	}
}

public class Ex15_this {
	public static void main(String[] args) {
		Test5 test5 = new Test5(10, 20);
		
		Socar socar = new Socar(); // 기본 차량
		socar.socarPrint();
		
		Socar socar2 = new Socar("gold","auto",6);
		socar2.socarPrint();
	}
}
