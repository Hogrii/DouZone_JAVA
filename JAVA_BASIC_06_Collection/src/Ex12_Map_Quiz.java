import java.util.HashMap;
import java.util.Scanner;

public class Ex12_Map_Quiz {
	public static void main(String[] args) {
		/*
		 Map을 사용하는 데이터 집합
		 지역번호, 우편번호, 회원가입(id, pwd)
		 */
		
		HashMap loginMap = new HashMap<>(); // 메모리에는 회원 id, 회원 pwd 저장
		loginMap.put("kim", "kim1004");
		loginMap.put("scott", "tiger");
		loginMap.put("lee", "kim1004");
		/*
		 우리 시스템은 회원 가입한 회원의 id, pwd를 관리하고 있다
		 로그인시 id, pwd를 확인해서 회원이라면 사이트 접속 가능
		 
		 id(o), pwd(o) >> 회원님 방가 방가 출력하고 탈출
		 id(o), pwd(x) >> 비밀번호 확인 출력
		 // 아이디가 틀리면 비밀번호는 볼 필요가 없다
		 id(x), pwd(o) >> 아이디가 맞지 않습니다, 재입력하세요
		 id(x), pwd(x) >> 아이디가 맞지 않습니다, 재입력하세요
		 
		 사용자로부터 id, pwd를 입력 받는다
		 id는 공백제거, 소문자로 변환 후 String 변수에 담아서 사용
		 pwd는 공백만 제거
		 */
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("아이디를 입력해주세요 : ");
			String clientId = sc.nextLine().trim().toLowerCase();
			System.out.print("비밀번호를 입력해주세요 : ");
			String clientPwd = sc.nextLine().trim();
			System.out.println();
			
			/*
			if(loginMap.containsKey(clientId) && clientPwd.equals(loginMap.get(clientId))) {
				System.out.println("회원님 방가 방가");
				break;
			}else if(loginMap.containsKey(clientId) && !clientPwd.equals(loginMap.get(clientId))) {
				System.out.println("비밀번호를 확인해주세요");
			}else {
				System.out.println("아이디가 맞지 않습니다, 재입력하세요");
			}
			System.out.println();
			 */
			
			// 교수님 코드
			if(!loginMap.containsKey(clientId)) {
				System.out.println("아이디가 맞지 않습니다, 재입력하세요");
			}else {
				if(loginMap.get(clientId).equals(clientPwd)) {
					System.out.println("회원님 방가 방가");
					break;
				}else {
					System.out.println("비밀번호를 확인해주세요");
				}
			}
		}
	}
}
