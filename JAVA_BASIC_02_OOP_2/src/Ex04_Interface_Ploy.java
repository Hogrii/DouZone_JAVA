
class Unit2 {
	int hitPoint; // 맞으면 감소하는 에너지
	final int MAX_HP; // 최대 에너지
	
	Unit2(int hp) {
		this.MAX_HP = hp;
	}
}
// 인터페이스
// ~할 수 있는(수리할 수 있는) 
interface Irepairable { }

// 지상 유닛, 공중 유닛, 건물
class GroundUnit extends Unit2 {
	GroundUnit(int hp) {
		super(hp);
	}	
}

// 공중 유닛
class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}

// 건물
class CommandCenter implements Irepairable { }

// 유닛
class Tank2 extends GroundUnit implements Irepairable {
	Tank2() {
		super(50);
		this.hitPoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Tank2";
	}
}

class Marine2 extends GroundUnit {
	Marine2() {
		super(50);
		this.hitPoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Marine2";
	}
}

// Scv >> 광물캐기, 수리(탱크)
class Scv extends GroundUnit implements Irepairable {
	Scv() {
		super(50);
		this.hitPoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Scv";
	}
	
	// Scv만의 구체화, 특수화된 고유한 기능 구현
	// 수리하다(repair)
	// Tank2, Scv, CommandCenter
	
	// 전자제품 매장 제품 1000개 >> 하나의 함수가 구매하고 싶다 
	//  >> 다형성을 이용해서 모든 제품의 부모 타입을 이용
	// buy(Product n) ..
	
	/*
	void repair(Tank2 tank) {
		
	}
	void repair(Scv scv) {
		
	}
	*/
	// GroundUnit 부모(Tank2, Marine2, Scv)
	// void repair(Unit2 unit)) >> class AirUnit extends Unit2(x) , Marine2 (x)
	//  >> 부모의 범위가 너무 넓다.. 올 수 있는 애들이 너무 많음
	// void repair(GroundUnit unit) >> Tank2, Marine2(x), Scv
	// CommandCenter repair >> 서로의 공통점(연결고리 >> 부모가 같지 않음)
	
	// 이때!!!!!!!!!!!!!!! 인터페이스!!!!!!!!!!!!!!!!! 등장!!!!!!!!!!!!!!!!!!
	// Interface Irepairable{}
	
	// class CommandCenter implements Irepairable {} // 커멘드센터는 '수리할 수 있는' 자원이 되었다
	// class Tank2 extends GroundUnit implements Irepairable {}
	// class Scv extends GroundUnit implements Irepairable {}
	// 서로 연관없는 CommandCenter, Tank2, Scv는 Irepairable이라는 같은 부모가 생겼다
	
	// 다형성
	void repair(Irepairable repairunit) { // 부모 타입의 참조변수는 자식 타입의 주소값을 받을 수 있다.
		// Tank2, Scv, CommandCenter
		// 고칠 수 있는애들이 다 들어왔는데... 수리하는 방법이 다 다르네....
		// Tank2, SCV는 >> HP를 올려주면 된다..
		// CommandCenter는 다른 방법으로 repair
		
		// repairunit이 일반 Unit2인지 건물인지 판단해야 한다
		// >> instanceof..를 이용해서 판단해야한다.
		if(repairunit instanceof Unit2) {
			// Tank2, Scv
			Unit2 unit2 = (Unit2)repairunit; // Irepairable repairunit >> 
			if(unit2.hitPoint != unit2.MAX_HP) { // hitPoint는 맞았을때 줄어들고 남은 체력
				unit2.hitPoint = unit2.MAX_HP; // 완충
			}
		}else {
			// Commander Center
			System.out.println("다른 충전 방식을 통해 repair 합니다");
		}
	}
}

public class Ex04_Interface_Ploy {
	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		Scv scv = new Scv();
		
		CommandCenter center = new CommandCenter();
		
		// 전투
		tank.hitPoint -= 20;
		System.out.println("탱크 : " + tank.hitPoint);
		System.out.println("Scv 수리 요청");
		scv.repair(tank);
		System.out.println("탱크 수리 완료 : " + tank.hitPoint);
	}
}
