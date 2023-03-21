import java.util.Scanner;

public class Ex10_Statement {
	public static void main(String[] args) {
		
		// 반복문(while, do ~ while)
		int i = 10;
		while(i>=10) { // true
			// 반드시
			// 증가감을 통해 true, false 판다
//			--i; // 증가감의 위치도 고민이 필요
			System.out.println(i);
			--i;
		}
		
		int num = 1;
		int sum = 0;
		while(num<=100) {
			sum += num;
			num++;
		}
		System.out.println(sum);
		
		// while문 구구단
		int num1 = 2;
		int num2 = 1;
		while(num1<10) {
			while(num2<10) {
				System.out.print(num1 + "*" + num2 + "=" + (num1*num2) + "\t");
				num2++;
			}
			num1++;
			num2 = 1;
			System.out.println();
		}
		
		// for(;;) = while(true) 같음
		// break;를 사용해서 탈출
		
		// do ~ while : 일단 한번은 강제로 수행하고 이후 조건을 보고 판단
		// do { 실행 } while(조건);
		/*
		   메뉴구성
		   점심 메뉴를 선택하세요
		   1. 짜장
		   2. 짬뽕
		   3번 입력시 잘못된 입력 경고 후 메뉴를 다시 보여준다.
		 */
		
		Scanner sc = new Scanner(System.in);
		int inputData = 0;
		do {
			System.out.print("숫자를 입력해 (0~9) : ");
			inputData = Integer.parseInt(sc.nextLine());
		}while(inputData>=10); // while 조건이 true이면 계속 실행
							   // while 조건이 false이면 do를 실행 안함
		System.out.println("당신이 입력한 숫자는 " + inputData + "입니다.");
	}
}
