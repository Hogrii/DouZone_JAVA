/*
문제 풀어 보세요 ^^
요구사항
 >> 매장카트 구현하기 입니다 <<
카트 (Cart) >> member field
카트 매장에 있는 [모든 전자제품]을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... [카트에 담는다]
---------------------------------------
계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy() 함수안에서 cart  담는 것을 구현 )
hint) Buyer ..>> summary()  main 함수에서 계산할때  사용합니다

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다

*/

class Product2{  //extends Object
	int price;
	int bonuspoint;
	
	//Product() {	}
	Product2(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
	
}

class KtTv2 extends Product2{
	KtTv2(){
		super(500);
	}
	
	//Object 재정의 
	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2 extends Product2{
	Audio2(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio2";
	}
}

class NoteBook2 extends Product2{
	NoteBook2(){
		super(150);
	}
	
	@Override
	public String toString() {
		return "NoteBook2";
	}
}

//구매자
class Buyer2{
	int money;
	int bonusPoint;
	int totalPayMoney;
	Product2[] cart; // 다형성.. 모든 제품을 담을 수 있다.. >> 단, 모든 제품은 Product2를 상속해야 한다.
	int index;

	Buyer2() {
		this.money = 5000;
		this.bonusPoint = 0;
		this.totalPayMoney = 0;
		this.cart = new Product2[10];
		this.index = 0;
	}
	
	void Buy(Product2 n) { 
		// 카트에 물건 담기
		if(index>=10) {
			System.out.println("카트가 가득 담겼습니다");
			return;
		}
		cart[this.index++] = n;
		this.totalPayMoney += n.price;
		this.bonusPoint += n.bonuspoint;
	}
	
	void summary() { // 카트에 있는 물건을 계산 >> 구매한 물건의 총액, 포인트 총액, 구매한 물건 리스트
		System.out.println("구매한 물건 리스트");	
		for(int i=0; i<index; i++) {
			System.out.println((i+1) + ". " + cart[i].toString());
		}
		System.out.println("구매한 물건의 총액 : " + this.totalPayMoney);
		System.out.println("포인트 총액 : " + this.bonusPoint);
	}
}

public class Ex13_Inherit_KeyPoint {
	public static void main(String[] args) {
		// 가오픈 생각.. 
		// 상품 진열
		KtTv2 kt2 = new KtTv2();
		Audio2 audio2 = new Audio2();
		NoteBook2 notebook2 = new NoteBook2();
		
		// 구매자
		Buyer2 buyer2 = new Buyer2();
		
		buyer2.Buy(kt2);
		buyer2.Buy(kt2);
		buyer2.Buy(kt2);
		buyer2.Buy(audio2);
		buyer2.Buy(audio2);
		buyer2.Buy(audio2);
		buyer2.Buy(audio2);
		buyer2.Buy(audio2);
		buyer2.Buy(notebook2);
		buyer2.Buy(notebook2);
		buyer2.Buy(notebook2);
		buyer2.summary();
	}
}
