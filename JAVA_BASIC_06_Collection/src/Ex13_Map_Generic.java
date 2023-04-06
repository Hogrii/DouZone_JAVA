import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
HashMap<k, v> >> key, value 모두 generic 사용 가능

HashMap<String, String>
HashMap<Integer, String>
** Point >> HashMap<String, Student>

put("jhlee", new Student());

 */

class ArrayTest {
	ArrayList<String[]> al = new ArrayList<>();
}

class Student {
	int kor;
	int math;
	int eng;
	String name;
	
	public Student(int kor, int math, int eng, String name) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.name = name;
	}	
}

public class Ex13_Map_Generic {
	public static void main(String[] args) {
		HashMap<String, String> sts = new HashMap<>();
		sts.put("A",  "AAA");
		System.out.println(sts.get("A"));
		System.out.println();
		
		// 실무에서 Map
		// 학생의 성적 데이터
		// key(학번), value[국어,영어,수학] >> Array, Collection을 사용해야 한다
		
		HashMap<String, Student> smap = new HashMap<>();
		smap.put("hong", new Student(100, 90, 50, "홍길동"));
		smap.put("kim", new Student(50, 30, 50, "김유신"));
		
		Student sd = smap.get("kim");
		System.out.println(sd.kor + " / " + sd.eng + " / " + sd.math + " / " + sd.name);
		
		ArrayTest at = new ArrayTest();
		String[] strarr = {"A", "B", "C"};
		at.al.add(strarr);
		System.out.println();
		
		// Tip - entrySet()
		Set set = smap.entrySet(); // .entrySet() >> 가공된 데이터를 리턴해준다
								   // Map(key, value) 가공 >> key=value 형태로 리턴
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			// hong=Student@626b2d4a
			// kim=Student@5e91993f
		}
		System.out.println();
		
		// Tip
		// Key, value
		// class Entry {Object key, Object value}
		// Map {Entry[] elements} >> Map.Entry >> Entry 집합을 얻을 수 있음
		for(Map.Entry m : smap.entrySet()) {
			System.out.println(m.getKey() + " / " + (Student)m.getValue());
		}
	}
}
