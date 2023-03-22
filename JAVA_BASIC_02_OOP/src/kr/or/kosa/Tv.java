package kr.or.kosa;
/*
Tv 설계도 요구사항정의
Tv는 채널 정보를 가지고 있다(예, 1~200) -> public
Tv는 브랜드 이름을 가지고 있다(예, 엘지, 삼성) -> public
Tv는 채널 전환 기능을 가지고 있다(한 채널씩 이동)
-> 채널 증가
-> 채널 감소
Tv의 채널정보와 브랜드 이름을 볼 수 있는 기능을 가지고 있다.
 */
public class Tv {
	public int channel;
	public String brand;
	
	public void channelUp() {
		channel++;
	}
	
	public void channelDown() {
		channel--;
	}
	
	public void tvInfo() {
		System.out.print("브랜드 명 : " + brand + " , ");
		System.out.println("현재 채널 : " + channel);
	}
}
