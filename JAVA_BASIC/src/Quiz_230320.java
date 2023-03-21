import java.util.Scanner;

public class Quiz_230320 {
	public static void main(String[] args) {
		// UNIT : 화폐단위
		// NUM : 화폐매수
		// SW : 스위칭 변수, 화폐의 다음 단위를 위해
		// MONEY : 입력받는 금액
		
		int UNIT = 10000;
		int NUM = 0;
		int SW = 0;
		
		// 입력
		Scanner sc = new Scanner(System.in);		
		int MONEY = Integer.parseInt(sc.nextLine());
		
		while(true) {
			NUM = (int)MONEY/UNIT;
			System.out.println("UNIT : " + UNIT);
			System.out.println("NUM : " + NUM);
			
			// 종료 판단
			if(UNIT<=1) break;
			
			MONEY -= UNIT * NUM;
			if(SW == 0) {
				UNIT /= 2;
				SW = 1;
			}else {
				UNIT /= 5;
				SW = 0;
			}			
		}		
	}
}
