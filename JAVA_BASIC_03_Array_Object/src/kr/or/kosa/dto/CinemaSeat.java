package kr.or.kosa.dto;

public class CinemaSeat {
	private String[][] seat = new String[4][5];

	public CinemaSeat() {
		init();
	}

	public void init() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				this.seat[i][j] = "__"; // 빈 의자 배치
			}
		}
	}
	
	public void getSeat() {
		System.out.println("*********좌석 현황**********");
		for(int i=0; i<seat.length; i++) {
			for(int j=0; j<seat[i].length; j++) {
				System.out.printf("[%s]", seat[i][j].equals("__") ? (i+1)+"-"+(j+1) : "예매");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
	
	public void setSeat(String seatNum) {
		String[] seatNums = seatNum.split("-");
		int row = Integer.parseInt(seatNums[0])-1;
		int col = Integer.parseInt(seatNums[1])-1;
		this.seat[row][col] = "예매";
	}
}