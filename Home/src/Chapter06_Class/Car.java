package Chapter06_Class;

public class Car {
	// 고유 데이터
	// 동작할 때 변하지 않는 값
	String company = "현대자동차";
	String model;	// null(기본값)
	String color = "검정";
	int maxSpeed = 350;
	
	// 상태 데이터
	// 동작할 때 변할 수 있는 값
	int speed;		// 0(기본값)
	int rpm;
	boolean start;	// false(기본값)
	
	// 부품 데이터
	// 하위 개념으로 더 쪼갤 수 있는 값
	// 차체는 문, 보닛 등으로 나눌 수 있다.
	Body body;
	// 엔진은 실린더, 피스톤 등으로 나눌 수 있다.
	Engine engine;
	// 타이어는 벨트, 트레드 등으로 나눌 수 있다.
	Tire tire;		// null(기본값)
}