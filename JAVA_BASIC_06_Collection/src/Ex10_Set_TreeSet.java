import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex10_Set_TreeSet {
	public static void main(String[] args) {
		// set : 순서(x), 중복(x)
		
		/*
		   TreeSet 순서 x, 중복x, 정렬 기능(o)
		    >> 사용 이유 : 검색, 정렬이 필요할 때 사용하는 자료구조
		    >> 로또
		   
		   이진트리 : root > leaf
		   데이터 저장시 정렬기능 제공		   		   
		 */
		
		HashSet<String> hs = new HashSet<>();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		System.out.println(hs.toString());
		// [P, A, B, D, F, G, K] >> 순서를 유지하지 않는다, 중복데이터가 없다
		
		Set<Integer> lotto = new TreeSet<>();
		for(int i=0; lotto.size()<6; i++) {
			int num = (int)(Math.random()*45 + 1);
			lotto.add(num);
			System.out.println("num : " + num);
		}
		System.out.println(lotto.toString());
		// [6, 16, 26, 27, 42, 45] >> 중복이 없고 정렬까지 관리해준다
	}
}
