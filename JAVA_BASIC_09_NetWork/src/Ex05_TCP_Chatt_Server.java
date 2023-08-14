import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * 서버 1개
 * 여러명의 Client가 하나의 서버에 접속 : 채팅방 1개 가정
 * KEY POINT : HashMap > Key : 사용자 ID, Value : socket 객체 주소
 * 
 *  여러개의 채팅방 : 어떤 Collection~?
 *  
 *  ArrayList<HashMap> ...
 *  [0] 방번호 > HashMap
 *  
 *  HashMap<k,List> > Key : 방번호, Value : ArrayList 주소(socket 배열) 
 */

public class Ex05_TCP_Chatt_Server {
	ServerSocket serverSocket = null;
	Socket socket = null;
	
	// Today Point
	// Map
	Map<String, DataOutputStream> clientMap;
	// DataOutputStream : socket이 가지고 있는 Stream의 주소값
	
	// Map<String, DataOutputStream>
	// jhlee, Socket
	// hong, Socket
	
	public Ex05_TCP_Chatt_Server() {
		clientMap = new HashMap<>(); // 각각의 socket이 가지는 출력 객체의 주소 관리
	}
	
	// 1. 서버 초기화 작업
	public void init() {
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버 시작! 요청 대기 중..");
			while(true) {
				socket = serverSocket.accept();
				System.out.println("접속자의 주소 : " + socket.getInetAddress());
				System.out.println("접속자의 포트 : " + socket.getPort());
				
				// 원하는 코드 작업
				
				// 클라이언트가 접속할때마다 스레드 생성
				// Thread client = new
				// Thread start()
			}
		} catch (Exception e) {
			System.out.println("Init() : " + e.getMessage());
		}
	}
	
	// 2. 접속된 모든 클라이언트(socket)에게 메시지를 전달하고 싶다
	// Map<Key, Value>
	// Key : 사용자 Id(고유값), Value : socket 객체 주소
	// ClientMap<jhlee, 각각의 socket 객체로부터 얻어낸 DataOutputStream의 주소값>
	// ClientMap<hong, 각각의 socket 객체로부터 얻어낸 DataOutputStream의 주소값>
	public void sendAllMsg(String msg) {
		Iterator<String> clientKeySet = clientMap.keySet().iterator(); // 클라이언트의 key값 빼오기
		while(clientKeySet.hasNext()) {
			try {
				DataOutputStream clientOut = clientMap.get(clientKeySet.next());
				
				// 각각의 Client에게 메시지 전달하기
				clientOut.writeUTF(msg);
			} catch (Exception e) {
				System.out.println("sendAllMsg : " + e.getMessage());
			}
		}
	}
	
	// 3. 접속된 모든 유저 리스트 목록 관리하기
	public String showUserList(String name) {
		return null;
	}
	
	// 4. 옵션
	// 귓속말 옵션(특정 유저에게만 메시지 전송)
	public void sendToUser(String fromname, String toname, String msg) {
		
	}
	
	// Thread 사용(보내기, 받기)
	// inner Class 형태
	class MultiServerRev extends Thread {
		@Override
		public void run() {
			
		}
	}
	
	public static void main(String[] args) {
		Ex05_TCP_Chatt_Server server = new Ex05_TCP_Chatt_Server();
		server.init();
	}
}
