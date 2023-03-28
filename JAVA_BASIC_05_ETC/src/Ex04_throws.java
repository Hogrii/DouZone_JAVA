import java.io.IOException;

import kr.or.kosa.utils.ExClass;

public class Ex04_throws {
	public static void main(String[] args) {
		/*
		try {
			ExClass ex = new ExClass("Temp");
		} catch (NullPointerException | IOException e1) {
			e1.printStackTrace();
		}
		 */
		
		try {
			ExClass ex = new ExClass("Temp");
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
