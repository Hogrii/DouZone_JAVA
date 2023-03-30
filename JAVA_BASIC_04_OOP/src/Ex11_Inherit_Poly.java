
class Pbase {
	int p = 100;
}

class Cbase extends Pbase {
	int c = 200;
}

class Dbase extends Pbase {
	
}

public class Ex11_Inherit_Poly {
	public static void main(String[] args) {
		// *****다형성 : 상속 관계에서 부모 타입의 참조 변수는 여러 개의 자식 타입 주소를 가질 수 있다
		Cbase cbase = new Cbase();
		System.out.println(cbase.toString()); // Cbase@3d012ddd
		
		// 다형성
		Pbase pbase = cbase;
		System.out.println(pbase.toString()); // Cbase@3d012ddd
		
		Dbase dbase = new Dbase();
		System.out.println(dbase.toString()); // Dbase@5e91993f
		
		// 다형성
		pbase = dbase;
		System.out.println(pbase.toString()); // Dbase@5e91993f		
		// **pbase는 cbase와 dbase의 부모이기 때문에 이 둘의(자식들의) 주소값을 가질 수 있다
		
		////////////////////////////////////////////////////////////////////
		// 부모 주소를 자식에게 주는 것은 불가 >> 강제 변환은 가능
//		Cbase ccc = pbase; // 상위 자원이 하위 자원에 주소값을 주는 것은 불가
		Cbase ccc = (Cbase)pbase; // 그래서 다운 캐스팅(down casting)을 해줘야한다
	}
}
