
public class Drink {
	int apple;
	int orange;
	int grape;
	int strawberry;
	
	public Drink() {
		this.apple = 2;
		this.orange = 2;
		this.grape = 2;
		this.strawberry = 2;
	}

	public int getApple() {
		return apple;
	}
	
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