/**
 * 
 * Thread : 프로세스에서 하나의 최소 실행단위(흐름) >> method >> 실행되는 공간 stack
 * 
 * 결과 : stack을 여러개 생성해서 동시에 함수를 실행한다(실행 가능하게 한다) >> cpu를 점유 할 수 있는 상태로 만든다
 *
 * Thread 생성 방법
 * 1. Thread 클래스 상속 >> class Task extends Thread >> run 함수 구현
 * 2. Runnable 인터페이스 구현 >> class Task implements Runnable >> run이라는 추상함수만 구현 // Runnable은 Thread가 아니다
 * 	  Runnable 인터페이스는 Thread가 아니기 때문에 사용하기 위해서는 Thread thread = new Thread(new Task())로 선언해야 한다
 * 	  
 * 	  ex) class Task extends Car implements Runanble >> 클래스는 다중상속이 안되기 떄문에 이를 위해 인터페이스를 만든 것
 */

class Task_1 extends Thread {
	@Override
	public void run() { // 함수는 Thread의 main 함수 역할을 한다 >> 새로운 stack에 처음 올라가서 실행되는 함수
		for(int i=0; i<10000; i++) {
			System.out.println("Task_1_" + this.getName() + " " + i); // Thread는 내부적으로 이름이 자동으로 생성된다
		}
		System.out.println("Task_1 run() 함수 END");
	}
}

class Task_2 implements Runnable { 
	// Runnable 인터페이스를 구현한 함수는 Thread가 아니다
	// run()을 구현한 클래스일 뿐이다
	@Override
	public void run() {
		for(int i=0; i<10000; i++) {
			System.out.println("Task_2 " + i);
		}
		System.out.println("Task_2 run() 함수 END");
	}	
}

public class Ex02_Multi_Thread {
	public static void main(String[] args) {
		// main Thread
		
		Task_1 th = new Task_1();
		th.start(); // start 함수는 Thread를 하나 더 생성하고 자신이 갖고 있는 함수(run 함수)를 해당 Thread에 올려준다
					// POINT : memory에 call stack을 생성하고 Thread가 가지는 run() 함수를 stack에 올려 놓는다
		
		Task_2 ta = new Task_2(); // Runnable 인터페이스를 구현한 객체일 뿐이다
		Thread th2 = new Thread(ta); 
		th2.start();
		
		// 익명 객체 활용
		Thread th3 = new Thread(new Runnable() { // 1회성 사용			
			@Override
			public void run() {
				for(int i=0; i<10000; i++) {
					System.out.println("Task_3 " + i);
				}
				System.out.println("Task_3 run() 함수 END");
			}
		});
		th3.start();
		
		for(int i=0; i<10000; i++) {
			System.out.println("main " + i);
		}
		System.out.println("main END");
		

	}
}
