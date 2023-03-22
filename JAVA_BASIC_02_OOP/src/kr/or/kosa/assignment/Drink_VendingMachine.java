package kr.or.kosa.assignment;

public class Drink_VendingMachine {
	// 고유 데이터
	private boolean drinkBtn; // 음료 버튼
	private boolean returnBtn; // 반환 버튼
	private String color; // 자판기 색상
	private String company;	// 자판기 제조회사

	// 상태 데이터
	private int inputMoney; // 사용자가 자판기에 넣은 금액
	private boolean payState; // 결제 상태
	
	// 부품 데이터
	public Drink drink = new Drink(); // 음료
	
	// 기능
	public void onClickDrinkBtn() { // 음료 버튼이 눌렸을 때, 음료를 반환
		isCardOrMoney(); // 카드인지 현금인지 판단
		drink.existDrinkCnt();
	}
	
	public int onClickReturnBtn() { // 반환 버튼이 눌렸을 때, 잔액을 반환
		return inputMoney;
	}
	
	public void isCardOrMoney() {
		if(!payState) { // true -> 카드 결제
			inputMoney -= drink.getDrinkPrice(); // 현금 결제
		}
	}
}
