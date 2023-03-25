package Chapter06_Class;

public class Korean {
	// 필드 선언
	String nation = "대한민국";
	String name;
	String ssn; // 주민등록번호
	
	// 생성자 선언
	public Korean(String name, String ssn) {
		this.name = name; // kname 초기화
		this.ssn = ssn; // kssn 초기화
	}
}
