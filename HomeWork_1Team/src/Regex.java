import java.util.regex.Pattern;

public class Regex {
	// 정규표현식		
	// 1. 휴대폰 번호
	public boolean isPhoneNum(String str) {
		return Pattern.matches("^01[0-1|6-9]\\-?\\d{3,4}\\-?\\d{4}$", str);
		// ^ : 시작점
		// ^01 : 01~로 시작해야한다
		// [0-1|6-9] : 0~1 또는 6~9의 숫자가 와야한다
		// \\- : -를 문자열로 사용하기 위해 이스케이프 문자를 붙여준다
		// ? : ? 앞의 문자가 올수도 있고 안올수도 있다
		// \\d : 0~9
		// {3, 4} : 3~4글자
		// $ : 마침점
		
		// 휴대폰 번호는 010, 011, 016, 017, 018, 019로 시작한다
		// 휴대폰 가운데 번호는 3자리 또는 4자리 숫자가 와야한다
		// 휴대폰 마지막 번호는 4자리 숫자가 와야한다
		// 휴대폰 번호를 이어주는 '-'는 사용해도 되고 사용하지 않아도 된다
	}
	
	// 2. 차량번호
	public boolean isCarNum(String str) {
		return Pattern.matches("^\\d{2,3}[가-힣]\s?\\d{4}", str);
		// [가-힣] : 한글 사용
		// \s : 공백
		
		// 차량번호는 2~3자리 숫자로 시작하고 숫자 뒤에는 한글 하나가 온다
		// 한글 뒤에는 공백이 있을수도 있고 없을수도 있다
		// 차량번호 마지막 번호는 4자리 숫자가 와야한다
	}

	// 3. 우편번호
	public boolean isAddress(String str) {
		return Pattern.matches("\\d{5}", str);
		
		// 우편번호는 5자리 숫자로 이루어져 있다
	}
	
	// 4. 도메인 주소
	public boolean isDomainAddress(String str) {
		return Pattern.matches("^(www.)?[a-zA-Z0-9]+(\\.[a-z]{2})?\\.[a-z]{2,3}", str);
		// () : 괄호 안을 하나의 문자열로 인식시켜준다
		// [a-zA-Z0-9] : 영어 대소문자와 숫자를 사용한다
		// + : 앞의 문자가 최소 1번 이상 사용된다
		
		// 도메인 주소의 맨 앞에는 www.이 올수도 있고 안올수도 있다
		// 도메인 주소 이름에는 영어 대소문자 또는 숫자가 1글자 이상 들어간다
		// 도메인 주소의 확장자는 소속기관 서브 도메인이 올 수도 있고 안올수도 있다 >> 서브 도메인 주소에는 영어 소문자 2글자를 사용한다
		// 일반 또는 국가코드 도메인은 2글자 또는 3글자를 사용한다
	}
	
	// 5. 이메일 주소
	public boolean isEmailAddress(String str) {
		return Pattern.matches("^[a-zA-Z0-9]{6,13}\\@[a-zA-Z]+\\.[a-z]{2,3}", str);
		
		// 이메일 주소 아이디는 영어 대소문자와 숫자를 사용하고 6~13자리로 입력한다
		// 아이디 뒤에는 @를 사용한다
		// @뒤에는 영어 대소문자 1글자 이상을 사용하고 . 뒤에는 영어 소문자 2~3글자를 사용한다
	}
	
	public static void main(String[] args) {
		Regex regex = new Regex();                                                                                  
		System.out.println(regex.isPhoneNum("010-2222-3333"));
		System.out.println(regex.isCarNum("12가 3456"));
		System.out.println(regex.isAddress("92237"));
		System.out.println(regex.isDomainAddress("www.naver.com"));
		System.out.println(regex.isEmailAddress("douzoneGroup1@naver.com"));
	}
}
