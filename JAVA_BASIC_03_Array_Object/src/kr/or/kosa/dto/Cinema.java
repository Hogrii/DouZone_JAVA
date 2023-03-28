package kr.or.kosa.dto;

public class Cinema {
	public void run() {
		CinemaDisplay display = new CinemaDisplay();
		CinemaInput input = new CinemaInput();
		CinemaSeat seat = new CinemaSeat();
		
		CinemaSeat[][] seats = seat.getSeat();		
		while (true) {
			display.start();
			display.menu();

			int menu = input.menu(); // 메뉴
			if (menu == 1) { // 예매하기
				display.currentSeat(seat);
				display.seatChoice();
				String seatNum = input.seatNum();
				display.acceptTicket();
				String reservationMenu = input.reservationMenu();
				if (reservationMenu.equals("1")) { // 예매 -> 네
					display.ticketingSuccess(seat, seatNum, seats);
				} else if (reservationMenu.equals("2")) { // 예매 -> 아니오
					
				} else if (reservationMenu.equals("0")) { // 예매 -> 초기화면

				} else {

				}
			} else if (menu == 2) { // 예매조회
				display.checkTicket();
				String ticketNum = input.inputTicketNum();
				String mySeatNum = seat.getMySeatNum(ticketNum);
				display.confirmMySeat(mySeatNum);
			} else if (menu == 3) { // 예매취소
				display.cancleTicket();
				String ticketNum = input.inputTicketNum();
				String mySeatNum = seat.getMySeatNum(ticketNum);
				display.confirmMySeat(mySeatNum);
				display.cancleMenu();
				String cancleMenu = input.cancleMenu();
				if(cancleMenu.equals("1")) { // 취소 -> 네
					display.cancleSuccess();
					seat.cancleMySeat(ticketNum);
				}else if(cancleMenu.equals("2")) { // 취소 -> 아니오
					display.comebackMenu();
				}
			} else {

			}
		}
	}
}
