import java.util.Scanner;

public class Ex07_printf_format {
	public static void main(String[] args) {
		// System.out.println()
		// Console.WriteLine()
		
		System.out.println("A"); // 출력하고 줄바꿈(엔터)
		System.out.println();
		System.out.println("B");
		
		int num = 1000;
		System.out.println(num);
		System.out.println("num 값은 " + num + " 입니다");
		
		// 형식 format
		System.out.printf("num 값은 %d 입니다.", num);
		System.out.println();
		System.out.printf("num 값은 [%d] 입니다 또 [%d] 도 있어요 \n", num, 12345);
		
		/*
		  %d 10진수 정수
		  %f 실수
		  %s 문자열
		  %c 문자
		  \t 탭, \n 개행
		 */
		
		float f = 3.14f;
		System.out.println(f);
		System.out.printf("f의 변수값은 %f 입니다. \n", f);
		
		// cmd 모드(Console 창에서) 사용자가 입력한 값을 읽음
		// 설계도 == 클래스 == 타입은 사용하고 싶을 때 heap 메모리에 올린다.
		Scanner sc = new Scanner(System.in); // ()->생성자 함수를 호출하는 괄호
//		String value = sc.nextLine(); // 입력하고 enter 칠때까지 대기
//		System.out.println("value 입력 값 : " + value);
		
		/*
		int number = sc.nextInt(); // 사용자가 입력한 값을 정수로 변환해서 리턴하는 함수
		System.out.println(number);
		
		권장사항) nextInt -> Integer.parseInt(sc.nextLine());
		
		Today Point
		[문자를] -> 숫자로(정수, 실수)
		
		String data = sc.nextLine();
		int idata = Integer.parseInt(data);
		
		Integer.parseInt("10000"); -> 10000
		Float.parseFloat("3.14"); -> 3.14
		 */
		
		System.out.print("숫자를 입력하세요. : ");
		int number = Integer.parseInt(sc.nextLine());
		System.out.printf("입력한 숫자는 : %d", number);
	}
}
