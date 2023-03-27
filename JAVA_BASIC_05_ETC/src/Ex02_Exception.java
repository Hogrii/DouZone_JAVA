
public class Ex02_Exception {
	public static void main(String[] args) {
		System.out.println("main start");
		int num = 100;
		int result = 0;
		
		// 문제가 생길 것이 의심된다면
		try {
			for(int i=0; i<10; i++) {
				result = num / (int)(Math.random()*10); // 0~9
				System.out.println("result : " + result);
			}
		}catch(ArithmeticException e) { // Exception e -> 유지보수 하는 사람이 힘들다
							  // 가독성이 떨어진다
			System.out.println("문제 발생 했어요, 관리자에게 알려주세요");
			System.out.println("무슨 일 : " + e.getMessage());
		}		
		System.out.println("main end");
	}
}
