package kr.or.kosa;

// Class == 설계도 == 타입
public class Car {
	private int door;
	private String carColor;
	// private -> 캡슐화, 직접적으로 사용하지 못하게 막는다.
	
	// 직접적으로 조작하지 못하기 때문에 getter, setter를 이용해 간접적으로 조작 가능하게 한다.
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}	
	
	// void -> return이 없다는 의미
	// 설계도
	public void run() {
		System.out.println("달린다");
	}
	
	public void stop() {
		System.out.println("멈춘다");
	}
}
