package Chapter06_Class;

public class Car2 {
	// 필드 선언
	
	String model = "그랜저";	// 고유 데이터 필드
	int speed = 300;		// 상태 데이터 필드
	boolean start = true;	// 상태 데이터 필드
	Tire tire = new Tire();	// 부품 데이터 필드
	
	// 필드 변수와 로컬 변수의 차이
	
	//				필드			  	     로컬
	// 선언 위치 :	클래스 선언 블록		생성자, 메소드 선언 블록
	// 존재 위치 :	객체 내부에 존재		생성자, 메소드 호출 시에만 존재
	// 사용 위치 :	객체 내,외부 사용	생성자, 메소드 블록 내부 사용
}
