package kor.or.kosa.assignment;

public class Drink_VendingMachine {
	// 고유 데이터
	private boolean drinkBtn; // 음료 버튼
	private boolean returnBtn; // 반환 버튼
	private String color; // 자판기 색상
	private String company;	// 자판기 제작회사
	private int maxMoeny; // 자판기 소지 최대 금액

	// 상태 데이터
	private int currentMoney; // 자판기가 거슬러 줄 수 있는 금액
	private String payState; // 결제 상태
	
	// 부품 데이터
	public Drink drink; // 음료
	public Money money; // 돈
	public Pay pay; // 결제방식
}
