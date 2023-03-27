/*
오류
1. 에러(error) : 네트워크 장애, 메모리, 하드웨어 >> 개발자의 코드로 해결이 불가
2. 예외(exception) : 개발자의 코드 실수로 발생 >> 문제 발생 코드를 찾아서 수정 후 배포
2.1 컴파일시 : 실행파일이 생성이 안된다 -> 무조건 해결
2.2 런타임시(실행도중) : 문제 시점에서 강제 종료 -> 문제 이후 코드 실행이 안된다

예외처리 : 프로그램이 안정적으로 종료 >> 원인 분석 >> 코드 수정 >> 배포

try {
	>> 문제가 의심되는 코드
	>> 문제가 발생 되면 >> 예외가 발생한 정보를 담을 수 있는 객체를 자동 생성
	ex) [0][1][2] >> car[3] = ""; 
	  -> ArrayIndexOutOfBoundsException 생성 >> 예외 정보 담기
	  -> new ArrayIndexOutOfBoundsException("정보") 
}catch(Exception e) { // ArrayIndexOutOfBoundsException의 주소값이 들어옴
					  // Exception은 모든 예외의 부모 타입 >> 상속
	>> 문제 파악
	>> 처리 보고
	 >> 1. 관리자 email
	 >> 2. 로그 기록(장애 발생 기록)
	 >> 3. 강제 종료는 막는다
}finally {
	>> 문제가 발생하던, 발생하지 않던 강제적으로 실행되는 코드
	>> return 함수를 만나면 프로그램이 종료되지만 finally는 return을 만나도 무조건 실행된다.
	>> DB 작업(DB 자원 종료(해제))
}
 */
public class Ex01_Exception {
	public static void main(String[] args) {
		/*
		System.out.println("main start");
		System.out.println(0/0); // java.lang.ArithmeticException: / by zero
		// 문제가 발생하면 종료되고 더 이상 코드를 실행하지 않는다
		System.out.println("main end");
		 */
		
		System.out.println("main start");
		try {
			System.out.println(0/0);
		}catch(Exception e) { // 부모 타입 변수는 자식 타입의 주소값을 받을 수 있다
			// 문제파악 -> 전달	  // 다형성(Polymophism)
			System.out.println("문제 발생" + e.getMessage());
			// getMessage() -> 예외 문제가 무엇인지 알려준다
			e.printStackTrace();
			// printStackTrace() -> 예외 문제가 발생한 위치를 알려준다
		}
		System.out.println("main end");
	}
}
