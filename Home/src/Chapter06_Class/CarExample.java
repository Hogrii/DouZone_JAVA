package Chapter06_Class;

public class CarExample {
	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car();
		
		// Car 객체의 필드값 읽기 -> 기본값 출력
		System.out.println("모델명 : " + myCar.model);	// null
		System.out.println("시동여부 : " + myCar.start);	// false
		System.out.println("현재속도 : " + myCar.speed);	// 0
		System.out.println();
		
		// Car 객체의 필드값 읽기 -> 초기값 출력
		System.out.println("제작회사 : " + myCar.company);		// 현대자동차
		System.out.println("색깔 : " + myCar.color);			// 검정
		System.out.println("최고속도 : " + myCar.maxSpeed);	// 350
		System.out.println("현재속도 : " + myCar.speed);		// 0
		System.out.println();
		
		// Car 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("현재속도 : " + myCar.speed);	// 0 -> 60
		System.out.println();
		
		/////////////////////////////////////////////////////////////
		
		// 1번 생성자 호출
		Car3 car1 = new Car3();
		System.out.println("car1.company : " + car1.company);
		System.out.println();
		
		// 2번 생성자 호출
		Car3 car2 = new Car3("자가용");
		System.out.println("car2.company : " + car2.company);
		System.out.println("car2.model : " + car2.model);
		System.out.println();
		
		// 3번 생성자 호출
		Car3 car3 = new Car3("자가용", "빨강");
		System.out.println("car3.company : " + car3.company);
		System.out.println("car3.model : " + car3.model);
		System.out.println("car3.color : " + car3.color);
		System.out.println();
		
		// 4번 생성자 호출
		Car3 car4 = new Car3("택시", "검정", 200);
		System.out.println("car4.company : " + car4.company);
		System.out.println("car4.model : " + car4.model);
		System.out.println("car4.color : " + car4.color);
		System.out.println("car4.maxSpeed : " + car4.maxSpeed);
		System.out.println();
		
		///////////////////////////////////////////////////////////////
		
		// Car4 객체 생성
		Car4 myCar2 = new Car4();
		
		// 리턴값이 없는 setGas() 메소드 호출
		myCar2.setGas(5);
		
		// isLeftGas() 메소드를 호출해서 받은 리턴ㄴ값이 true일 경우 if 블록 실행
		if(myCar2.isLeftGas()) {
			System.out.println("출발합니다.");
			
			// 리턴값이 없는 run() 메소드 호출
			myCar2.run();
		}
		
		System.out.println("gas를 주입하세요.");
	}
}
