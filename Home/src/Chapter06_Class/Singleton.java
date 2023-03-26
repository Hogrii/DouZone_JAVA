package Chapter06_Class;

public class Singleton {
	// 애플리케이션 전체에서 단 한 개의 객체만 생성해서 사용하고 싶다면 싱글톤 패턴을 적용
	// 생성자를 private 접근 제한하여 외부에서 new 연산자로 생성자를 호출하지 못하게 막는 것
	
	// private 접근 권한을 갖는 정적 필드 선언과 초기화
	private static Singleton singleton = new Singleton();
	
	// private 접근 권한을 갖는 생성자 선언
	private Singleton() {}
	
	// public 접근 권한을 갖는 정적 메소드 선언
	public static Singleton getInstance() {
		return singleton;
	}
}
