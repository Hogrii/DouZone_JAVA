package kr.or.kosa;
/*
디자인 패턴(생성에 관련된 이야기) >> new

싱글톤 : 객체 하나를 만들어서 공유
의도 : 하나의 객체를 공유하는 보장성 코드를 만들어라

공유프린터
공유 ip

Singleton s = new Singleton();
Singleton s2 = new Singleton();
Singleton s3 = new Singleton();
 >> heap에 싱글톤 객체 3개가 생성
 */

public class Singleton {
	private static Singleton p;
	public static Singleton getInstance() {
		if(p==null) {
			p = new Singleton(); // 같은 클래스 내부에서는 public, private 모두 사용 가능
		}
		return p; // p는 클래스 에어리어에 있기 때문에 항상 같은 주소를 부종한다
	}
	
	private Singleton() {
		// 생성자 접근자 >> private
		// 생성자 호출을 하지 못하게 막았다 >> 객체를 new 할 수가 없다
	}
}
