
/**
 * 프로그램 >> 실행 >> 프로세스 >> 최소 하나의 Thread(최소 하나의 stack 메모리)
 * >> JVM >> Thread 하나 생성(stack) >> main 할당
 * 
 * 지금까지는 single process만 사용했기 때문에 single thread만 사용
 * main 함수만 실행 >> 하나의 stack만 사용
 */
public class Ex01_Single_Thread {
	public static void main(String[] args) {
		System.out.println("나 main 일꾼이야");
		
		worker();
		worker2();
		
		System.out.println("main 일꾼 종료");
	}
	
	static void worker() {
		System.out.println("나 1번 일꾼이야");
	}
	
	static void worker2() {
		System.out.println("나 2번 일꾼이야");
	}
}
