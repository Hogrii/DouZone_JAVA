package Chapter06_Class;

public class Calculator2 {
	// 계산기에서 사용하는 파이 값은 동일하다
	// 동일한 값을 사용한다면 static 변수로 선언하는 것이 좋다
	static double pi = 3.14159;
	
	static int plus(int x, int y) {
		return x+y;
	}
	
	static int minus(int x, int y) {
		return x-y;
	}
	
}
