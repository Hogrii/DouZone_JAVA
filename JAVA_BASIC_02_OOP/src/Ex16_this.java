/*
원칙 : 객체를 생성할 때 생성자는 1개만 호출 가능하다(new Zcar() 또는 new Zcar(10))

this >> 객체 자신

Zcar(){} >> this(){}

*/

/*
class Zcar {
	String color;
	String gearType;
	int door;

	Zcar() { // 기본 설정
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}

	Zcar(String color, String gearType, int door) { // overloading constructor
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

	void zcarPrint() {
		System.out.println(this.color + ", " + this.gearType + ", " + this.door);
	}
}
*/

class Zcar {
	String color;
	String gearType;
	int door;

	Zcar() { // 기본 설정
		this("red","auto",2); // Zcar() 와 같다 >> 생성자를 다시 호출
							  // 파라미터 3개와 입력하는 생성자를 찾아서 세팅
		/*
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
		 */
	}

	Zcar(String color, String gearType, int door) { // overloading constructor
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

	void zcarPrint() {
		System.out.println(this.color + ", " + this.gearType + ", " + this.door);
	}
}

class Zcar2 {
	String color;
	String gearType;
	int door;

	Zcar2() { // 기본 옵션
		// 기본 옵션(red, auto, 2)
		this("red",2);
		System.out.println("default ....");
	}

	Zcar2(String color, int door) { // 기본 설정에 색상과 문의 개수를 변경 가능
		// 옵션 color, door 변경(default auto)
		this(color, "auto", door);
		System.out.println("overloading parameter 2개 call");
	}
	
	Zcar2(String color, String gearType, int door) { // 모든 옵션 변경 가능
		// 옵션 color, gearType, door 변경
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		System.out.println("overloading parameter 3개 call");
	}

	void zcarPrint() {
		System.out.println(this.color + ", " + this.gearType + ", " + this.door);
	}
}

public class Ex16_this {
	public static void main(String[] args) {
		Zcar zcar = new Zcar();
		zcar.zcarPrint();

		Zcar zcar2 = new Zcar("yellow","auto",10);
		zcar2.zcarPrint();

		Zcar2 car = new Zcar2(); // 기본 옵션		
		Zcar2 car2 = new Zcar2("gold",10); // 옵션 2개 선택		
		Zcar2 car3 = new Zcar2("gold", "auto", 10); // 옵션 모두 선택
	}
}
