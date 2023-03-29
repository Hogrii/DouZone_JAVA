package kr.or.kosa.dto;

import java.util.Scanner;

public class Lotto {
	//아래와 같이 ....
	private Scanner sc;
	public Lotto() {
		sc = new Scanner(System.in);
	}
	
	public void start() {
		String selectNum = showMenu();
		if(selectNum.equals("1")) { // 당첨 예상 번호 추출하기
			int[] lotto = new int[6];
			int tmp;			
			for(int i=0; i<lotto.length; i++) {
				lotto[i] = (int)(Math.random()*45+1);
				for(int j=0; j<i; j++) { // 중복 검증
					if(lotto[j] == lotto[i]) {
						i--;
						break;
					}
				}
			}
		}else if(selectNum.equals("2")) { // 프로그램 종료
			
		}else {
			
		}	
	}
	
	private String showMenu() {
		System.out.println("***************************");
		System.out.println("**1. 당첨 예상 번호 추출하기**");
		System.out.println("**2. 프로그램 종료 ^^! ^^! ^^**");
		System.out.println("***************************");
		System.out.println("원하는 메뉴 번호를 입력하세요 :");
		String selectNum = sc.nextLine();
		return selectNum;
	}
	
	//여러가지 기능을 가지는 함수를 생성 활용하세요
	// 기능 >> method >> 함수 하나당 기능 하나
	// public >> 참조변수
	// private >> 내부 사용 (공통)
	// 실번호 추출해 주세요
	// 중복값 나오면 안되요
	// 낮은 순으로 정렬해 주세요
	// 화면에 출력해 주세요
	// 메뉴 기능을 만들어 주세요
	
}
