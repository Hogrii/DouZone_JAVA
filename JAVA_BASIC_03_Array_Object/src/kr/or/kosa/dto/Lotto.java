package kr.or.kosa.dto;

import java.util.Scanner;

public class Lotto {

	// 아래와 같이 ....
	private Scanner sc;

	public Lotto() {
		sc = new Scanner(System.in);
	}

	// 여러가지 기능을 가지는 함수를 생성 활용하세요
	// 기능 >> method >> 함수 하나당 기능 하나
	// public >> 참조변수
	// private >> 내부 사용 (공통)
	// 실번호 추출해 주세요
	// 중복값 나오면 안되요
	// 낮은 순으로 정렬해 주세요
	// 화면에 출력해 주세요
	// 메뉴 기능을 만들어 주세요

	public void start() {
		while (true) {
			String selectNum = showMenu();
			if (selectNum.equals("1")) { // 당첨 예상 번호 추출하기
				int[] lotto = new int[6];
				randomNum(lotto);
				bubbleSort(lotto);
				lottoNumPrint(lotto);
			} else if (selectNum.equals("2")) { // 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {

			}
		}
	}
	
	private void lottoNumPrint(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) { // 로또 번호 확인
			System.out.print(lotto[i] + " ");
		}
		System.out.println();
	}
	
	private void bubbleSort(int[] lotto) {
		int tmp;
		for (int i = 0; i < lotto.length - 1; i++) { // 버블 정렬
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
	}
	
	private void randomNum(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // 중복 검증
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}
			}
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
}
