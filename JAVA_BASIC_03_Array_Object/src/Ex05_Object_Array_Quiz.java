import kr.or.kosa.dto.Emp;

public class Ex05_Object_Array_Quiz {
	public static void main(String[] args) {
		/*
		  1. 사원 3명을 만드세요
		  단, Array를 사용
		  사원 정보
		  1000, 홍길동
		  2000, 김유신
		  3000, 유관순
		  
		  2. 개선된 for문으로 사번, 이름 모두 출력
		 */
		
		// 풀이
		Emp[] emplist = new Emp[3];
		emplist[0] = new Emp(1000, "홍길동");
		emplist[1] = new Emp(2000, "김유신");
		emplist[2] = new Emp(3000, "유관순");
		
		for(Emp emp : emplist) {
			emp.empInfoPrint();
		}
	}
}
