import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
Map 인터페이스
(key, value)로 이루어진 쌍의 구조를 갖는 배열
ex) 지역번호 (02, 서울) (031, 경기)

key 중복(x)	>> Set 인터페이스로 확장 가능
value 중복(o)	>> List 인터페이스로 확장 가능

Generic 지원
Map 인터페이스를 구현하는 클래스 >> 동기화(Thread : stack을 여러개 사용)
구버전 : HashTable(동기화) ** 동기화를 보장한다 >> 한강 화장실(Lock) 자원 보호
신버전 : HashMap(동기화) ** 동기화를 보장하지 않는다 >> 한강 비빔밥(성능) ===> 매우매우매우매우중요 ★★★★★

ArrayList, HashMap, Generic >> 기본적인 CRUD >> DB
 */

public class Ex11_Map_Interface {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004"); // key : id, value : pass
		map.put("Scott", "1004");
		map.put("Superman", "1007");
		
		System.out.println(map.containsKey("tiger")); // false >> 대소문자 구별
		System.out.println(map.containsKey("Scott"));
		System.out.println(map.containsValue("1004"));
		System.out.println(map.containsValue("1007"));
		
		// key를 제공하면 해당 key에 해당하는 value값을 준다
		System.out.println(map.get("Tiger"));
		System.out.println(map.get("Hong")); // null
		System.out.println();
		
		// 만약에
		System.out.println(map.size());
		map.put("Tiger", "1008"); // key값이 같으면 value값을 덮어쓴다
		System.out.println(map.size());
		System.out.println(map.get("Tiger"));
		System.out.println(map.toString());
		System.out.println();
		
		Object value = map.remove("Superman");
		System.out.println("삭제된 value : " + value); // 1007
		System.out.println(map.toString());
		System.out.println();
		
		// 응용(이해)
		Set set = map.keySet(); // .keySet() : Set - HashMap
		// keySet() 함수는 Set 인터페이스를 구현하고 있는 객체를 생성하고 데이터를 담고
		// 그 주소를 리턴한다
		// 부모타입인 Set 인터페이스를 통해서 자식 객체의 주소를 받을 수 있다
		// 표준화된 출력
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		Collection clist = map.values(); // .values() : Collection - HashMap
		System.out.println(clist.toString());
	}
}
