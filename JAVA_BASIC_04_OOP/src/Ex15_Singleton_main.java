import kr.or.kosa.Singleton;

public class Ex15_Singleton_main {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		System.out.println(s1 == s2 && s2 == s3);
	}
}