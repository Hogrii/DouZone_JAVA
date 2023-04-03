import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Today Point
public class Ex02_ArrayList {
	public static void main(String[] args) {
		// List 인터페이스를 구현하고 있는 클래스 >> ArrayList >> 순서 보장(index), 중복 데이터 허용
		// 식당 번호표, 은행 번호표(동명이인)
		ArrayList arraylist = new ArrayList(); // ctrl+shift+o -> import
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		for(int i=0; i<arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
		System.out.println(arraylist.toString());
		
		// add 함수는 데이터를 순차적으로 넣기 작업을 한다
		arraylist.add(400); // index == 3인 방에 들어간다
		System.out.println("400 추가 : " + arraylist.toString()); // [100, 200, 300, 400]
		arraylist.add(0, 1111);
		System.out.println("0번째 방에 1111추가 : " + arraylist.toString()); // [1111, 100, 200, 300, 400]
		
		// 1. 비순차적인 데이터 추가, 삭제 >> 성능이 좋지 않다 >> 순서가 있는 데이터 집합
		// 2. 순차적인 데이터 추가, 삭제에 유리하다
		
		// [1111, 100, 200, 300, 400]
		System.out.println(arraylist.contains(200)); // true
		System.out.println(arraylist.contains(200000)); // false
		System.out.println(arraylist.size()); // true
		arraylist.clear(); // 데이터 삭제(용량은 남아 있다)
		System.out.println(arraylist.size()); // 0
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		
		System.out.println(arraylist.isEmpty()); // 너 비어있어? -> 데이터 있어 ! >> false
		System.out.println(arraylist.size());
		
		Object value = arraylist.remove(0); // 101 // [101][102][103] >> 101 삭제
		System.out.println("value : " + value);
		System.out.println(arraylist.toString());  // [102][103]
		
		// Point 다형성
		// 인터페이스 부모 타입
		// 다형성(확장성, 유연성)
		
		// 습관적으로 다형성 코드를 써야한다
		List li = new ArrayList<>(); // List는 ArrayList의 부모
		// 부모 타입의 참조변수 li는 자식 객체의 주소값을 가질 수 있다
		// 인터페이스(List)는 구현코드가 없다 .. >> 재정의 .. 자식의 함수(ArrayList) 실행
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
		System.out.println(li.toString()); // [가, 나, 다, 라]
		
		List li2 = li.subList(0, 2); // subList가 생성하는 객체 배열의 타입이 List
									 // 내부적으로 List 인터페이스를 사용하는 코드에 익숙해져야 한다
		System.out.println(li2); // [가, 나]
		
		// ArrayList >> Array
		// 정렬
		ArrayList alist = new ArrayList();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(46);
		alist.add(3);
		alist.add(15);
		System.out.println(alist.toString()); // [50, 1, 7, 40, 46, 3, 15]
		
		Collections.sort(alist);
		System.out.println(alist.toString()); // [1, 3, 7, 15, 40, 46, 50]
		// 높은 값부터 출력하기
		Collections.reverse(alist);
		System.out.println(alist.toString()); // [50, 46, 40, 15, 7, 3, 1]
	}
}