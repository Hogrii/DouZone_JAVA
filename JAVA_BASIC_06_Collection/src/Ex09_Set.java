import java.util.HashSet;

/*
Set 인터페이스
(원 안에 들어가세요) : 순서를 보장하지 않는다, 중복을 허락하지 않는다
순서가 없고 중복을 허락하지 않는 데이터 집합을 다룰 때 사용
구현하는 클래스
HashSet, TreeSet(자료구조)

 */

public class Ex09_Set {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(1);
		hs.add(100);
		boolean bo = hs.add(55);
		System.out.println("정상 : " + bo);
		
		bo = hs.add(1); // false >> 같은 데이터가 이미 구슬 주머니 안에 있다
		System.out.println("결과 : " + bo);
		
		System.out.println(hs.toString()); // [1, 100, 55] >> 결과는 넣은 순서대로 나오지만 실제로 순서가 있는 것은 아니다
		
		// 로또, 차량번호, 회원 id, ...
		HashSet<String> hs2 = new HashSet<>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("C");
		hs2.add("Z");
		hs2.add("A");
		hs2.add("H");
		hs2.add("b");
		hs2.add("b");
		System.out.println(hs2.toString()); // [A, b, C, F, H, Z] >> 중복데이터 없음, 순서대로도 안나옴
		
		String[] strobj = {"A", "B", "C", "D", "B", "A"};
		HashSet<String> hs3 = new HashSet<>();
		for(int i=0; i<strobj.length; i++) {
			hs3.add(strobj[i]); // 중복 데이터는 add 하지 않는다
		}
		System.out.println(hs3.toString()); // [A, B, C, D]
		
		// Quiz
		HashSet<Integer> lotto = new HashSet<>();
		while(lotto.size()<6) {			
			lotto.add((int)(Math.random()*45+1));
		}
		System.out.println(lotto.toString());
	}
}
