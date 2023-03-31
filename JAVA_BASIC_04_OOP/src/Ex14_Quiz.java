
class Ssystem {
	public static final print oout;
	
	static { // static 초기화를 이용해서 Ssystem을 new하지 않아도 사용 가능
		oout = new print();
	}
}

class print {
	void pprintln(byte x) { System.out.println(x);}
	void pprintln(boolean x) { System.out.println(x);}
	void pprintln(short x) { System.out.println(x);}
	void pprintln(int x) { System.out.println(x);}
	void pprintln(long x) { System.out.println(x);}
	void pprintln(float x) { System.out.println(x);}
	void pprintln(double x) { System.out.println(x);}
}

public class Ex14_Quiz {
	public static void main(String[] args) {
		System.out.println("이건 어떻게 구현된 함수 일까요");
		
		// System
		// out
		// println을 구현해보자
		
		Ssystem.oout.pprintln(0);

	}
}
