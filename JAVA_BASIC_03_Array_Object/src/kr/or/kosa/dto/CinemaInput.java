package kr.or.kosa.dto;

import java.util.Scanner;

public class CinemaInput {
	Scanner sc = new Scanner(System.in);
	
	public int menu() { // 예매 메뉴
		return Integer.parseInt(sc.nextLine());
	}
	
	public String seatNum() { // 좌석 선택 입력
		String seatNum;
		return seatNum = sc.nextLine();
	}
	
	public String reservationMenu() { // 예매 여부 입력
		String reservationMenu;
		return reservationMenu = sc.nextLine();
	}
	
	public String inputTicketNum() { // 예매번호 입력
		String ticketNum;
		return ticketNum = sc.nextLine();
		
	}
	
	public String cancleMenu() { // 예매 취소 입력
		String cancleMenu;
		return cancleMenu = sc.nextLine();
	}
}
/*





*/