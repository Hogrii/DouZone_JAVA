package Chapter06_Class;

public class KoreanExample2 {
	public static void main(String[] args) {
		// 객체 생성 시 주민등록번호와 이름 전달
		Korean2 k1 = new Korean2("123456-1234567", "감자바");
		
		// 필드값 읽기
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		// final 필드는 값을 변경할 수 없음
//		k1.nation = "USA"; // The final field Korean2.nation cannot be assigned
//		k1.ssn = "123-12-1234";
		
		// 비 final 필드는 값 변경 가능
		k1.name = "김자바";
	}
}
