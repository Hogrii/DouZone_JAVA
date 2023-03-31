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

public class Ex02_abstract_class {
	public static void main(String[] args) {
		Tank tank = new Tank();
		tank.move(2, 0);
	}
}
