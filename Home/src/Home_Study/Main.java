package Home_Study;

class Product {
	int price;
	int bonus;
	
	Product(int price) {
		this.price = price;
		this.bonus = price/10;
	}
}

class Tv extends Product{
	Tv() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Tv";
	}
}

class Audio extends Product{
	Audio() {
		super(50);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}

class Computer extends Product{
	Computer() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";
	}
}

class Buyer {
	int money;
	int point;
	int totalPay;
	Product[] cart;
	int index;
	
	Buyer() {
		this.money = 1000;
		this.point = 0;
		this.totalPay = 0;
		this.cart = new Product[10];
		this.index = 0;
	}
	
	void buy(Product merchant) {
		if(index>=10) {
			System.out.println("카트가 꽉 찼습니다");
			return;
		}
		cart[index++] = merchant;
	}
	
	void summary() {
		for(int i=0; i<index; i++) {
			this.totalPay += cart[i].price;
			this.point += cart[i].bonus;
			System.out.println((i+1) + ". " + cart[i].toString());
		}
		System.out.println("총 결제 금액은 " + totalPay + "원 입니다");
		System.out.println("총 적립 포인트는 " + point + "원 입니다");
	}
}

class Main {
	public static void main(String[] args) {
		Tv tv = new Tv();
		Audio au = new Audio();
		Computer com = new Computer();
		
		Buyer buy = new Buyer();
		
		buy.buy(com);
		buy.buy(au);
		buy.buy(com);
		buy.buy(tv);
		buy.buy(au);
		buy.buy(com);
		buy.summary();
	}
}