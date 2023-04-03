/*
게임 : 유닛(unit)

unit
1. 공통 기능(이동좌표, 이동, 멈춘다) >> 추상화, 일반화
2. 이동 방법(unit마다 별도의 구현이 (반드시) 필요) 

class Unit { void move(){}; } // 각각 unit을 만드는데 반드시 move는 다른 형태로 구현하세요
 >> 강제성이 없다.. >> 재정의해서 구현하지 않아도 움직이기 때문
 */

abstract class Unit {
	int x,y;
	void stop() {
		System.out.println("Unit stop");
	}
	
	// 이동을 서로 다르게 강제로 구현했으면 좋겠다
	abstract void move(int x, int y); // 실행블럭이 없다 >> 추상함수 >> 미완성 함수
}

class Tank extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank는 소리내며 이동 : " + this.x + ", " + this.y);
	}
	
	// 필요에 따라서 탱크에 대한 구체화, 특수화된 내용을 구현하면 된다
	void changeMode() {
		System.out.println("탱크모드 변환");
	}
}

class Marine extends Unit {
	
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine 이동 : " + this.x + ", " + this.y);
	}
	
	// 특수화, 구체화
	void stimpack() {
		System.out.println("스팀팩 기능");
	}
}

class DropShip extends Unit {
	
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("DropShip 하늘로 이동 : " + this.x + ", " + this.y);
	}
	
	// 툭수화, 구체화
	void load() {
		System.out.println("Unit load");
	}
	
	void unload() {
		System.out.println("Unit unload");
	}
}

class User {
	Unit[] units;
	int index;
	
	User() {
		this.units = new Unit[12];
		this.index = 0;		
	}
	
	void unitMade(Unit unit) {
		if(index>=12) {
			System.out.println("더 이상 생산할 수 없습니다");
		}
		units[index++] = unit;
	}
	
	void unitMove(int x, int y) {
		for(int i=0; i<index; i++) {
			units[i].move(x, y);
		}
	}
	
	void unitRemove() {
		for(int i=0; i<index; i++) {
			units[i] = null;
		}
		this.index = 0;
		System.out.println();
	}
}

public class Ex02_abstract_class {
	public static void main(String[] args) {

		Tank tank = new Tank();
		tank.move(500, 200);
		tank.stop();
		tank.changeMode();
		
		Marine marine = new Marine();
		marine.move(200, 300);
		marine.stop();
		marine.stimpack();
		System.out.println();
		
		// Today Point
		// JAVA : instanceof >> 객체의 타입을 비교하는 연산자 >> true, false 리턴
		// JavaScript : instanceof, typeof(더 많이 쓰임)
		
		if(tank instanceof Unit) {
		 // 객체			  // 타입
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		if(tank instanceof Tank) {
		 // 객체			  // 타입
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		/*
		if(tank instanceof DropShip) {
		 // 객체			  // 타입
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		 */	
		System.out.println();

		
		// 1. 탱크 3대를 만들고 같은 좌표(600, 800)로 이동
		// 2. Tank 1대, Marine 1대, DropShip 1대 생성 후 같은 좌표(666, 888)로 이동

		/*
		User user = new User();
		Tank tank = new Tank();
		Marine marine = new Marine();
		DropShip dropship = new DropShip();
		
		// 1번 풀이
		user.unitMade(tank);
		user.unitMade(tank);
		user.unitMade(tank);
		user.unitMove(600, 800);
		user.unitRemove();
		
		// 2번 풀이
		user.unitMade(tank);
		user.unitMade(marine);
		user.unitMade(dropship);
		user.unitMove(666, 888);
		 */
		
		// 교수님 1번 풀이
		Tank[] tanklist = {new Tank(), new Tank(), new Tank()};
		for(Tank t : tanklist) {
			t.move(600, 800);
		}
		System.out.println();
		
		// 교수님 2번 풀이
		Unit[] unitlist = {new Tank(), new Marine(), new DropShip()};
		for(Unit unit : unitlist) {
			unit.move(666, 888);
		}
		// 이동은 공통 기능이기 때문에 Unit을 이용해서 받아 이동시킬 수 있다.
		// 단, 탱크가 모드 변환을 하게 된다면 Unit으로 받아서는 할 수 없다. >> 자식 타입의 특수, 구체화된 기능이기 때문
	}
}
