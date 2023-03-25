package Chapter06_Class;

public class CalculatorExample2 {
	public static void main(String[] args) {
		
		double result1 = 10 * 10 * Calculator2.pi; // 정적 요소는 클래스 이름으로 접근
		int result2 = Calculator2.plus(10, 5);
		int result3 = Calculator2.minus(10, 5);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
	}
}
