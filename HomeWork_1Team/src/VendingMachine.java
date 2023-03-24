import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		int money = 0;
		int menu;
		int drinkChoice;
		String moreDrink;

		Scanner sc = new Scanner(System.in);
		Drink drink = new Drink();
		
		while (true) {
			System.out.println("*******자판기*******");
			if(money < 1000) { 
				System.out.print("금액을 넣어주세요 : ");
				while (true) {
					try {
						money += Integer.parseInt(sc.nextLine()); // 금액 입력
						break;
					} catch (Exception e) {
						System.out.println("금액이 올바르지 않습니다");
						System.out.print("다시 입력해주세요 : ");
					}
				}
				System.out.println(money + "원을 넣으셨습니다");
			}
			System.out.println("현재 금액 : " + money + "원");
			System.out.println("******************");
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 음료 뽑기");
			System.out.println("2. 금액 추가");
			System.out.println("3. 현재 금액 확인");
			System.out.println("4. 동전 반환");
			System.out.print("메뉴 선택 : ");
			while (true) {
				try {
					menu = Integer.parseInt(sc.nextLine()); // 메뉴 선택
					break;
				} catch (Exception e) {
					System.out.println("메뉴 입력이 올바르지 않습니다.");
					System.out.print("다시 입력해주세요 : ");
				}
			}
			System.out.println();

			if (menu == 1) { // 음료 뽑기
				System.out.println("***구매하실 음료를 선택해주세요***");
				System.out.println("1. 사과맛(500원) : " + drink.getApple() + "개 남았습니다");
				System.out.println("2. 오렌지맛(600원) : " + drink.getOrange() + "개 남았습니다");
				System.out.println("3. 포도맛(800원) : " + drink.getGrape() + "개 남았습니다");
				System.out.println("4. 딸기맛(1000원) : " + drink.getStrawberry() + "개 남았습니다");
				System.out.print("음료 선택 : ");
				while (true) {
					try {
						drinkChoice = Integer.parseInt(sc.nextLine()); // 음료 선택
						break;
					} catch (Exception e) {
						System.out.println("음료 선택이 올바르지 않습니다.");
						System.out.print("다시 입력해주세요 : ");
					}
				}
				dc : if (drinkChoice == 1) { // 사과맛 음료
					System.out.println("사과맛 음료를 선택하셨습니다.");
					if((money-500)<0) { // 소지금 부족
						System.out.println("잔액이 부족합니다");
						continue;
					}else {		
						if(drink.getApple()!=0) { // 구매 완료
							drink.soldApple();
							money -= 500;
						}else { // 재고 없음
							System.out.println("사과맛 음료 재고가 없습니다"); 
							System.out.println("다른 음료를 선택해주세요");
							break dc;
						}						
					}
					System.out.println("이용해주셔서 감사합니다.");
					System.out.print("자판기를 더 이용하시겠습니까?(Y/N) : ");
					while (true) {
						try {
							moreDrink = sc.nextLine(); // 자판기 이용 여부
							break;
						} catch (Exception e) {
							System.out.println("입력이 잘못되었습니다.");
							System.out.println("다시 입력해주세요 : ");
						}						
					}
					if(moreDrink.equals("Y")) {
						System.out.println("Y를 선택하셨습니다.");
						System.out.println("메뉴로 돌아갑니다");
						break dc;
					}else if(moreDrink.equals("N")){
						System.out.println("N을 선택하셨습니다.");
						System.out.print("잔돈 " + money + "원을 챙겨주세요! : ");
						break;
					}else {
						System.out.println("입력이 잘못되었습니다.");
						System.out.println("초기화면으로 돌아갑니다");
					}
				} else if (drinkChoice == 2) { // 오렌지 음료
					System.out.println("오렌지맛 음료를 선택하셨습니다.");
					if((money-600)<0) { // 소지금 부족
						System.out.println("잔액이 부족합니다");
						continue;
					}else {
						if(drink.getOrange()!=0) { // 구매 완료
							drink.soldOrange();
							money -= 600;
						}else { // 재고 없음
							System.out.println("오렌지맛 음료 재고가 없습니다"); 
							System.out.println("다른 음료를 선택해주세요");
							break dc;
						}	
					}
					System.out.println("이용해주셔서 감사합니다.");
					System.out.print("자판기를 더 이용하시겠습니까?(Y/N) : ");
					while (true) {
						try {
							moreDrink = sc.nextLine(); // 자판기 이용 여부
							break;
						} catch (Exception e) {
							System.out.println("입력이 잘못되었습니다.");
							System.out.println("다시 입력해주세요 : ");
						}						
					}
					if(moreDrink.equals("Y")) {
						System.out.println("Y를 선택하셨습니다.");
						System.out.println("메뉴로 돌아갑니다");
						break dc;
					}else if(moreDrink.equals("N")){
						System.out.println("N을 선택하셨습니다.");
						System.out.print("잔돈 " + money + "원을 챙겨주세요! : ");
						break;
					}else {
						System.out.println("입력이 잘못되었습니다.");
						System.out.println("초기화면으로 돌아갑니다");
					}
				} else if (drinkChoice == 3) { // 포도맛 음료
					System.out.println("포도맛 음료를 선택하셨습니다.");
					if((money-800)<0) { // 소지금 부족
						System.out.println("잔액이 부족합니다");
						continue;
					}else {
						if(drink.getGrape()!=0) { // 구매 완료
							drink.soldGrape();
							money -= 800;
						}else { // 재고 없음
							System.out.println("포도맛 음료 재고가 없습니다"); 
							System.out.println("다른 음료를 선택해주세요");
							break dc;
						}	
					}
					System.out.println("이용해주셔서 감사합니다.");
					System.out.print("자판기를 더 이용하시겠습니까?(Y/N) : ");
					while (true) {
						try {
							moreDrink = sc.nextLine(); // 자판기 이용 여부
							break;
						} catch (Exception e) {
							System.out.println("입력이 잘못되었습니다.");
							System.out.println("다시 입력해주세요 : ");
						}						
					}
					if(moreDrink.equals("Y")) {
						System.out.println("Y를 선택하셨습니다.");
						System.out.println("메뉴로 돌아갑니다");
						break dc;
					}else if(moreDrink.equals("N")){
						System.out.println("N을 선택하셨습니다.");
						System.out.print("잔돈 " + money + "원을 챙겨주세요! : ");
						break;
					}else {
						System.out.println("입력이 잘못되었습니다.");
						System.out.println("초기화면으로 돌아갑니다");
					}
				} else if (drinkChoice == 4) { // 딸기맛 음료
					System.out.println("딸기맛 음료를 선택하셨습니다.");
					if((money-1000)<0) { // 소지금 부족
						System.out.println("잔액이 부족합니다");
						continue;
					}else {
						if(drink.getStrawberry()!=0) { // 구매 완료
							drink.soldStrawberry();
							money -= 1000;
						}else { // 재고 없음
							System.out.println("딸기맛 음료 재고가 없습니다"); 
							System.out.println("다른 음료를 선택해주세요");
							break dc;
						}	
					}
					System.out.println("이용해주셔서 감사합니다.");
					System.out.print("자판기를 더 이용하시겠습니까?(Y/N) : ");
					while (true) {
						try {
							moreDrink = sc.nextLine(); // 자판기 이용 여부
							break;
						} catch (Exception e) {
							System.out.println("입력이 잘못되었습니다.");
							System.out.println("다시 입력해주세요 : ");
						}						
					}
					if(moreDrink.equals("Y")) {
						System.out.println("Y를 선택하셨습니다.");
						System.out.println("메뉴로 돌아갑니다");
						break dc;
					}else if(moreDrink.equals("N")){
						System.out.println("N을 선택하셨습니다.");
						System.out.print("잔돈 " + money + "원을 챙겨주세요! : ");
						break;
					}else {
						System.out.println("입력이 잘못되었습니다.");
						System.out.println("초기화면으로 돌아갑니다");
					}
				} else {
					System.out.println("음료를 잘못 입력하셨습니다.");
					System.out.println("초기화면으로 돌아갑니다");
				}
			} else if (menu == 2) { // 금액 추가
				System.out.println("금액 추가를 선택하셨습니다.");
				System.out.print("충전하실 금액을 입력해주세요 : ");
				money += Integer.parseInt(sc.nextLine());
			} else if (menu == 3) { // 현재 금액 확인
				System.out.println("입력하신 사용할 수 있는 금액은 : " + money + "원 입니다");
				System.out.println();
			} else if (menu == 4) { // 동전 반환
				System.out.println("동전 반환을 선택하셨습니다.");
				System.out.println(money + "원을 챙겨주세요");
				System.out.println();
				System.exit(0);
			} else { // 잘못된 입력 -> 초기 화면
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				System.out.println("초기화면으로 돌아갑니다");
			}
		}
	}
}