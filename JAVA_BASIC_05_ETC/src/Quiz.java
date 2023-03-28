import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호 : ");
		String jumin = sc.nextLine();
		
		// 1.
		boolean length = isValidLength(jumin);
		System.out.println(length);

		// 2.
		String backNum = jumin.split("-")[1];
		boolean acceptNum = isAcceptNum(backNum);
		System.out.println(acceptNum);
		
		// 3.
		confirmGender(backNum);
	}
	
	public static boolean isValidLength(String jumin) {
		return jumin.length() == 14 ? true : false;
	}
	
	public static boolean isAcceptNum(String backNum) {
		int firstNum = Integer.parseInt(backNum.substring(0,1));
		return firstNum>0 && firstNum<5 ? true : false;
	}
	
	public static void confirmGender(String backNum) {
		int firstNum = Integer.parseInt(backNum.substring(0,1));
		String gender = firstNum==1 || firstNum==3 ? "man" : "woman";
		System.out.println(gender);
	}
}
