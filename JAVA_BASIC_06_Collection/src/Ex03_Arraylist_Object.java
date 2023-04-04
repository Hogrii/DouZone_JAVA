import java.util.ArrayList;

import kr.or.kosa.Emp;

/*
객체 배열
 */
public class Ex03_Arraylist_Object {
	public static void main(String[] args) {
		// 1. 사원 1명을 만드세요
		Emp emp = new Emp(1000, "김유신", "장군");
		System.out.println(emp.toString());
		
		// 2. 사원 2명을 만드세요 (Array)
		Emp[] emplist = {new Emp(100, "김씨", "영업"), new Emp(200, "박씨", "IT")};
		for(Emp e : emplist) {
			System.out.println(e.toString());
		}
		System.out.println();
		
		// 3. ArrayList를 사용해서 만드세요
		ArrayList elist = new ArrayList();
		elist.add(new Emp(100, "김씨", "영업"));
		elist.add(new Emp(200, "박씨", "IT"));
		// 추가 입사 -> 칸이 모자르면 알아서 늘려버림
		elist.add(new Emp(300, "이씨", "영업"));
		
		for(int i=0; i<elist.size(); i++) {
			System.out.println(elist.get(i).toString());
		}
	}
}
