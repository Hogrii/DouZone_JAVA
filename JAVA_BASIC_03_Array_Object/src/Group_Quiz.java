
public class Group_Quiz {
	public static void main(String[] args) {
		/*﻿
		1. 1~45 까지의 난수를 발생시켜서 6개의 정수값을 배열에 담으세요
		2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요 (중복값 검증)
		3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요(정렬 : 자리바꿈 : swap)
		4. 위 결과를 담고있는 배열을 출력하세요
	     */
		
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
		
		// 버블 정렬
		for(int i=0; i<lotto.length-1; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
		
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
	}
}
