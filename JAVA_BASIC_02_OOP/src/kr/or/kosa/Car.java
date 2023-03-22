package kr.or.kosa;

// 1. 모든 member field 캡슐화
// 2. 간접 처리(setter, getter) 구현
// 3. 데이터를 담을 수 있는 클래스(VO, DTO, DOMAIN) >> 1건의 데이터를 담을 수 있는 클래스

public class Car {
	private int window;
	private int speed;
	
	
	public int getWindow() {
		return window;
	}
	public void setWindow(int window) {
		this.window = window;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/*
	   Lombok이란
	   Java 라이브러리로 반복되는 getter, setter, toString 등등 코딩없이 자동 구현
	   코드를 줄여주는 코드 다이어트
	   
	   @Data >> 필요한건 다 만들어주는 어노테이션
	   @Getter
	   @Setter >> 컴파일러가 자동으로 setter, getter 함수를 구현
	   public class Car{
	   	 private int window;
	   	 private int speed;
	   }
	 */
}
