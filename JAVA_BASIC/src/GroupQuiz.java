import java.util.Scanner;

public class GroupQuiz {
	public static void main(String[] args) {
		// 가위 , 바위 ,보 게임 또 제어문을 통해서 작성하세요 (IF)
		// 예를 들명)
		// 컴퓨터가 자동으로 나온 가위 , 바위 , 보 에 대해서 사용자가 값을 입력 해서 처리 하세요
		// ( 예를 들면 : 가위=> 1 , 바위 => 2 , 보 => 3)​
		
		Scanner sc = new Scanner(System.in);
		double random = (3 * Math.random() + 1); // 컴퓨터
		System.out.println("computer : " + (int) random);		
		System.out.print("me : ");		
		int me = Integer.parseInt(sc.nextLine()); // 나
		String result = ""; // 결과 입력 변수
		if(me==(int)random) result = "draw"; // 비겼을 때
		if(me==1) result = ((int)random == 2) ? "defeat" : "win";
		else if(me==2) result = ((int)random == 3) ? "defeat" : "win"; 
		else if(me==3) result = ((int)random == 1) ? "defeat" : "win";
		System.out.println("결과 : " + result); // 출력
	}
}
