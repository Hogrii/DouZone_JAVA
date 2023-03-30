/*
현업 개발
한개의 클래스로 설계하는 경우 -> x

설계도 1장에 모든 업무를 구현하는 것은 현실적으로 불가능하다
 >> 설계도를 여러개로 나눈다 >> 문제 발생(문제를 어떠한 기준, 논리를 이용해 나눌 필요가 있음)

쇼핑몰
결제 관리, 배송 관리, 재고 관리, 회원 관리, 상품 관리, 판매처 관리, 카드 관리 >> 각각의 업무별 설계도가 필요

**** 기준 ****
여러개의 설계도가 있을때 관계를 만들어주는 기준
**** 1. is ~ a  : 은(는) ~ 이다 >> 상속의 관계(부모를 뒤에)
**** 2. has ~ a : 은(는) ~을 가지고 있다 >> 포함의 관계

원은 도형이다 >> 상속
경찰은 권총을 가지고 있다 >> 포함 // 경찰은 권총이다 (x)

원은 도형이다 >> 원 extends 도형
삼각형은 도형이다 >> 삼각형 extneds 도형

원은 점을 가지고 있다 >> 부품정보
 >> class 원 { 점이라는 부품이 member field 구현  점 관련 내용 }
 >> class 점 { x, y }
 
경찰 권총
경찰은 권총이다 (x)
경찰은 권총을 가지고 있다 (o)
class 권총 {}
class 경찰 { 권총 member field }

원은 도형이다
삼각형은 도형이다
사각형은 도형이다

**** 도형 >> 분모(공통적) 자원 : 추상화, 일반화 >> 그리다, 색상을 갖고 있다
**** 원 >> 구체화, 특수화(자신만이 가지는 특징) >> 반지름, 한 점

점 >> 좌표값(x, y)
원은 점을 가지고 있다
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다

---------------------------
class Shape{ 그리다, 색상 } >> 상속관계에서 부모 역할 >> 원, 삼각형, 사각형의 부모
class Point{ 좌표값 } >> 포함 관계 >> 부품

구체화, 특수화 : Circle, Triangle
 */

class Shape {
	String color = "gold";
	void draw() {
		System.out.println("도형을 그렸다");
	}
}

class Point {
	int x;
	int y;
	
	Point() {
		this(1, 1); // x, y
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 문제)
/*
원을 만드세요(원의 정의 : 원은 한 점과 반지름을 가지고 있다)
1. 원은 도형이다 (is ~ a) : Shape
2. 원은 점을 가지고 있다(has ~ a) : Point
3. 원의 특수화되고 구체화된 내용 : 반지름

원의 반지름은 초기값 10을 가진다
점의 좌표는 초기값 (10, 15)를 가진다
초기값을 설정하지 않으면 반지름과 점의 값을 입력 받을 수 있다.
 */

class Circle extends Shape {
	int radius; // 구체화, 특수화
	Point point; // 포함 >> 부품
	
	Circle() {
		this(10, new Point(10, 15)); // 한 번 더 공부하기!!!!!!!!!!!!!
	}
	
	Circle(int radius, Point point) {
		this.radius = radius;
		this.point = point;
	}
}

/*
삼각형 클래스를 만드세요
삼각형은 3개의 점과 색상, 그리다 기능을 가지고 있다
hint) Shape, Point 제공 받아서 설계도를 작성하세요
hint) (x, y), (x,y), (x,y)
default 삼각형을 만들 수 있고 3개의 좌표값을 받아서 그릴 수 있다
 */

class Triangle extends Shape{
	Point[] points;
	
	Triangle() {
		this(new Point[] {new Point(10,20), new Point(30,40), new Point(50,60)});
	}
	
	Triangle(Point[] points) {
		this.points = points;
	}
}
 
public class Ex02_Inherit_Compotition {
	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println(circle.radius);
		System.out.println(circle.color);
		System.out.println(circle.point.x); // 주소값.주소값.주소값.field
		System.out.println(circle.point.y);
		circle.draw();
		
		// 반지름, 점의 값을 자유롭게 하고 싶다
		/*
		Point point = new Point(10, 20);
		Circle circle2 = new Circle(100, point);
		 */
		
		Circle circle2 = new Circle(100, new Point(10, 20)); // 많이 쓰인다.
		System.out.println();
		
		Triangle triangle = new Triangle();
		for(Point point : triangle.points) {
			System.out.println("점 : (" + point.x + "," + point.y +")");
		}		
		System.out.println("색상 : " + triangle.color);
		triangle.draw();
	}
}
