import java.util.Scanner;

public class Ex11_Statement_Quiz {
	public static void main(String[] args) {
		// 메뉴를 보여주고 사용자에게 선택
		// 메뉴를 선택하지 않으면 다시 메뉴 보여주기

		// 1. 예금
		// 2. 출금
		// 3. 잔고
		// 4. 종료

		// 잔액 변수를 생성(balance)
		// 예금 처리 + 누적
		// 출금 처리 - 누적
		// 잔고 처리 balance 출력
		// 종료는 시스템 종료(함수의 종료, 강제 종료)

		Scanner sc = new Scanner(System.in);
		int balance = 0;
		int input;
		int output;

		System.out.println("안녕하세요");
		while (true) {
			System.out.println("진호네 금고입니다");
			System.out.println("1.예금 2.출금 3.잔고 확인 4.종료");
			System.out.print("원하시는 메뉴를 선택해주세요 : ");

			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				System.out.println("예금을 선택하셨습니다");
				System.out.print("금액을 입력해주세요 : ");
				input = Integer.parseInt(sc.nextLine());
				System.out.println(input + "원이 예금 되었습니다");
				System.out.println();
				balance += input;
			} else if (menu == 2) {
				System.out.println("출금을 선택하셨습니다");
				System.out.print("금액을 입력해주세요 : ");
				output = Integer.parseInt(sc.nextLine());
				if ((balance - output) < 0) {
					System.out.println("잔액이 부족합니다");
					System.out.println("메뉴로 돌아갑니다");
					System.out.println();
				} else {
					System.out.println(output + "원이 출금 되었습니다");
					System.out.println();
					balance -= output;
				}
			} else if (menu == 3) {
				System.out.println("잔액 조회를 선택하셨습니다");
				System.out.println("현재 잔액은 " + balance + "원 입니다");
				System.out.println();
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다");
				System.out.println("이용해주셔서 감사합니다");
				break;
			} else {
				System.out.println("잘못된 입력입니다");
				System.out.println("메뉴를 다시 선택해주세요");
				System.out.println();
			}
		}
	}
}
