import kr.or.kosa.AirPlane;

public class Ex06_Static_AirPlane {
	public static void main(String[] args) {
		AirPlane air1 = new AirPlane();
		air1.setAirPlaneNameAndNum("대한항공", 101);
		
		AirPlane air2 = new AirPlane();
		air2.setAirPlaneNameAndNum("아시아나", 102);
		air2.getAirPlaneCnt();
	}

}
