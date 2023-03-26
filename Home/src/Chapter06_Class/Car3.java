package Chapter06_Class;

public class Car3 {
	// 필드 선언
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	// 생성자 선언
	// 1번 생성자
	Car3() {}
	
	// 2번 생성자
	Car3(String model) {
//		this.model = model;
		this(model, "은색", 250);
		// this는 자기 자신을 뜻한다.
		// 따라서 생성자를 재호출하게 된다.
	}
	
	// 3번 생성자
	Car3(String model, String color) {
//		this.model = model;
//		this.color = color;
		this(model, color, 250);
		// this는 자기 자신을 뜻한다.
		// 따라서 생성자를 재호출하게 된다.
	}

	// 4번 생성자
	Car3(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
