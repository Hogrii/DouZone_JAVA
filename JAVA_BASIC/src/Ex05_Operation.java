
public class Ex05_Operation {
	public static void main(String[] args) {
		// 연산자(산술, 논리, 관계)
		int result = 100 / 100;
		System.out.println("result : " + result);
		
		result = 13 / 2; // 몫
		System.out.println("result : " + result);
		
		// 나머지를 구하는 연산자(%)
		result = 13 % 2;
		System.out.println("result : " + result);
		
		// 증가, 감소 연산자(++ : 1씩 증가, -- : 1씩 감소)
		int i = 10;
		++i; // 전치 증가
		System.out.println("i : " + i);
		i++; // 후치 증가
		System.out.println("i : " + i);
		
		// Today Point(증가감 연산자와 다른 연산이 결합될 떄)
		int i2 = 5;
		int j2 = 4;
		
		int result2 = i2 + ++j2; // 전치가 먼저 동작
		System.out.println("result2 : " + result2 + ", j2 : " + j2);
		// result2 : 10, j2 : 5
		result2 = i2 + j2++;
		System.out.println("result2 : " + result2 + ", j2 : " + j2);
		// result2 : 10, j2 : 6

		byte b = 100;
		byte b2 = 1;
//		byte b3 = b + b2; // Type mismatch: cannot convert from int to byte
		// 연산시 자바는 기본적으로 4byte 공간을 만들고 공간에 값을 넣고 연산 (int + int)
		// 해결 방법
//		byte b3 = (byte)(b + b2); // 손실이 발생할 수 있다.
//		System.out.println("b3 : " + b3);
		
		int b3 = b + b2;
		System.out.println("b3 : " + b3);
		
		/*
		  Today Point
		  1. 정수의 연산은 [int] 타입으로 변환 후 처리된다.
		  ex) byte + short >> 컴파일러가 내부적으로 값들을 int 방에 넣고 처리 >> int + int
		  ex) char + char  >> 컴파일러가 내부적으로 int + int로 처리
		  정수의 연산에 int 보다 작은 타입들은 내부적으로 모두 int로 바꾸어 연산 처리 된다. -> long 제외
		    -> byte, char, short
		  ex) char + int  >> int
		      int  + int  >> int
		      int  + long >> long
		  정수 + 실수 >> 타입의 크기와 상관없이 '실수'
		 */
		
		long lo = 10000000000L;
		float fo = 1.2f;
//		long result3 = lo + fo; // Type mismatch: cannot convert from float to long
//		long result3 = lo + (long)fo;
		float result3 = lo + fo; // 실수가 정수보다 큰 타입이기 때문이다
		
		char c2 = '!';
		char c3 = '!';
		int result4 = c2 + c3;
		System.out.println("result4 : " + result4);
		
		// 변수 >> 타입(자료형) >> 연산(산술, 논리, 관계) >> 제어문(if, for, while ..)
		// 제어문
		int sum = 0; // local variable(사용전 반드시 초기화)
		for(int j=0; j<=100; j++) { // j의 범위는 for문에서만!
//			sum = sum + j;
//			System.out.println("sum : " + sum); // 5050
			if(j % 2 == 0) { // 짝수라면, 2의 배수라면
				sum += j; // sum = sum + j
			}
		}
		System.out.println("짝수의 합 : " + sum);
		
		int sum2 = 0;
		for(int j=0; j<=100; j++) {
			if(j % 2 == 1) {
				sum2 += j;
			}
		}
		System.out.println("홀수의 합 : " + sum2);
		
		// == 연산자(값을 비교하는 연산자)
		if(10 == 10.0f) { // 타입을 비교하는 것이 아니라 값만 비교한다
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		// != 연산자(부정연산자)
		if('A' != 65) {
			System.out.println("어 같지 않아 : true");
		}else {
			System.out.println("어 같은 값이야 : false");
		}
		
		// Today Point
		// 연산자 중에서 제어문 역할(조건, 반복)
		// 삼항연산자
		int p = 10;
		int k = -10;
		int result5 = (p == k) ? p : k;
		System.out.println("result5 : " + result5);
		
		// ===는 javascript에서 타입도 같고 값도 같은 것을 반환
		
		// if문
		int result6 = 0;
		if(p == k) {
			result6 = p;
		}else {
			result6 = k;
		}
		System.out.println("result6 : " + result6);
		
		/*
		  진리표(논리연산)
		  0 : 거짓(false)
		  1 : 참(true)
		  
		  OR 연산, AND 연산
		  
		  DB 쿼리 Oracle)
		  select * from emp where job='IT' and sal > 3000;
		  select * from emp where job='IT' or sal > 3000;
		       AND  ,  OR
		  0 0   0      0
		  0 1   0      1
		  1 0   0      1
		  1 1   1      1
		  
		  연산자 비트 연산(| or연산, & and연산)
		  || 논리연산(OR), && 논리연산(AND)
		 */
		int x = 3; // 011
		int y = 5; // 101 -> or 연산 >> 111, and 연산 >> 001
		
		// 비트 연산(10진수 >> 2진수로 바꾸어서 연산)
		System.out.println("x | y = " + (x|y)); // 7
		System.out.println("x & y = " + (x&y)); // 1
		
		/*
		  Today Point
		  (&& >> and 연산)
		  (|| >> or 연산)
		  if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1) { A }else { B } >> 거짓 조건이 나오면 false
		  if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1) { A }else { B } >> 참 조건이 나오면 true
		 */
		
		// 제어문
		/*
		// break가 없는 switch
		int data = 90;
		switch(data) {
			case 100 : System.out.println("100입니다.");
			case 90 : System.out.println("90입니다.");
			case 80 : System.out.println("80입니다.");
			default : System.out.println("일치하는 값이 없습니다.");
		}
		*/
		
		int data = 90;
		switch(data) {
			case 100 : System.out.println("100입니다.");
				break;
			case 90 : System.out.println("90입니다.");
				break;
			case 80 : System.out.println("80입니다.");
				break;
			default : System.out.println("일치하는 값이 없습니다.");
		}
		
		// 브레이크가 없는 switch문 응용
		int month = 3; // 월을 데이터로 제공
		String res = ""; // 빈 문자열 초기화
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: res = "31일";
				break;
			case 4:
			case 6:
			case 9:
			case 11: res = "30일";
				break;
			case 2: res = "29일";					
				break;
			default : res = "월이 아닙니다.";
		}
		System.out.println(month + "월은 " + res + "까지 입니다.");
		
		// 난수(랜덤값, 임의의 추출값)을 얻기를 원한다
		// https://docs.oracle.com/javase/8/docs/api/index.html >> API 문서
		// 패키지 기준(폴더별로 자원을 모아놓았다)
		// java.lang.Math >> 여러 수학적 기능들을 가지고 있음 >> java.lang.Math.random()
		// import java.lang.*; 생략 -> default open
		
		// public static double random();
		// 값의 범위는 0.0 <= random < 1.0		
		System.out.println("Math.random() : " +Math.random());
		System.out.println("Math.random() * 10 : " +Math.random() * 10); // 0~9
		// (int)(Math.random() * 10) + 1
		System.out.println((int)(Math.random() * 10) + 1); // 1~10까지
		
		// switch(조건) 정수만 들어가는건 아님
		// 조건식은 "문자열"도 가능, "문자" 가능
		
		String m = "F";
		String f="";
		switch(m) {
			case "A":
		  	case "B":
		  	case "C":
		  	case "D":
		  	case "E":
		  	case "F":
		  	case "G": f="ok";
		  	   break;
		  	case "H":
		  	case "k": f= "no";
		  	   break;
		  	default : f ="no data";
		}
	    System.out.println("결과 : " + f);
	}
}
