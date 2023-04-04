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
//			System.out.println(elist.get(i)); // toString()을 재정의 했기 때문에 주소값이 아닌 재정의된 값이 나온다
		}
		System.out.println();
		
		// toString()을 사용하지 않고 3명의 사원을 출력
		// hint) getter 사용
		// ArrayList -> 내부적으로 Object[]로 관리
		for(int i=0; i<elist.size(); i++) {
			Object obj = elist.get(i);
//			System.out.println(obj); // 재정의된 toString()을 출력
//			obj. -> getter에 접근 못함.. 부모 타입의 참조 변수는 자식 타입의 주소값을 받을 수 있지만 자식 자원에 접근 불가(재정의 제외)
			// 따라서 자식 타입으로 다운 캐스팅
			Emp e = (Emp)obj;
			System.out.println(e.getEmpno() + " / " + e.getEname() + "/ " + e.getJob());
		}
		System.out.println();
		// 현업 개발자 >> Object -> Downcasting -> 자식 접근에 불만 >> Object 쓰지 말자
		// 대신.. 타입을 강제하자(해당 타입을 쓰게 만들자)
		// 데이터 관리는 하나의 타입으로 하되 타입은 필요시에 사용
		// Generic
		ArrayList<Emp> list2 = new ArrayList<Emp>();
		list2.add(new Emp(1, "A", "IT"));
		for(Emp e : list2) {
			System.out.println(e.getEmpno());
		}
	}
}
