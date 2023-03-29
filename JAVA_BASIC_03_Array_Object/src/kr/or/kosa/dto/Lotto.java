package kr.or.kosa.dto;

import java.util.Scanner;

public class Lotto {

	// 아래와 같이 ....
	private Scanner sc;
	private int[] lotto;
	Lotto[] lottos = new Lotto[5];

	public Lotto() {
		sc = new Scanner(System.in);
	}
	
	public Lotto(int[] lotto) {
		this.lotto = lotto;
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
				for(int i=0; i<lottos.length; i++) {
					int[] lotto = new int[6];
					randomNum(lotto);
					bubbleSort(lotto);
					lottoNumPrint(lotto);
					lottos[i] = new Lotto(lotto);
				}
				int[] findMax = findMaxNum();
				int maxNum = maxNum(findMax);
				int[] lotto = realNum(findMax, maxNum);
				bubbleSort(lotto);
				lottoNumPrint(lotto);
			} else if (selectNum.equals("2")) { // 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {

			}
		}
	}
	
	private int[] realNum(int[] findMax, int maxNum) {
		int[] lotto = new int[6];
		lotto[0] = maxNum;
		
		for (int i = 1; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // 중복 검증
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}
			}
			for (int j=0; j<i; j++) { // 연속된 수 방지
				if(lotto[i] == lotto[j]+1 || lotto[i] == lotto[j]-1) {
					i--;
					break;
				}
			}
			for(int j=0; j<findMax.length; j++) { // 이전 5회차 번호 제외
				if(findMax[j] != 0) {
					if(lotto[i]==findMax[j]) {
						i--;
						break;
					}
				}
			}
		}
		return lotto;
	}
	
	private int maxNum(int[] findMax) {
		int maxNum = 0;
		int sumNum = 0;
		for(int i=0; i<findMax.length; i++) {
			System.out.println(i + " : " + findMax[i] + "번 나옴");
		}
		
		for(int i=0; i<findMax.length; i++) {
			if(sumNum<findMax[i]) {
				maxNum = i;
				sumNum = findMax[i];
			}
		}
		System.out.println("제일 많이 나온 수 : " + maxNum + ", " + sumNum + "번");
		return maxNum;
	}
	
	private int[] findMaxNum() {
		int[] findMax = new int[46];
		System.out.println("lottos 길이 : " + lottos.length);
		System.out.println("lotto 길이 : " + lottos[0].lotto.length);
		for(int i=0; i<lottos.length; i++) {
			for(int j=0; j<lottos[i].lotto.length; j++) {
				findMax[lottos[i].lotto[j]]++;
			}
		}
		return findMax;
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
			for (int j=0; j<i; j++) { // 연속된 수 방지
				if(lotto[i] == lotto[j]+1 || lotto[i] == lotto[j]-1) {
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
