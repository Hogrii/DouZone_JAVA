import kr.or.kosa.AirPlane;

public class Ex06_Static_AirPlane {
	public static void main(String[] args) {
		/*
		AirPlane air1 = new AirPlane();
		air1.setAirPlaneNameAndNum("대한항공", 101);
		
		AirPlane air2 = new AirPlane();
		air2.setAirPlaneNameAndNum("아시아나", 102);
		air2.getAirPlaneCnt();
		
		// AirPlane.airPlaneCnt -> static도 private이면 접근불가
		 */
		
		AirPlane air1 = new AirPlane(101, "대한항공");
		air1.getAirPlaneDisplay();
		air1.getAirPlaneCnt();
		
		AirPlane air2 = new AirPlane(102, "아시아나");
		air2.getAirPlaneDisplay();
		air2.getAirPlaneCnt();
	}
}
