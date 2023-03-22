import kr.or.kosa.Tv;

public class Ex03_Ref_Method_Call {
	public static void main(String[] args) {
		// Tv 만들기 >> heap 메모리에 생성하라는 의미
		
		Tv lgtv = new Tv();
		lgtv.brand = "LG";
		lgtv.tvInfo();
		lgtv.channelUp();
		lgtv.channelUp();
		lgtv.channelUp();
		lgtv.tvInfo();
		
		lgtv.channelDown();
		lgtv.tvInfo();
		
		Tv sstv = new Tv();
		sstv.brand = "SS";
		
		Tv ktv = sstv; // 같은 주소(동거) >> 여기까지 객체의 수는 2개
	}
}
