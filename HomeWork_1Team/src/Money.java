import java.util.Scanner;

public class Money {
	private int money;
	
	Scanner sc = new Scanner(System.in);
	Price price = new Price();
	
	// 금액 입력
	public void inputMoney() {
		while (true) {
			try {
				this.money += Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("금액이 올바르지 않습니다");
				System.out.print("다시 입력해주세요 : ");
			}
		}
	}
	
	// 금액 추가
	public void addMoney() {
		this.money += Integer.parseInt(sc.nextLine());
	}
	
	// 현재 금액
	public int getMoney() {
		return money;
	}
	
	// 음료 계산
	public void calMoney(int drinkChoice) {
		switch(drinkChoice) {
		case 1:
			this.money -= price.getApplePrice();
			break;
		case 2:
			this.money -= price.getOrangePrice();
			break;
		case 3:
			this.money -= price.getGrapePrice();
			break;
		case 4:
			this.money -= price.getStrawberryPrice();
			break;
		
		}
	}
}
