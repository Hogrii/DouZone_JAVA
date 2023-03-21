package kr.or.kosa.common;

public class Kosa_Main {
	public static void main(String[] args) {
//		Apt air = new Apt(); -> 접근이 안됨(public이 아닌 클래스이기 때문)
		Car car = new Car();
		AirPlane airPlane = new AirPlane();
	}
}
