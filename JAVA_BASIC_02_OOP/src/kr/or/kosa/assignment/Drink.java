package kr.or.kosa.assignment;

public class Drink {
	private String drinkType; // 음료 종류
	private int drinkCnt = 10; // 음료 수량
	private int drinkPrice; // 음료 가격
	private boolean drinkHead; // 음료 뚜껑
	private String drinkBody; // 음료 재질
	
	public void existDrinkCnt() {
		if(drinkCnt <= 0) System.out.println("음료 없음"); // 남은 음료가 0개
		else {
			drinkCnt--; // 남은 음료가 1개 이상
			getDrinkType();
		}
	}
	
	public void getDrinkType() {
		System.out.println(drinkType + " 음료 줄게");
	}
	
	public int getDrinkPrice() {
		return drinkPrice;
	}
}
