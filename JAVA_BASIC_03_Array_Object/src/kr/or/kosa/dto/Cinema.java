package kr.or.kosa.dto;

public class Cinema {
	public void run() {

		CinemaDisplay display = new CinemaDisplay();
		CinemaInput input = new CinemaInput();
		CinemaSeat seat = new CinemaSeat();

		while (true) {
			display.start();
			display.menu();

			int menu = input.menu();

			if (menu == 1) {
				display.currentSeat(seat);
				String seatNum = display.seatReservation();
				String reservationMenu = display.reservationMenu();
				if (reservationMenu.equals("1")) { // 예매 -> 네
					display.reservationSuccess(seat, seatNum);
				} else if (reservationMenu.equals("2")) { // 예매 -> 아니오
//					display
				} else if (reservationMenu.equals("0")) { // 예매 -> 초기화면

				} else {

				}
			} else if (menu == 2) {

			} else if (menu == 3) {

			} else {

			}
		}
	}
}
