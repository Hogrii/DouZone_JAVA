package kr.or.kosa.dto;

public class CinemaDisplay {
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
		System.out.println("*********좌석 현황**********");
		seat.getPrintSeat(); // 좌석 표
		System.out.println("-------------------------");
	}
	
	public void seatChoice() {
		System.out.println("좌석을 선택해주세요. 예)1-1");
		System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
	}
	
	public void acceptTicket() {
		System.out.println("예매 가능합니다. 예매하시겠습니까?");
		System.out.println("네(1), 아니오(2), 초기화면(0) 중 하나를 입력해주세요.");
	}
	
	public void ticketingSuccess(CinemaSeat seat, String seatNum, CinemaSeat[][] seats) {
		System.out.println("예매가 완료되었습니다");
		seat.setSeatNum(seatNum); // 예매
		int row = seat.getRow(seatNum);
		int col = seat.getCol(seatNum);
		System.out.println("예매된 좌석번호:[" + row+"-"+col + "] / 예매번호:" + seats[row-1][col-1].getTicketNum());
	}
	
	public void checkTicket() {
		System.out.println("예매조회를 선택하셨습니다.");
		System.out.println("예매번호를 입력해주세요.");
	}
	
	public void cancleTicket() {
		System.out.println("예매취소를 선택하셨습니다.");
		System.out.println("예매번호를 입력해주세요.");
	}
	
	public void confirmMySeat(String mySeatNum) {
		System.out.println("고객님이 예매하신 좌석은 " + mySeatNum + "입니다");
	}
	
	public void cancleMenu() {
		System.out.println("예매를 취소하시겠습니까?");
		System.out.println("네(1), 아니오(2) 중 하나를 입력해주세요.");
	}
	
	public void cancleSuccess() {
		System.out.println("예매가 취소되었습니다. 감사합니다.");
	}
	
	public void comebackMenu() {
		System.out.println("메인 메뉴로 돌아갑니다.");
	}
}