import java.util.ArrayList;

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
	}
}
