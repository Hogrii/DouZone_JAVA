package kr.or.kosa.dto;

import java.util.Random;

public class CinemaTicket {
	private String ticketSeat;
	private String ticketNum;
	
	public CinemaTicket() {}
	
	public CinemaTicket(String ticketSeat) {
		this.ticketSeat = ticketSeat;
		this.ticketNum = randomNum();
	}
	
	public String randomNum() {
		Random random = new Random();
		String ran = Integer.toString(random.nextInt(8) + 1); 
		for (int i = 0; i < 7; i++) { 
			ran += Integer.toString(random.nextInt(9));
		}
		return ran;
	}
	
	public void ticketInfo() {
		System.out.println("예매한 좌석번호:[" + ticketSeat +"] / 예매번호:[" + ticketNum + "]");
	}
	
	public String getSeatNum() {
		return ticketSeat;
	}
	
	public String getTicketNum() {
		return ticketNum;
	}
}
