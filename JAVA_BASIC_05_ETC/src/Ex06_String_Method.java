import java.util.StringTokenizer;

public class Ex06_String_Method {
	public static void main(String[] args) {
		String str = "hello";
		String concatstr = str.concat(" world"); // 결합
		System.out.println(concatstr);
		
		boolean bo = str.contains("ello"); // 순서가 맞는 문자열 확인
		System.out.println(bo);
		
		String str2 = "a b c d"; // [a][ ][b][ ][c][ ][d]
		System.out.println(str2.length()); // 문자열의 길이 7
		
		String filename = "hello java world";
		System.out.println(filename.indexOf("e")); // 해당 문자열의 첨자(인덱스) 위치
		System.out.println(filename.indexOf("java")); // 단어가 시작되는 첨자 위치
		System.out.println(filename.indexOf("폭망")); // -1(없다는 뜻)
		
		if(filename.indexOf("wo") != -1) {
			System.out.println("wo 단어가 하나라도 있다");
		}
		
		System.out.println(filename.lastIndexOf("a")); // 9
		
		// length(), indexOf(), substring(), replace(), split() 암기 ..
		
		String result = "superman";
		System.out.println(result.substring(0)); // 시작 index부터 다 출력, superman
		System.out.println(result.substring(1)); // uperman
		System.out.println(result.substring(1, 2)); // u
		// beginIndex the beginning index, inclusive. -> 포함 함
		// endIndex the ending index, exclusive. -> 포함 안함
		System.out.println(result.substring(0, 1)); // s
		System.out.println(result.substring(0, 0)); // (0, -1) 가져올게 없음 >> 빈칸 출력
		
		// Quiz
		String filename2 = "home.jpg"; // 또는 h.jpeg, a.hwp도 올 수 있다
		// 여기서 파일명과 확장자를 분리해서 출력
		int position = filename2.indexOf(".");
		String file = filename2.substring(0, position);
		String type = filename2.substring(position);
		System.out.println("파일명 : " + file + ", 확장자 : " + type);
		
		// replace
		String str3 = "ABCDADDA";
		String result3 = str3.replace("DD", "오늘은 화요일");
		System.out.println(result3);
		
		result3 = str3.replace("A", "a");
		System.out.println(result3);
		
		// ETC
		System.out.println(str3.charAt(0)); // index 값 위치의 문자를 출력
		System.out.println(str3.charAt(3)); // D
		System.out.println(str3.endsWith("ADDA")); // 끝나는 문자열이 해당 문자열과 일치하면 true
		System.out.println(str3.equalsIgnoreCase("AbCdAdDa")); // 대소문자 구별 없이 비교, 일치하면 true
		
		// Today Point
		String str4 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] nameArr = str4.split(","); // String[]으로 리턴
		for(String s : nameArr) {
			System.out.println(s);
		}
		// .split(".")은 먹히질 않는다 -> .이 regex의 문법(예약어)이기 때문
		// .split("\\.")		
		
		// 정규표현식은 내일
		
		//
		String str6 = "a/b,c-d.f";
		StringTokenizer sto = new StringTokenizer(str6, "/,-.");
		while(sto.hasMoreElements()) {
			System.out.println(sto.nextToken());
		}
		
		// 넌센스
		String str7 = "홍     길     동";
		// 저장 >> 공백을 제거 >> "홍길동"
		System.out.println(str7.replace(" ", "")); // 홍길동
		
		String str8 = "     홍길동     ";
		System.out.println(str8.trim()); // .trim() >> 양쪽 공백 제거, 가운데는 없음
		
		String str9 = "   홍   길   동   ";
		
		// 이렇게 하면 안된다
//		String result5 = str9.trim();
//		result5 = result5.replace(" ", "");
		
		// 메소드 체인을 이용해 사용한다
		String result5 = str9.replace(" ", "").trim();
		System.out.println(result5);
		
		// hint
		int sum = 0;
		String[] numarr = {"1", "2", "3", "4"};
		for(String value : numarr) {
			sum += Integer.parseInt(value);
		}
		System.out.println(sum);
		
		// Quiz
		String jumin = "123456-1234567";
		jumin = jumin.replace("-", "");
		int sum2 = 0;
		for(int i=0; i<jumin.length(); i++) {
			sum2 += Integer.parseInt(jumin.substring(i, i+1));
		}
		System.out.println(sum2);
	}
}
