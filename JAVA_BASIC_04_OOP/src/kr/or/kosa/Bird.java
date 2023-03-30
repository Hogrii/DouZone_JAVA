package kr.or.kosa;

// 새(공통 : 일반, 추상) : 새는 날 수 있다, 빠르다
public class Bird {
	// 공통 기능
	public void fly() {
		System.out.println("flying");
	}
	
	// 설계자의 고민
	// Bird를 상속하는 당신은 moveFast() 자원에 대해 재정의하여 사용해야해
	protected void moveFast() {
		fly();
	}
}
