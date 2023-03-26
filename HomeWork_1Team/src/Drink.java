
public class Drink {
	private int apple;
	private int orange;
	private int grape;
	private int strawberry;
	
	// 음료 최대 개수
	public Drink() {
		this.apple = 2;
		this.orange = 2;
		this.grape = 2;
		this.strawberry = 2;
	}

	// 음료 반환
	public int getApple() {
		return apple;
	}
	
	// 음료 판매
	public void soldApple() {
		this.apple--;
	}
	
	public int getOrange() {
		return orange;
	}
	
	public void soldOrange() {
		this.orange--;
	}
	
	public int getGrape() {
		return grape;
	}
	
	public void soldGrape() {
		this.grape--;
	}
	
	public int getStrawberry() {
		return strawberry;
	}
	
	public void soldStrawberry() {
		this.strawberry--;
	}
}