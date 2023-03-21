import java.util.Scanner;

public class Ex08_Operation_Quiz {
	public static void main(String[] args) {
		/*
		  간단한 사칙 연산기(+, -, *, /)
		  입력값 3개(입력값은 nextLine() 받아서 필요하다면 숫자 변환)
		  목적 : Integer.parseInt(), equals() 활용
		  
		  화면
		  > 입력값:숫자
		  > 입력값(기호): +
		  > 입력값:숫자
		  -------------
		  > 입력값:100
		  > 입력값(기호): -
		  > 입력값:100
		  > 연산결과:0
		  
		  hint)
		  ■ if문은 조건값이 boolean형
		  ■ switch문은 정수형(byte, short, int)과 문자형(char), 문자열(String)
		  ■ long, boolean, float, double형 사용 불가
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("> 입력값:");
		int firstNum = Integer.parseInt(sc.nextLine());
		System.out.print("> 입력값(기호):");
		String sign = sc.nextLine();
		System.out.print("> 입력값:");
		int secondNum = Integer.parseInt(sc.nextLine());
		int result=0;
		
		if(sign.equals("+")) result = firstNum+secondNum;
		else if(sign.equals("-")) result = firstNum-secondNum;
		else if(sign.equals("*")) result = firstNum*secondNum;
		else if(sign.equals("/")) result = firstNum/secondNum;
		else System.out.println("잘못된 기호입니다.");
		
		System.out.println("> 연산결과:" + result);
		
		/*
		  ** 문자열의 비교는 ==을 쓰면 안된다
		  if(str == "+") x
		  if(str.equals("+") o
		 */
		
	}
}
