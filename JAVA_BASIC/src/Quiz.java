public class Quiz {
	public static void main(String[] args) {
		// 3.17(금요일) 퀴즈
		// https://cafe.naver.com/erpzone?iframe_url=/MyCafeIntro.nhn%3Fclubid=30938434
		
		// 풀이
		// 점수 뽑기
		int score = ((int)(Math.random()*10) + 1)*100;
		
		// 경품
		String str = "";
		
		// 점수에 따른 경품
		switch(score) {
			case 1000: str += "TV, ";
			case 900: str += "NoteBook, ";
			case 800: str += "냉장고, ";
			case 700: str += "한우세트, ";
			case 600: str += "휴지";
				break;
			default : str = "칫솔";
		}
		
		// 점수
		System.out.println("점수 : " + score);
		// 당첨 경품
		System.out.println("상품은 " + str + "입니다.");
	}
}
