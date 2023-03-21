/*
1. 자바가 제공하는 기본 타입(원시타입) >> 8가지
2. 8가지 타입은 값을 저장하는 타입
  숫자 -> 정수(음, 0, 양) >> byte(8bit) : -128~127
                      >> char 한 문자(내부적으로는 정수값 >> 영문자, 특수문자, 공백(1byte), 한글(2byte))
                        >> 협의 (국제) : 모든 문자는 2byte로 통일 >> 표준화(unicode) -> 아스키 코드
                        >> ex) char c = 'A'
                      >> short 호환성
                      >> int (4byte -12~21) // 정수 리터럴의 기본 타입은 int형
                      >> long
                      
      -> 실수			  >> float(4byte)
                      >> double(8byte)
                      >> 정밀도가 높다(표현 범위가 크다) // 실수 리터럴의 기본 타입은 double
                      
  논리 ->				  >> boolean >> 참 거짓을 표현하는 타입(true, false)
  
  현재는 대충
  정수는 int, 실수는 double 타입을 사용하면 별 문제 없다.
  
  가장 많이 사용되는 타입 (String) 
  String str = "홍길동" // String은 클래스 -> Stack에 안만들어지고 Heap에 만들어지는 객체
  String 타입은 문자열을 담을 수 있다. -> String str = new String("홍길동");
  
  자바 타입은
  1. 값타입 : 8+1
  2. 참조타입 (주소값을 저장) : 클래스, 인터페이스, 배열 등등
  
 */

public class Ex03_DataType {
	public static void main(String[] args) {
		// int -> -21~21
		int num = 100000000;
		System.out.println("num : " + num);
		
//		int num2 = 100000000000; 
		// The literal 100000000000 of type int is out of range >> 컴파일 오류 
		// literal -> 개발자가 직접 입력한 값, 있는 그대로의 값
		// 나는 4byte 크기의 방이기 때문에 더 큰 값은 받을 수 없다.
		
		// 해결방법 1
//		long num2 = 100000000000;
		// The literal 100000000000 of type int is out of range
		// 개발자가 직접 입력한 정수는 int로 판단 >> 입력하는 정수 범위는 int를 벗어나면 안된다.
		long num2 = 100000000000L;
		System.out.println("num2 : " + num2);
		
		long num3 = 100; // 속지 않으려면 값이 아닌 타입을 봐야한다. (+리터럴값)
						 // long num3 = (long)100
						 // 암시적 형변환(큰 타입에 작은 타입을 넣는 것은 컴파일러가 자동으로 해준다)
						 // 작은 타입 -> 큰 타입 (O)
		
		// 손실이 발생하더라도 굳이 int에 담고 싶다.
//		int num4 = 10000000000; The literal 10000000000 of type int is out of range
//		int num4 = 10000000000L; Type mismatch: cannot convert from long to int
		int num4 = (int)100000000000L;
		// 손실을 감수하고 바꾼다. -> 명시적 형변환(캐스팅)
		System.out.println("타입 변환 : " + num4); // 1215752192 -> 쓰레기값(랜덤임), 정상적 해결방법 x
		
		// 해결방법 1. 강제 형변환
		// Type mismatch: cannot convert from long to int
//		int num5 = (int) 1000L;
		// 데이터 손실이 다행히 없다. 하지만 손실이 발생할 소지는 가지고 있다.
		// 해결방법 2. 담을 그릇을 크게 만들어준다. int -> long
		long num5 = 1000L;
		
		
		// char 2byte >> 16bit >> 0~(216-1) >>> 0~65535 (유니코드)
		/*
		유니코드(영어: Unicode)는 전 세계의 모든 문자를 컴퓨터에서 일관되게 표현하고 다룰 수 있도록 설게된 산업 표준
		유니코드(Unicode)는 전 세계의 모든 문자를 다루도록 설계된 표준 문자 전산 처리 방식이다.
		> 컴퓨터는 이진수만 안다.
		> 컴퓨터와 내가 문자를 입력하고 출력할 수 있도록 해주는게 바로 문자 코드
		> 그리고 문자코드와 숫자를 매칭시킨 표를 문자표라고 한다.
		> 대표적으로 아스키 코드표가 있다.
		아스키 코드표 (ASCII Codes)
		= American Standard Code for Information Interchange
		 */
		
		// char 2byte : 한 문자를 표현하기 위해서 만든 타입
		// 영문자, 특수문자, 공백, 한글 >>> 한문자로 표현하는 표준화
		// 한문자 >> 'A', '가', ' '
		// 문자열 >> "abcd" >> String str = "abcd";
		
		char ch = '가';
		System.out.println("한문자 : " + ch);
//		char ch2 = '가나'; // Invalid character constant, 컴파일도 안된다.
		
		ch = 'a';
		ch = 'A';
		
		// char 정수 타입 (문자를 저장하지만 내부적으로 정수값을 가지고 있다)
		// 아스키 코드표에서 10진수값과 문자값을 비교해보자
		int chint = ch;
		System.out.println("ch의 10진수 값 :" + chint);
		// 암묵적 형변환 -> int chint = (int)ch;
		
		char chint2 = 'a';
		System.out.println(chint2);
		int intch2 = chint2; // 개발자가 직접 형변환해도 문제 없다.
		
		int intch3 = 65;
//		char chint3 = intch3; // Type mismatch: cannot convert from int to char
		// 해결방법 1 (명시적 형변환, 데이터 손실 발생 가능성)
		char chint3 = (char)intch3;
		// 해결방법 2 (받는 그릇의 크기 변환 char -> int)
//		int chint3 = intch3;
		// 해결방법 3 
//		char intch3 = 65; >> intch3의 데이터타입을 바꿈
//		char chint3 = intch3;
		System.out.println("chint3이 가지는 문자값 : " + chint3);
		
		/*
		1. 할당에 있어서 값을 보지말고 값이 가지는 타입을 보자
		1.1 리터럴 값에 대해서
		1.1.1 정수 리터럴의 기본 타입은 int
		1.1.2 실수 리터럴의 기본 타입은 double
		
		2. 암시적 형변환, 명시적 형변환
		2.1 큰 타입에 작은 타입의 값을 넣는 것은 암시적 형변환을 하므로 그냥 사용하면 된다
		2.2 작은 타입에 큰 타입 값을 넣고자 한다면 자동 형변환을 지원하지 않기 때문에 강제적(명시적)형변환(캐스팅)이 필요
		2.2.1 접미사 L, l, (type)정수 등으로 캐스팅
		KEY POINT 강제적 형변환은 데이터의 손실을 감수해야 한다.
		ex) char c = (char) int 범위값 >> 손실
		 */
		
		// String 타입 (8+1) 값 타입처럼 사용하자
		// 문자열 >> 문자의 집합 >> 문자의 배열
		// int, long과 동일하게 사용
		String name = "홍길동";
		name = "홍길동 바보";
		
		String color = "red";
		color = color + " 방가방가"; // 여기에서의 +는 결합연산을 한다.
		System.out.println(color);
		
		// TIP)
		// 연산자는 언어마다 표현이 다르다.
		// JAVA >> + 산술, 결합 둘 다 한다.
		// Oracle >> + 산술만, 결합은 ||
		
		// TIP
		/*
		 * JavaScript
			let i;
			i = 100; // 값이 입력되면 그때 타입을 정의
			const c;
		 */
		
		// Java에서 특수문자 처리하기
		// char sing = ' '; 한문자 공백, 영문, 한글 등
//		char sing = '''; // Invalid character constant -> '을 출력하고 싶음
		// 이스케이프 문자 : 특정 문자앞에 \를 붙이면 다음 값은 데이터로 인정
		char sing = '\'';
		System.out.println(sing);
		
		// Quiz) 홍"길"동 이라는 문자열을 출력해라
		String username = "홍\"길\"동";
		System.out.println(username);
		
		String str1 = "1000";
		String str2 = "10";
		String result = str1 + str2; // 문자열끼리의 +는 결합을 의미
		System.out.println("result : " + result);
		
		System.out.println("100"+100); // 100100
		System.out.println(100+"100"); // 100100
		System.out.println(100+100+"100"); // 200100
		System.out.println(100+(100+"100")); // 100100100
		System.out.println(100+"100"+100); // 100100100
		
		// Quiz) 경로 "C:\Temp" 문자열을 String 변수에 담아서 출력
		String path = "C:\\Temp"; 
		// Invalid escape sequence
		// (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
		System.out.println("경로 : " + path);
		path = "C:\\T\te\tm\tp\nhello"; // \t : tap, \n : 개행
		System.out.println("path2 : " + path);
		
		// 그냥 넘어가는 이유
		// byte : 네트워크 데이터 교환, 파일처리
		// 첫번째 자리는 부호결정 자리 >> 그래서 2^8이 아니라 2^7이고 0을 빼서 -128~127까지인 것
		// long : 금융, 화폐
		
		// 실수형(부동소수점)
		// float : 4byte
		// double : 8byte -> *** 실수 리터럴 기본 타입 ***
		
		// 실수는 그냥 double 타입을 사용
		// float를 사용하려면 명시적으로 접미사를 붙여야 한다.		
//		float f = 3.14; // Type mismatch: cannot convert from double to float
		float f = 3.14f; // float f = (float)3.14; 둘 다 같은 방법 -> 데이터 손실 발생 가능
		
		// 현명한 개발자 >> 처음부터 타입을 크게 잡아서 사용
		double d = 3.14;
		
		// 1. int 4byte, float 4byte 실수가 크다
		// 2. float와 double 중에서 정밀한 값의 표현 >> double
		
		float data = 1.123456789f; // Type mismatch: cannot convert from double to float
		System.out.println("float data : 1.123456789 : " +data);
		// 대략적으로 소수이하 7자리까지 표현(반올림), 1.1234568 >> 반올림 때문에 7->8로 변경
		
		double data2 = 1.123456789123456789;
		System.out.println("double data : 1.123456789123456789 : " + data2);
		// 대략적으로 소수이하 16자리까지 표현(반올림) >> 1.12~~89~~568
		
		// Quiz 1)
		 double data3 = 100;
		System.out.println("data3 : " + data3); // 100.0
		
		// Quiz 2)
		double data4 = 100; // 100.0
		int number = 100; // 100		
//		int result2 = data4 + number; // double + int = double
		// 해결 방법
		// int result2 = (int)data4 + number;
		// int result2 = (int)(data4 + number); // 데이터 손실 위험
		double result2 = data4 + number;
		System.out.println("result2 : " + result2);
		
		// Quiz 3)
		 int number2 = 100;
//		 byte b2 = number2;
		 // 해결 방법
		 // byte b2 = (byte)number2;
		 int b2 = number2;
		 
		 // Today Point
		 // 1. 큰 타입 + 작은 타입 >> 큰 타입
		 // 2. 타입간 변환 >> 변수가 갖는 값이 아닌 변수의 타입으로 판단
		 // 3. 명시적(강제적) 형변환 시 데이터 손실을 고민
		 
		 int data5 = 100;
		 byte b3 = (byte)data5;
		 
		 byte b4 = 20;
		 // int data6 = b4; // 컴파일러가 내부적으로 암시적 형변환
		 int data6 = (int)b4;
	}
}
