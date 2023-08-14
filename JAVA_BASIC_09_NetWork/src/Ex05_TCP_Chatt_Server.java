import java.io.DataInputStream;
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
			while (true) {
				socket = serverSocket.accept();
				System.out.println("접속자의 주소 : " + socket.getInetAddress());
				System.out.println("접속자의 포트 : " + socket.getPort());

				// 원하는 코드 작업

				// 클라이언트가 접속할때마다 스레드 생성
				// Thread client = new socket 생성자로 클라이언트 생성
				// Thread start()
				Thread client = new MultiServerRev(socket);
				client.start();
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
		while (clientKeySet.hasNext()) {
			try {
				DataOutputStream clientOut = clientMap.get(clientKeySet.next());
				// clientMap.get key가 가지고 있는 value(각각의 socket이 얻은 DataOutputStream 객체의 주소값)

				// 각각의 Client에게 메시지 전달하기
				clientOut.writeUTF(msg);
			} catch (Exception e) {
				System.out.println("sendAllMsg : " + e.getMessage());
			}
		}
	}

	// 3. 접속된 모든 유저 리스트 목록 관리하기
	public String showUserList(String name) {
		StringBuilder output = new StringBuilder("<<접속자 목록>>\n\r"); // \n\r : 개행처리, enter
		Iterator<String> users = clientMap.keySet().iterator();

		while (users.hasNext()) {
			try {
				String key = users.next(); // 접속한 Id : lee, hong
				if (key.equals(name)) { // 목록을 요청한 사용자라면!
					key += "(*)";
				}
				output.append(key + "\n\r");
			} catch (Exception e) {
				System.out.println("showUserList method : " + e.getMessage());
			}
		}
		return output.toString();
	}

	// 4. 옵션
	// 귓속말 옵션(특정 유저에게만 메시지 전송)
	public void sendToUser(String fromname, String toname, String msg) {
		try {
			clientMap.get(toname).writeUTF("<귓속말 from " + fromname + "> : " + msg);
			// clientMap.get(toname) >> socket이 가지는 DataOutputStream 주소값
			clientMap.get(fromname).writeUTF("<귓속말 to " + toname + "> : " + msg);
		} catch (Exception e) {
			System.out.println("sendToUser : " + e.getMessage());
		}
	}

	// Thread 사용(보내기, 받기)
	// inner Class 형태
	class MultiServerRev extends Thread {
		Socket socket = null;
		DataInputStream in;
		DataOutputStream out;

		public MultiServerRev(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(this.socket.getInputStream());
				out = new DataOutputStream(this.socket.getOutputStream());
			} catch (Exception e) {
				System.out.println("MultiServerRev : " + e.getMessage());
			}
		}

		@Override
		public void run() {
			// read(readUTF()), write(writeUTF())
			String name = ""; // 클라이언트 이름(id) 저장
			try {
				// 연결된 socket을 통해서 client 메시지 전달
				out.writeUTF("이름을 입력하세요");
				name = in.readUTF();
				out.writeUTF("현재 채팅방에 입장하셨습니다"); // 현재 1개의 채팅방..

				// 채팅방 10명 user 접속
				// 서버에 접속된 모든 사용자(socket) 입력된 내용 전달
				sendAllMsg(name + "님이 입장하셨습니다"); // 10개의 socket에 전달

				// Key Point
				// 현재 접속한 socket도 관리(Map)
				clientMap.put(name, out); // Map("김씨", socket 출력 객체 주소)
				System.out.println("------ 서버 모니터링 ------");
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명");

				// 추가기능(대화)
				while (in != null) {
					String msg = in.readUTF();

					// 채팅방에 참여하고 있는 모든 접속자에게 전달
					if (msg.startsWith("/")) {
						if (msg.trim().equals("/접속자")) {
							// 접속한 사용자 목록
							out.writeUTF(showUserList(name));
						} else if (msg.startsWith("/귓속말")) {
							String[] msgArr = msg.split(" ", 3);
							// /귓속말 홍길동 방가방가
							if (msgArr == null || msgArr.length < 3) {
								// 옵션이 정상적이지 않을 경우
								out.writeUTF("HELP : 사용법 \n\r /귓속말 [상대방ID] [메시지]");
							} else {
								String toName = msgArr[1];
								String toMsg = msgArr[2];
								if (clientMap.containsKey(toName)) {
									// map 안에 Id가 존재하면
									// 특정 상대방에게 메시지 보내기
									sendToUser(name, toName, toMsg);
								} else {
									out.writeUTF("입력한 사용자가 없습니다 ..");
								}
							}
						} else {
							out.writeUTF("잘못된 명령어입니다.");
						}
					} else {
						// 전체 사용자에게 write
						sendAllMsg("<" + name + "> : " + msg);
					}
				} // while End
			} catch (Exception e) {
				System.out.println("Thread run : " + e.getMessage());
			} finally {
				// Client(종료) 퇴장
				clientMap.remove(name);
				sendAllMsg(name + "님이 퇴장하셨습니다");
				System.out.println("------ 서버 모니터링 ------");
				System.out.println("Finally : " + clientMap.size() + "명");
			}
		}
	}

	public static void main(String[] args) {
		Ex05_TCP_Chatt_Server server = new Ex05_TCP_Chatt_Server();
		server.init();
	}
}
