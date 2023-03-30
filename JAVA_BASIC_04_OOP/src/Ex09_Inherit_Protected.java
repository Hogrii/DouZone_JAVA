import kr.or.kosa.Bird;

class Bi extends Bird{
	@Override
	protected void moveFast() {
		super.moveFast();
	}	
}

class Ostrich extends Bird {
	// Ostrich
	// 특수화, 구체화
	void run() { // 1. Ostrich만의 특수화를 정의하고
		System.out.println("run .....");
	}

	@Override
	protected void moveFast() {
		run(); // 2. moveFast에 Ostrich만의 특수화를 재정의한다
	}
}

public class Ex09_Inherit_Protected {
	public static void main(String[] args) {
		Bi bi = new Bi();
		bi.fly(); // Bird로부터 받은 상속
		bi.moveFast(); // Bird로부터 오버라이드
					   // protected를 보기 위해 super()를 이용해 접근
		
		Ostrich o = new Ostrich();
		o.fly(); // Bird로부터 받은 상속
		o.moveFast(); // Bird로부터 오버라이드
					  // Bird로부터 받아온 moveFast를 자신만의 특수화로 재정의
	}
}
