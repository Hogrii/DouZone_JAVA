package kr.or.kosa;
/*
기능(행위) 만드는 방법
method를 만드는 방법(문법)

method : 행위 또는 기능의 최소단위 구현 : [하나의 함수]는 [하나의 기능]만 구현
ex) 먹는 기능, 자는 기능 각각.. 둘을 섞어서 만들면 안된다
ex) 게임방 >> 농구, 인형 뽑기(포켓몬)

** 모든 함수는 호출에 의해서만 동작한다
 = 누군가 이름을 부르지 않으면 동작하지 않는다.

JAVA)
1. void, parameter(o) : public void print(String str) { 실행 }
2. void, parameter(x) : public void print() { 실행 }
3. return type, parameter(o) : public int print(int data) { return 100; }
4. return type, parameter(x) : public int print() { return 100; }

void >> return type 없음
return type >> 8가지 기본 타입 + 1(String), Array, Class, interface, Collection
이 중 8가지 + String + class 학습할 것

public boolean print() { return true; }
Car print() { return Car의 주소값 }
Car print() { return new Car }
Car print() { Car car = new Car(); return car; }

String print() { return "문자열"; }

parameter type >> void print(String 변수)
parameter type >> 8가지 기본 타입 + 1(String), Array, Class, interface, Collection

void print(int i) { } >> 호출시 print(100);
void print(String str) { } >> 호출 print("문자열");
void print(Car c) { } >> Car c1 = new Car() >> 호출 print(c1); or print(new Car());

void print2(int a, int b, int c) { }// 무조건 3개의 파라미터를 받는다.

print2(10); x
print2(10, 20); x
print2(10, 20, "30"); x
print2(1, 2, 3); o

함수의 이름 : 관용적인 표현
class Car, class Person

메서드 : getNum();

사원테이블에서 사원의 모든 정보를 가지고 오는 함수를 만들어라
void getEmpAllList();

사원테이블에서 사원의 번호를 가지고 사원의 모든 정보를 출력
void getEmpListByEmpno();

 */
public class Fclass {
	public int data;
	
	// void m() >> 컴파일러가 default void m()으로 알아서 넣음
	
	// 함수의 접근자(수정자) 70%는 public
	// 함수의 30%는 private
	// 클래스 내부에서는 public, private가 의미가 없음
	// 클래스 내부에서만 사용해라 >> 다른 함수를 도와주는 함수(공통 함수)
	
	public void m() { // void parameter (x)
		// 기능 구현
		System.out.println("일반함수 : void, parameter(x)");
	}
	
	public void m2(int i) {
		System.out.println("일반함수 : void, parameter(0)");
		System.out.println("parameter 값을 활용 : " + i);
	}
	
	public int m3() {
		// 강제로 return 구현
		return 10000;
	}
	
	public int m4(int data) {
		return 100 + data;
	}
	
	// return type (o), parameter (o)
	public int sum(int i, int j, int k) {
		return i+j+k;
	}
	
	// 함수의 접근자(수정자) 한정자
	// int sum(); >> 컴파일러가 default int sum();
	// private int sum() >> 객체 입장에서 접근 불가 >> 같은 클래스 내 접근 가능
	// 클래스 내부에서 다른 함수를 도와주는 공통함수
	
	private int subSum(int i) {
		return i + 100;
	}
	// Fclass fclass = new Fclass();
	// fclass.보이지 않음
	
	public void callSubSum() {
		int result = subSum(100); // private 함수
		System.out.println("call result : " + result);
	}
	
	public int opSum(int data) {
		// 다양한 로직(제어문)
		int result = subSum(data);
		// 제어
		if(result > 0) {
			return 1;
		}else {
			return -1;
		}
	}
}
