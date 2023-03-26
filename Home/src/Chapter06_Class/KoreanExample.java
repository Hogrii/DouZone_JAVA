package Chapter06_Class;

public class KoreanExample {
	public static void main(String[] args) {
		// Korean 객체 생성
		Korean k1 = new Korean("박자바", "011225-1234567");
		
		// Korean 객체 데이터 읽기
		System.out.println("k1.knation : " + k1.nation);
		System.out.println("k1.kname : " + k1.name);
		System.out.println("k1.kssn : " + k1.ssn);
		System.out.println();
		
		// 또 다른 Korean 객체 생성
		Korean k2 = new Korean("김자바", "930525-0654321");
		
		// 또 다른 Korean 객체 데이터 읽기
		System.out.println("k2.knation : " + k2.nation);
		System.out.println("k2.kname : " + k2.name);
		System.out.println("k2.kssn : " + k2.ssn);
	}
}
