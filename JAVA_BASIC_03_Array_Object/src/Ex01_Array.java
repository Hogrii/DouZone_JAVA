import java.util.Arrays;

/*
배열은 객체다
1. new를 통해 생성한다 -> 주소값을 가지고 있다
2. heap 메모리에 생성(관리자원)
3. 정적 배열(고정 배열) : 배열은 한번 선언하면(크기가 정해지면) 변경 불가
   <-> 동적(Collection : API 클래스)
4. 자료구조(알고리즘) : 제어문(결합) >> 기초적인 자료구조
 */

public class Ex01_Array {
	public static void main(String[] args) {
		// 같은 타입의 변수 여러 개를 선언해서 사용
		int s, s1, s2, s3, s4;
		int s5; int s6; int s7;
		
		// 배열
		int[] score = new int[5]; // 배열 5칸을 heap 메모리에 만들고 해당 주소값을 score에 담는다
		// score(101동) >> 101호, 102호 ~ 105호
		// int 타입의 방을 5개 >> heap >> 연속된 공간 >> 방 이름 제공(index(첨자))
		//  >> [0][1][2][3][4]		
		System.out.println(score[0]);
		score[0] = 100;
		score[1] = 200;
		score[2] = 300;
		score[3] = 400;
		score[4] = 500;
//		score[5] = 600; // ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
		
		// 방의 개수는 항상 index 값보다 1이 크다(마지막 index : n-1);
		System.out.println(score[3]);
		
		// 배열 방에 있는 모든 값 출력 -> for, 중첩 for문과 궁합이 좋다
		for(int i=0; i<5; i++) {
			System.out.printf("[%d]=%d\t", i, score[i]);
		}
		System.out.println();
		
		// 배열은 객체다
		for(int i=0; i<score.length; i++) { // Array 배열의 개수를 제공(.length)
			System.out.printf("[%d]=%d\t", i, score[i]);
		}
		System.out.println();
		
		// java.util.Arrays -> 헬퍼 클래스 >> 당신이 필요한 다양한 함수 >> static
		String resultArray = Arrays.toString(score);
		System.out.println(resultArray); // [100, 200, 300, 400, 500]
		
		// Tip) 당분간 쓰지 마세요 -> Arrays.sort(score);
		// 정렬 알고리즘 -> 버블, 퀵, 셀렉
		
		// Today Point
		// 배열 만드는 3가지 방법
		int[] arr = new int[5]; // 기본
		int[] arr2 = new int[] {10, 20, 30, 40, 50}; // 초기값을 통해 배열의 개수를 정의하고 값을 할당
		int[] arr3 = {11, 22, 33}; // 컴파일러가 알아서 new를 처리
		// Tip) javascript
		// const arr = [10, 20, 30, 40, 50]; let arr = []; -> javascript 배열은 동적배열

		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		// 배열은 객체다(new로 생성하고 heap에 올라간다)
		int[] arr4; // stack에 변수만 생성(null) >> arr4는 메모리가 없다
		arr4 = new int[] {21, 22, 23, 24, 25};
		System.out.println(arr4); // [I@79b4d0f 주소값
		
		int[] arr5 = arr4; // 주소값 할당
		// 같은 메모리를 보고 있다
		System.out.println(arr5 == arr4); // true
		
		// 배열의 타입은 : 8가지 + String + 클래스(타입)
		String[] strarr = new String[] {"가", "나", "다"};
		for(int i=0; i<strarr.length; i++) {
			System.out.println(strarr[i]);
		}
		
		char[] carr = {'A', 'B'};
		float[] farr = new float[3];
		Car[] cararr = new Car[3]; // cararr[0] -> Car 타입의 주소값
		// Car c = new Car();
		// cararr[0] = c;
	}
}

class Car { // 클래스 == 설계도 == 데이터 타입
	
}
