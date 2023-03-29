package Day_230329;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스
		int t = Integer.parseInt(sc.nextLine());
		// 문제 번호
		int questionNum = 1;
		
		while(t-->0) {
			// 장기판 길이
			int n = Integer.parseInt(sc.nextLine());
			// 장기판
			String[][] board = new String[n][n];
			// 잡을 수 있는 말
			int catchCnt = 0;
			boolean canCatch = false;
			// x의 위치
			int xx = 0;
			int xy = 0;
			
			// 장기판 입력
			for(int i=0; i<board.length; i++) {
				String str = sc.nextLine();
				for(int j=0; j<board.length; j++) {					
					board[i][j] = str.split(" ")[j];
					if(board[i][j].equals("X")) {
						xx = j;
						xy = i;
					}
				}
			}
			
			// x축 체크(+ 체크)
			for(int i=xx; i<board.length; i++) {
				if(board[xy][i].equals("H")) {
					if(canCatch == true) {
						catchCnt++;
						break;
					}
					canCatch = true;
				}
				if(board[xy][i].equals("Y")) {
					break;
				}
			}
			
			// x축 체크(-체크)
			canCatch = false;
			for(int i=xx; i>=0; i--) {
				if(board[xy][i].equals("H")) {
					if(canCatch == true) {
						catchCnt++;
						break;
					}
					canCatch = true;
				}
				if(board[xy][i].equals("Y")) {
					break;
				}
			}
			
			// y축 체크(+ 체크)
			canCatch = false;
			for(int i=xy; i<board.length; i++) {
				if(board[i][xx].equals("H")) {
					if(canCatch == true) {
						catchCnt++;
						break;
					}
					canCatch = true;
				}
				if(board[i][xx].equals("Y")) {
					break;
				}
			}
			
			// y축 체크(-체크)
			canCatch = false;
			for(int i=xy; i>=0; i--) {
				if(board[i][xx].equals("H")) {
					if(canCatch == true) {
						catchCnt++;
						break;
					}
					canCatch = true;
				}
				if(board[i][xx].equals("Y")) {
					break;
				}
			}			
			System.out.println("#" + questionNum++ + " " + catchCnt);
		}
	}
}
