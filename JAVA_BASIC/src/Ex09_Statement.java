public class Ex09_Statement {
	public static void main(String[] args) {
		/*
		  제어문
		  조건문 : if(3가지) -> 범위, switch(조건) -> 딱 떨어지는 값
		  반복문 : for(반복횟수가 명확){}, while(진위){}, do{} ~ while()
		  분기문 : break(블럭탈출), continue(아래 구문 스킵)
		 */
		int count = 0;
		if(count < 1) System.out.println("true"); // 단일 if [] 생략 가능
		
		if(count < 1) {
			System.out.println("{true}");
		}
		
		char data = 'A';
		switch(data) {
			case 'A' : System.out.println("문자 비교 같아요");
				break;
			case 'B' : System.out.println("....");
				break;
			default  : System.out.println("나머지 처리");
		}
		
		// for문
		// 1~100까지 합
		int sum = 0;
		for(int i=1; i<=100; i++) sum += i;
		
		System.out.printf("1~100까지 누적 합 : %d \n", sum);
		
		// 1~5까지의 합
		// for문, while() 쓰지 말고 만들기
//		sum = 5*(1+5)/2;
//		System.out.println("sum : " + sum);
		
		// 1~10까지의 홀수 합
		// for문 사용
		// for문 안에 if사용 금지
		int sum2 = 0;
		for(int i=1; i<=10; i+=2) { // 증가감식 변형시키기 가능
			sum2 += i;
		}
		System.out.println("1~10까지 홀수의 합 : " + sum2);
		
		// for문 안에서 if문 사용해서 1~1000까지 짝수 합 구하기
		int sum3 = 0;
		for(int i=1; i<=1000; i++) {
			if(i%2==0) sum3 += i;
		}
		System.out.println("1~1000까지 짝수의 합 : " + sum3);
		
		// Today Point
		// continue, break;
		// 별찍기
		
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(i==j) {
//					break; // 별찍기, 제어문을 탈출한다
//					continue; // 별찍기, 아래의 구문을 스킵한다
				}
				System.out.printf("%s","*");
			}
			System.out.println();
		}
		
		for(int i=2; i<=9; i++) {
			for(int j=1; j<i; j++) {
				System.out.printf("%s","*");
			}
			System.out.println();
		}
		
		// 100부터 0까지의 값 출력(100 시작)
		for(int i=100; i>=0; i--) {
			System.out.println(i);
		}
	}
}
