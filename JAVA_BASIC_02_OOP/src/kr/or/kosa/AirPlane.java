package kr.or.kosa;
/*
우리 회사는 비행기를 주문 제작 판매하는 회사
우리 회사는 비행기를 생산하는 설계도를 만드려고 한다

요구사항
1. 비행기를 생산하고 비행기의 이름과 번호를 부여해야 한다
2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인하는 작업이 필요(출력)
3. 공장장은 현재까지 만들어진 비행기의 총 누적대수를 확인 할 수 있다

 AirPlane air101 = new AirPlane();
 air101.자원 = 대한항공
 air101.자원 = 707
 */
public class AirPlane {
	private String airPlaneName;
	private int airPlaneNum = 0;
	static private int airPlaneCnt = 0;
	
	public void setAirPlaneNameAndNum(String airPlaneName, int airPlaneNum) {
		this.airPlaneName = airPlaneName;
		this.airPlaneNum = airPlaneNum;
		airPlaneCnt++;
		getAirPlaneDisplay();
	}
	
	public void getAirPlaneDisplay() {
		System.out.println("비행기 번호 : " + airPlaneNum + ", 비행기 이름 : " + airPlaneName);
	}
	
	public void getAirPlaneCnt() {
		System.out.println("현재까지 만들어진 총 누적대수 : " + airPlaneCnt);
	}
}
