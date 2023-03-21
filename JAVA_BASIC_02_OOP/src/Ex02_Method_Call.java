import kr.or.kosa.Fclass;

public class Ex02_Method_Call {
	public static void main(String[] args) {
		Fclass fclass = new Fclass();                  
		fclass.m(); // stack
		
		fclass.m2(1234);
		
		int result = fclass.m3();
		System.out.println("return value : " + result);
		
		result = fclass.m4(10);
		System.out.println("return value : " + result);
		
		result = fclass.opSum(-500);
		System.out.println("return value : " + result);
		
		result = fclass.max(35, 34);
		System.out.println("max return value : " + result);
	}
}
