import java.util.regex.Pattern;

public class Regex {
	// 정규표현식		
	// 1. 휴대폰 번호
	public boolean isPhoneNum(String str) {
		return Pattern.matches("^01\\d\\-\\d{3,4}\\-\\d{4}", str); // +.*
	}
	
	// 2. 차량번호
	public boolean isCarNum(String str) {
		return Pattern.matches("^\\d{2}[가-힣]\s\\d{4}", str);
	}

	// 3. 우편번호
	public boolean isAddress(String str) {
		return Pattern.matches("\\d{5}", str);
	}
	
	// 4. 도메인 주소
	public boolean isDomainAddress(String str) {
		return Pattern.matches("^(www.)?[a-zA-Z0-9]+(\\.[a-z]{2})?\\.[a-z]{2,3}", str);
		// yahoo.com, hotmail.com, gmail.com		
	}
	
	// 5. 이메일 주소
	public boolean isEmailAddress(String str) {
		return Pattern.matches("^[a-zA-Z0-9][a-zA-Z0-9]{5,10}\\@[a-zA-Z]+\\.[a-z]{3}", str);
	}
	
	public static void main(String[] args) {
		Regex regex = new Regex();
		System.out.println(regex.isPhoneNum("010-2222-3333"));
		System.out.println(regex.isCarNum("12가 3456"));
		System.out.println(regex.isAddress("92237"));
		System.out.println(regex.isDomainAddress("www.naver.com"));
		System.out.println(regex.isEmailAddress("hosboy93@naver.com"));
	}
}
