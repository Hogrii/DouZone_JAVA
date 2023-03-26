import java.util.Scanner;

public class Menu {
	private int menu;
	private int drink;
	private String moreDrink;
	
	Scanner sc = new Scanner(System.in);
	
	public Menu() {
		this.menu = 0;
		this.drink = 0;
		this.moreDrink = "";
	}
	
	// 메뉴 선택
	public void menuChoice() {
		while (true) {
			try {
				this.menu = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("메뉴 입력이 올바르지 않습니다.");
				System.out.print("다시 입력해주세요 : ");
			}
		}
	}
	
	// 음료 선택
	public void drinkChoice() {
		while (true) {
			try {
				this.drink = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("음료 선택이 올바르지 않습니다.");
				System.out.print("다시 입력해주세요 : ");
			}
		}
	}
	
	// 현재 메뉴
	public int getMenu() {
		return menu;
	}
	
	// 현재 음료
	public int getDrink() {
		return drink;
	}
	
	// 자판기 이용 여부 입력
	public void moreUsing() {
		this.moreDrink = sc.nextLine();
	}
	
	// 자판기 이용 여부 반환
	public String getMoreDrink() {
		return this.moreDrink;
	}
}
