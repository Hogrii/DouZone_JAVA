import java.util.Properties;

/*
Map 인터페이스를 구현한 클래스
특수한 목적 : <String, String> : key와 value의 타입이 고정 >> String

사용 목적
1. App 전체에 사용되는 자원을 관리할 때 사용한다
2. 환경변수(전역의 의미)
3. 프로그램의 버전
4. 로그인 id, pwd
5. 공통변수

 */
public class Ex14_Properties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("admin", "kosa@or.kr");
		prop.setProperty("version", "1.x.x.x");
		prop.setProperty("downpath", "C:\\Temp\\images");
		
		// 각각의 개발 페이지에서 가정
		System.out.println(prop.getProperty("admin")); // key값을 쓰면 value를 가져온다
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("downpath"));
	}
}
