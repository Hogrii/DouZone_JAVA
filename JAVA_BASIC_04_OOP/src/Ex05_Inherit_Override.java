import kr.or.kosa.Emp;

class Test2 {
	int x = 100;
	
	void print() {
		System.out.println("부모함수 Test2");
	}
}

class Test3 extends Test2 {
	int x = 300; // c#에서는 부모 "무시하기"라고 표현
	
	// 재정의
	@Override
	void print() {
		System.out.println("자식이 부모의 함수를 재정의");
	}
	
	// Overloading
	void print(String str) {
		System.out.println("나 오버로딩이야 " + str);
	}
}

public class Ex05_Inherit_Override {
	public static void main(String[] args) {
		Test3 test3 = new Test3();
		
		System.out.println(test3.x);
		test3.print();
		test3.print("overloading");
		
		Emp emp = new Emp(1000, "홍길동");
		System.out.println(emp);
		// kr.or.kosa.Emp@1c4af82c
		// kr.or.kosa.Emp + @ + 1c4af82c 이렇게 조합된 값이 나온다
		System.out.println(emp.toString());
		// kr.or.kosa.Emp@1c4af82c >> emp 뒤에 .toString()이 생략이 되어 있음을 알 수 있다
		
		/*
		  class Object {
		  	public String toString() {
		  	  return 패키지명 + "@" + 주소값
		  	}
		  }
		  
		  class Emp extends Object {
		  
		  }
		 */
		
	}
}
