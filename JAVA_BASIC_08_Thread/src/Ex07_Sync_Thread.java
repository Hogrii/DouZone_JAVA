/*
 * 멀티 스레드 환경(이슈 : 공유자원)
 * 
 * synchronized(동기화)
 * 
 * Collection(Vector, ArrayList)
 * 
 * Vector는 동기화를 보장 >> 멀티 스레드 환경에서 자원을 보호 >> 화장실(Lock) >> 성능 저하
 * ArrayList는 동기화를 보장하지 않는다 >> 성능 보장 >> 자원 보호를 보장하지는 않는다
 * 
 * 한강
 * 화장실(1개) : 공유자원
 * 여러명의 사람들(10명) : 10개의 스레드 >> 동시에 화장실 접근
 * 
 * 반대(성능)
 * 한강 비빔밥 축제 : 여러 사람이 동시 접근(빨리 ....) Lock 처리 안돼요
 */

class Wroom {
	synchronized void openDoor(String name) {
//	void openDoor(String name) { // synchronized를 사용하면 비빔밥 축제됨
		System.out.println(name + "님 화장실 입장 ^^");
		for (int i = 0; i < 11; i++) {
			System.out.println(name + " 사용 중 " + i);
			if (i == 10) {
				System.out.println(name + "님 끙~~@#$@%!%^&");
			}
		}
		System.out.println("시원하시죠 ^^");
	}
}

class User extends Thread {
	Wroom wr;
	String who;

	User(String name, Wroom wr) {
		this.who = name;
		this.wr = wr;
	}

	@Override
	public void run() {
		wr.openDoor(this.who);
	}
}

public class Ex07_Sync_Thread {
	public static void main(String[] args) {
		// 한강 둔치
		Wroom w = new Wroom();

		// 사람들이 놀고 있어요
		User kim = new User("김씨", w);
		User lee = new User("이씨", w);
		User park = new User("박씨", w);

		// 배가 아파요
		kim.start();
		lee.start();
		park.start();
	}
}
