/*
다형성(상속관계에서 존재)
다형성 : 여러가지 성질(상태)를 가질 수 있는 능력

JAVA : [상속관계]에서 [하나의 참조변수]가 [여러개의 타입]을 가질 수 있는 것
 >> [하나의 참조변수] >> 부모타입
 >> [여러개의 타입] >> 부모를 상속받은 자식 타입

다형성 : 현실 >> 부모는 자식에게 모든 것을...
       프로그램 >> 자식이 부모에게 조건 없이 드린다
 */

class Tv2 {
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}

class CapTv extends Tv2 {
	String text;
	String captionText() {
		return this.text = "현재 자막 서비스 처리중 ...";
	}
}

public class Ex10_Inherit_Poly {
	public static void main(String[] args) {
		CapTv ct = new CapTv();
		ct.power();
		ct.chUp();
		System.out.println(ct.captionText());
		/////////////////////////////////////
		
		Tv2 tv2 = ct;
		// ***** 상속 관계에서 부모 타입의 참조 변수는 여러개의 자식 타입의 주소값을 가질 수 있다
		// ***** 단, 부모는 [자신의 자원만 접근] 가능!! 단, 재정의는 제외
		
		System.out.println(tv2.toString()); // 부모 타입 변수에 자식 타입의 주소를 할당 // 자신이 가지는 타입정보만 볼 수 있음(부모 타입)
		System.out.println(ct.toString()); // 자식 타입의 주소
		
//		tv2.captionText(); // The method captionText() is undefined for the type Tv2
		// 부모에게 없는 자원은 자식에게서 볼 수 없다
		
	}
}
