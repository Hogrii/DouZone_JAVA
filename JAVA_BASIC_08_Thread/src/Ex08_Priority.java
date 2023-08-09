
/*
여러개의 Thread가 있을 때
우선순위 : default 5 ( 공정한 경쟁을 위해서 )
Min(1) .... Max(10)

상대적 수치값을 올리면 CPU 점유할 수 있는 확률이 높아진다
*/

class Pth extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("---------------------------------");
		}
	}
}

class Pth2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("|||||||||||||||||||||||||||||||||");
		}
	}
}

class Pth3 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		}
	}
}

public class Ex08_Priority {

	public static void main(String[] args) {
		Pth pth = new Pth();
		Pth2 pth2 = new Pth2();
		Pth3 pth3 = new Pth3();
		
		// setPriority의 수치에 따라 우선순위가 정해진다
		// 단, setPriority의 수치가 높다고 무조건 먼저 끝나는 것은 아니다
		pth.setPriority(10);
		pth2.setPriority(1);
		pth3.setPriority(1);
		
		System.out.println(pth.getPriority());
		System.out.println(pth2.getPriority());
		System.out.println(pth3.getPriority());
		
		pth.start();
		pth2.start();
		pth3.start();
	}

}
