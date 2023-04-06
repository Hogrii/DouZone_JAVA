import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
Collection FrameWork
>> 다수의 데이터를 다루는 표준화된 방법 학습 >> 인터페이스와 클래스로 구현
>> 수 많은 인터페이스를 가지고 있다(다수의 데이터를 효율적으로 다루기 위한)

Iterator 인터페이스
나열된 자원에 대해 순차적으로 접근해서 값의 유무를 판단하고 값을 리턴하는 표준을 정의
추상자원을 가지고 있다 >> 어떤 클래스는 Iterator 인터페이스 구현해서 >> 표준화된 접근 방법을 제공

Iterator 인터페이스를 가지고 있는 추상자원
hasNext(), Next(), remove() 추상
ArrayList implements Iterator { 3개의 함수를 재정의 하고 있다 } >> ArrayList는 표준화된 접근을 제공한다


 */
public class Ex08_Collection_Iterator {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		
		// Collection Framework가 제공하는 표준화된 접근 방식
		Iterator it = list.iterator();
		// 호출하면 함수 안에서 인터페이스를 구현하는 객체가 생성되고 그 객체의 주소를 리턴한다
		// Iterator() 함수를 사용하면 자원을 Iterator 인터페이스가 구현하고 있는 함수를 통해서 제어 가능
		while(it.hasNext()) { // ArrayList가 hasNext()를 재정의하고 있다
							  // 현업 권장 -> why? -> 표준화된 출력이기 때문
			System.out.println(it.next());
		}
		System.out.println();
		
		ArrayList<Integer> intList = new ArrayList<>(); // int 타입만 넣을 수 있다
		intList.add(1);
		intList.add(2);
		intList.add(3);
		
		// 인터페이스 generic 명시
		Iterator<Integer> it2 = intList.iterator(); // intList의 제너릭을 Iterator에도 적용시켜야 한다
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println();
		
		// Iterator의 단점 >> 한방향으로만 갈 수 있다
		for(int i=intList.size()-1; i>=0; i--) { // for문은 앞, 뒤 등 자유롭게 이용가능한데
												 // Iterator은 그렇지 못하다
			System.out.println(intList.get(i));
		}
		System.out.println();
		
		// Iterator는 순방향 출력만 가능한데 .. 역방향 조회도 추가 되었다
		// 근데 바로 역방향이 아니라 순방향을 다 갔다가.. 역방향을 와야한다
		ListIterator<Integer> it3 = intList.listIterator();
		
		// 순방향
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		System.out.println();
		
		// 역방향
		while(it3.hasPrevious()) {
			System.out.println(it3.previous());
		}
		
		// 참고
		while(it3.hasNext()) {
			int i = it3.next();
			if(i==3) {
				it3.remove();
			}
		}
	}
}
