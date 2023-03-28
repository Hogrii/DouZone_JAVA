/*
String 클래스(문자를 여러 개 담을 수 있는 클래스)
String은 수 많은 함수를 가지고 있다.. 대부분의 데이터는 문자열(자르고, 합치고, 나누고, 조합)
String >> 가지고 있는 일반 함수 + static 함수 활용하기 위해 배운다(15~20개 정도)
 
*/
public class Ex05_String_Class {
	public static void main(String[] args) {
		String str = ""; // 초기화
		String[] strarr = {"abc", "bbb", "ccc"};
		
		for(String s : strarr) {
			System.out.println(s);
		}
		// 사용방법 : int, double 등 값타입처럼 부담없이 사용
		
		String st = "홍길동";
		System.out.println(st.length()); // String -> 배열
		// [홍][길][동] >> char[]로 관리
		System.out.println(st); // 주소 예상 >> 실제 값은 값
		System.out.println(st.toString()); // toString()이 생략되어 있어서 st만 입력해도 값이 나온다
		// String 클래스는 Object 부모 클래스를 가지고 있고 Object는 toString()을 가지고 있다
		// 상속 관계 >> String extends Objects >> 재정의(Override) >> 주소에 가서 값을 read하고 그 [값을 리턴]
		
		// String 정식 표기법
		String sdata = new String("김유신");
		System.out.println(sdata);
		
		String name = "가나다라마";
		// String 내부적으로 char[] member field >> 배열 [가][나][다][라][마]
		// class String extends Object {private char[] str .. setter, getter .. @Override toString()}
		
		String str1 = "AAA";
		String str2 = "AAA";
		
		// 문자열의 비교
		System.out.println(str1); // toString()이 생략
		System.out.println(str2.toString()); // toString() 주소값이 아니고 값이 나오도록 재정의
		
		System.out.println(str1 == str2); // true
		// 값이 같기 때문에 새로 AAA를 만들지 않고 재사용한다 >> 그래서 같은 주소
		// **메모리에 실제로 같은 문자열이 있으면 재사용
		// str1과 str2는 같은 메모리를 참조한다
		
		// Point
		// 문자열의 비교는 무조건 equals
		System.out.println(str1.equals(str2));// 주소를 찾아가서 그 안에 값을 비교
		
		// why : equals
		String str3 = new String("BBB");
		String str4 = new String("BBB"); // 메모리를 각각 만든다
		System.out.println(str3==str4); // false
		System.out.println(str3.equals(str4)); // true, 주소가 아닌 값을 비교
											   // equals를 사용해야하는 이유
		
		String s = "A";
		s += "B";
		s += "C";
		System.out.println(s);
		s = "A";
		System.out.println(s);
		// String을 누적시키면 메모리 낭비
		// StringBuilder, StringBuffer를 사용한다
	}
}
