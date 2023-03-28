package kr.or.kosa.dto;

public class CinemaDisplay {
	CinemaInput input = new CinemaInput();
	
	public void start() {
		System.out.println("***************************");
		System.out.println("********영화 예매 시스템********");
		System.out.println("***************************");
	}
	
	public void menu() {
		System.out.println("1. 예매하기");
		System.out.println();
		System.out.println("2. 예매조회");
		System.out.println();
		System.out.println("3. 예매취소");
		System.out.println();
	}
	
	public void currentSeat(CinemaSeat seat) {
		seat.getSeat();
	}
	
	public String seatReservation() {
		System.out.println("좌석을 선택해주세요. 예)1-1");
		System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
		String seatNum;
		return seatNum = input.seatNum();
	}
	
	public String reservationMenu() {
		System.out.println("예매 가능합니다. 예매하시겠습니까?");
		System.out.println("네(1), 아니오(2), 초기화면(0) 중 하나를 입력해주세요.");
		return input.reservationMenu();
	}
	
	public void reservationSuccess(CinemaSeat seat, String seatNum) {
		System.out.println("예매가 완료되었습니다");
		seat.setSeat(seatNum);
		CinemaTicket ticket = new CinemaTicket(seatNum);
		String ticketNum = ticket.getTicketNum();
		System.out.println("예매된 좌석번호:[" + seatNum + "] / 예매번호:" + ticketNum);
	}
	
	public void getTicketNum() {
		System.out.println("예매조회를 선택하셨습니다.");
		System.out.println("예매번호를 입력해주세요.");
		input.inputTicketNum();
	}
}
