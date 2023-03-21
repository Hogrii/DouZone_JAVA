import kr.or.kosa.Car;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("hello"); // Ctrl + F11 -> 컴파일 단축키
		// 저장시 컴파일 + 실행파일까지 생성
		
		// 자동차 생산
		// Car mycar -> stack이라는 메모리에 만들어진다.
		Car mycar = new Car(); // new를 이용해 자동차를 만든다. heap 메모리에 올라간다.
		mycar.setDoor(2);
		mycar.setCarColor("red");
		mycar.run();
	}

}
