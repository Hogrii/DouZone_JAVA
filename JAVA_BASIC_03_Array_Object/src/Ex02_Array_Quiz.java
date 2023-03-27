
public class Ex02_Array_Quiz {
	public static void main(String[] args) {
		// 국문과 학생들의 기말고사 시험점수
		/*
		  [제어문]을 통해 max라는 변수에 시험점수 중 최대값
		  min 변수에 최소값
		  출력결과 : max >> 97, min >> 54
		  단) for문을 한번만 사용 
		 */
		
		int[] score = new int[] {79, 88, 97, 54, 56, 95};
		int max = score[0];
		int min = score[0];
		
		// 풀이
		for(int i=0; i<score.length; i++) {
			if(score[i]>max) max = score[i];
			if(score[i]<min) min = score[i];
			
			// 삼항연산자 사용 가능
		}
		System.out.println("max >> " + max + ", min >> " + min);
		System.out.println();
		
		
		// 10개의 방의 값을 1~10까지로 초기화하고 출력
		int[] numbers = new int[10];
		
		// 풀이
		for(int i=0; i<numbers.length; i++) { // 1~10까지 초기화
			numbers[i] = i+1;
			System.out.println(numbers[i]);
		}
		System.out.println();	
		
		
		// 어느 학생의 기말고사 시험점수(5과목)
		// 1. 총과목의 수
		// 2. 과목의 합
		// 3. 과목의 평균
		// 단, 2, 3번 문제는 하나의 for문으로 해결
		int[] jumsu = {100, 55, 90, 60, 78};
		int sum = 0;
		float avg = 0f;
		
		// 풀이
		// 1번
		System.out.println("총 과목의 수 : " + jumsu.length);
		
		// 2번
		for(int i=0; i<jumsu.length; i++) {
			sum += jumsu[i];
			if(i==jumsu.length-1) {
				avg = (float)sum/jumsu.length;	
			}			
		}
		System.out.println("과목의 합 : " + sum);
		
		// 3번
		System.out.println("과목의 평균 : " + avg);
	}
}
