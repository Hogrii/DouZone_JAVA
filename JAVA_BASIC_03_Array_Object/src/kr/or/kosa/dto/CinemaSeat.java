package kr.or.kosa.dto;

import java.util.Random;

public class CinemaSeat {
	private String seatNum;
	private String ticketNum;
	CinemaSeat[][] seat = new CinemaSeat[4][5];
	
	// 초기 세팅
	public CinemaSeat() {		
		init(seat);
	}
	
	// 좌석번호 입력
	public CinemaSeat(String seatNum) {
		this.seatNum = seatNum;
		this.ticketNum = "0";
	}
	
	// 좌석번호마다 객체(좌석번호, 예매번호) 생성
	public void init(CinemaSeat[][] seat) {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				String seatStr = (i+1) + "-" + (j+1);
				seat[i][j] = new CinemaSeat(seatStr);
			}
		}
	}
	
	// 예매번호 랜덤 8자리
	public String randomNum() {
		Random random = new Random();
		String ran = Integer.toString(random.nextInt(8) + 1); 
		for (int i = 0; i < 7; i++) { 
			ran += Integer.toString(random.nextInt(9));
		}
		return ran;
	}
	
	// 예매 확정 + 예매번호 발행
	public void setSeatNum(String seatNum) {
		String[] rowcols = seatNum.split("-");
		int row = Integer.parseInt(rowcols[0])-1;
		int col = Integer.parseInt(rowcols[1])-1;
		this.seat[row][col].seatNum = "예매";
		this.seat[row][col].ticketNum = randomNum();
	}
	
	public String getSeatNum() {
		return seatNum;
	}
	
	public String getTicketNum() {
		return ticketNum;
	}
	
	public CinemaSeat[][] getSeat() {
		return seat;
	}
	
	// 현재 좌석
	public void getPrintSeat() {
		for(int i=0; i<seat.length; i++) {
			for(int j=0; j<seat[i].length; j++) {
				System.out.printf("[%s]", seat[i][j].getSeatNum().equals("예매") ? "예매" : seat[i][j].getSeatNum());
			}
			System.out.println();
		}
	}
	
	// 좌석번호 Row 얻기
	public int getRow(String seatNum) {
		String[] rowcols = seatNum.split("-");
		int row = Integer.parseInt(rowcols[0]);
		return row;
	}
	
	// 좌석번호 Col 얻기
	public int getCol(String seatNum) {
		String[] rowcols = seatNum.split("-");
		int col = Integer.parseInt(rowcols[1]);
		return col;
	}
	
	// 예매번호로 내 자리 찾기
	public String getMySeatNum(String ticketNum) {
		String mySeatNum = "";
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if(seat[i][j].ticketNum.equals(ticketNum)) {
					return mySeatNum = (i+1)+"-"+(j+1);
				}
			}
		}
		return mySeatNum;
	}
	
	// 예매번호로 취소하기
	public void cancleMySeat(String ticketNum) {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if(seat[i][j].ticketNum.equals(ticketNum)) {
					this.seat[i][j].seatNum = (i+1)+"-"+(j+1);
					break;
				}
			}
		}
	}
}