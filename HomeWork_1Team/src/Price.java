
public class Price {
	private int applePrice;
	private int orangePrice;
	private int grapePrice;
	private int strawberryPrice;
	
	// 음료 가격 선정
	public Price() {
		this.applePrice = 500;
		this.orangePrice = 600;
		this.grapePrice = 800;
		this.strawberryPrice = 1000;
	}
	
	// 음료 가격 반환
	public int getApplePrice() {
		return applePrice;
	}
	
	public int getOrangePrice() {
		return orangePrice;
	}
	
	public int getGrapePrice() {
		return grapePrice;
	}
	
	public int getStrawberryPrice() {
		return strawberryPrice;
	}
}
