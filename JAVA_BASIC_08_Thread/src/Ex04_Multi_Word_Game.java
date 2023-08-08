import javax.swing.JOptionPane;

/*
 * 게임
 * 
 * 문제 ...
 * 시간 ...
 * 2개의 작업을 동시에(경합) >> cpu 점유 할 수 있는 상태
 * 
 * 기존의 단일 Thread로는 불가능
 * multi Thread를 통해서 stack을 여러개 만들어서 사용하길 원한다
 * 
 * 1. Thread 상속
 * 2. Runnable 인터페이스 사용
 */

class Timer extends Thread {
	@Override
	public void run() { // run()은 반드시 구현.. stack 메모리에 올라가는 main 역할을 하기 때문
		for (int i = 10; i > 0; i--) {
			if (Ex04_Multi_Word_Game.inputCheck == true) return;
			try {
				System.out.println("남은 시간 : " + i);
				Thread.sleep(1000); // 휴게실 가서 1초 쉬었다가 다시 와~ >> runnable 상태
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
}

class Word extends Thread {
	@Override
	public void run() {
		String inputData = JOptionPane.showInputDialog("값을 입력하세요"); // javascript의 prompt 창과 유사
		if (inputData.length() > 0)
			Ex04_Multi_Word_Game.inputCheck = true;
		System.out.println("입력값 : " + inputData);
	}
}

public class Ex04_Multi_Word_Game {
	static boolean inputCheck = false; // 값 입력 유무를 판단

	public static void main(String[] args) {
		Timer timerThread = new Timer();
		timerThread.start(); // start() : stack을 만들고 run()을 올려놓은 후 끝!

		Word wordThread = new Word();
		wordThread.start();
		
		// 상태(일시정지) >> 실행되고 있는 Thread를 휴게실로 보내기
		
		// 위성과 지구와의 거리
		// 목성(Thread), 토성(Thread), 금성(Thread) >> 총 거리의 합 >> main Thread 3개의 종료후에 ..
		
		// main thread는 word, time이 끝난 다음에 종료하고 싶어요
		try {
			timerThread.join(); // main에게 내가 끝날때까지 기다려!
			wordThread.join(); // main에게 내가 끝날때까지 기다려!
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("MAIN END"); // 항상 내가 다른 Thread 끝난 다음에 처리할게!
		// 여기서 최종값을 확이인하거나 처리한다
	}
}
