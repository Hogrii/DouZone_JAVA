
public class Ex09_Static_Method {
	void method() {
		System.out.println("나 일반 함수야");
	}
	
	static void smethod() {
		System.out.println("나 static 함수야");
	}
	
	public static void main(String[] args) {
		smethod();
		Ex09_Static_Method ex09 = new Ex09_Static_Method();
		ex09.method();
		ex09.smethod(); // ex09를 통해서도 호출이 가능하다
	}
}
