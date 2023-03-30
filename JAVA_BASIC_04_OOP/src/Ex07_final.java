/*
변수 <-> 상수
상수 : 한 번 값이 [초기화] 되면 변경 불가
상수 자원 : 고유값 >> 주민번호, PI = 3.141591..., 시스템번호(버전번호 v1.0, v1.0.0)
상수는 관용적으로 대문자

JAVA : final int NUM = 10;
C#   : const integer NUM = 10;

final 키워드
1. final class Car {} >> 마지막 클래스 == 확장하지 말아라 == 상속 금지
 ex) final final class Math extends Object
2. public final void print() {} >> 마지막 메소드 == 변경하지 말아라 == 상속 관계에서 재정의 금지
3. member field(상수) 중요
 */

class Vcard {
	final String KIND = "heart";
	final int NUM = 10;
	
	void method() {
		// JAVA API
		System.out.println(Math.PI);
	}
}

// 설계자 입장에서
// 53장의 카드 생성시 카드마다 다른 상수값을 가지고 하고 싶다
class Vcard2 {
	final String KIND;
	final int NUM;
	// 무조건 초기화가 될 것이라는 믿음을 주어야 한다
	// 초기화를 보장하면 된다
	// member field 초기화 >> 생성자
	
//	Vcard2() { }
	Vcard2(String kind, int num) { // 초기값을 보장하는 생성자
		this.KIND = kind;
		this.NUM = num;
	}

	@Override
	public String toString() {
		return "Vcard2 [KIND=" + KIND + ", NUM=" + NUM + "]";
	}	
}

public class Ex07_final {
	public static void main(String[] args) {
		Vcard vcard = new Vcard();
//		vcard.KIND = "AA"; // The final field Vcard.KIND cannot be assigned 변경불가
//		System.out.println(vcard.KIND); // heart
//		vcard.method();
		
		Vcard2 v1 = new Vcard2("spade", 1);
		System.out.println(v1.toString());
		
		Vcard2 v2 = new Vcard2("spade", 2);
		System.out.println(v2.toString());
		
		Vcard2 v3 = new Vcard2("heart", 1);
		System.out.println(v3.toString());
		
//		v3.KIND = "heart"; // The final field Vcard2.KIND cannot be assigned
	}
}
