package Chapter06_Class;

public class CalculatorExample {
	public static void main(String[] args) {
		// Calculator 객체 생성
		Calculator myCalc = new Calculator();
		
		// 리턴값이 없는 powerOn() 메소드 호출
		myCalc.powerOn();
		
		// plus 메소드 호출 시 5와 6을 매개값으로 제공하고
		// 덧셈 결과를 리턴 받아 result 변수에 대입
		int result = myCalc.plus(5, 6);
		System.out.println("result : " + result);
		
		int x = 10;
		int y = 4;
		
		// divide() 메소드 호출 시 변수 x와 y의 값을 매개값으로 제공하고
		// 나눗셈 결과를 리턴 받아 result2 변수에 대입
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 : " + result2);
		
		// 리턴값이 없는 powerOff() 메소드 호출
		myCalc.powerOff();
		System.out.println();
		
		/////////////////////////////////////////////
		
		// 객체 생성
		Calculator myCalcu = new Calculator();
		
		// 정사각형의 넓이
		double result3 = myCalcu.areaRectangle(10);
		
		// 직사각형의 넓이
		double result4 = myCalcu.areaRectangle(10, 20);
		
		System.out.println("정사각형의 넓이 : " + result3);
		System.out.println("직사각형의 넓이 : " + result4);
	}
}
