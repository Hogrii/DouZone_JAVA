package kr.or.kosa.dto;

import java.util.Scanner;

public class CinemaInput {
	Scanner sc = new Scanner(System.in);
	
	public int menu() {
		return Integer.parseInt(sc.nextLine());
	}
	
	public String seatNum() {
		String seatNum;
		return seatNum = sc.nextLine();
	}
	
	public String reservationMenu() {
		String reservationMenu;
		return reservationMenu = sc.nextLine();
	}
	
	public void inputTicketNum() {
		String ticketNum = sc.nextLine();
		
	}

}
