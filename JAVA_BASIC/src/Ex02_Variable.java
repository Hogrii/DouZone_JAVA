import kr.or.kosa.Emp;

public class Ex02_Variable {
	public static void main(String[] args) {
		
		// 변수 선언
		int value; // 선언, 초기화가 되지는 않았다
		value = 100; // 할당, 초기화
		
		int age = 99; // 선언 및 할당, 초기화
		
		// 초기값(초기화)의 정의 : 최초로 값을 받는 것을 의미
		
		int num = 0;
		System.out.println(num); // The local variable num may not have been initialized

		// 지역 변수(local variable)는 사용시 반드시 초기화를 해야한다.
	
		Emp emp; // 선언 
		// stack에 Emp라는 데이터 공간이 생기고 emp라고 부른다. Emp의 크기는? -> 4byte(설계도의 기본 크기)
//		System.out.println(emp); // The local variable emp may not have been initialized
		
		emp = new Emp(); // new 연산자를 사용해 메모리에 올린다. 초기화 작업 >> heap에 생성된 객체의 주소값 >> stack내 emp(지역변수)의 주소값이 된다.
		// 설계도와 똑같은 집을 메모리에 짓는다.
		System.out.println(emp); // kr.or.kosa.Emp@626b2d4a
		
		// .은 주소를 찾아가는 연산자
		System.out.println(emp.empno); // 0 -> default 값
		
		int a, b, c; // 같은 타입의 변수를 나열 >> 같은 타입의 변수를 많이 만들었다 >> int[] a
		// 초기화가 되어 있지 않다 >> 초기화 필수
		a = 100;
		b = 200;
		c = 300; // 사용 가능
		
		int data = 100; // int data; 같은 지역 내에서 같은 변수명은 존재할 수 없다.
		
		int result = a + b; // 초기화
		System.out.println("result 값은 " + result);
		
		int k = 100; // 초기화
		int y = k; // 초기화
		
		y = 200; // 재정의

	}

}

/*
블럭주석

클래스 == 설계도 == 데이터 타입

클래스의 종류
1. class Car {} >> main 함수를 가지고 있지 않은 클래스 >> 독자적인 실행이 불가능 >> 다른 클래스에 도움을 주는 클래스(lib)
2. class Car { public static void main(String[] args){} } >> main 함수를 가지고 있는 클래스 >> 독자적인 실행이 가능
3. 현재는 main 함수를 가지고 있는 클래스가 있어야 결과를 확인 할 수 있다.
4. public static void main(String[] args) >> static (new 없이도 메모리에 생성) >> 함수의 이름 (main) : 시작점, 진입점

TIP)
C# 코드 >> class Car { public static void Main(String[] args){} }

변수 : variable >> 데이터(자료)를 담을 수 있는 공간(메모리)의 이름 >> 공간(크기)는 데이터 타입(자료형)이다.
메모리의 공간이 한정되어 있기 때문에 최소한의 공간에 최대한의 데이터를 표현하기 위해 데이터 타입을 알아야 한다.
int data = 100; 

변수가 선언되는 위치(scope : 유효범위)
1. instance variable : 객체 변수 >> class Car { public int door; } >> 클래스가 가지는 변수
2. local variable : 지역 변수 >> class Car { public void run(){ int data = 0; } } >> 함수가 가지는 변수
3. static variable : 객체간 공유 자원 >> class Car { public static int num; } >> 변수 앞에 붙으면 모든 객체가 사용 가능
4. block variable : 블럭 변수 >> class Car { public void run(){ for(int i=0; ...) } } >> 제어문(제어블럭)이 가지는 변수
*/
