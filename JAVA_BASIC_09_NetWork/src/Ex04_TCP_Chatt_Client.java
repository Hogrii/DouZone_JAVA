import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 *	InnerClass(OuterClass 자원을 사용)
 *	InnerClass > ClientSend
 *	InnerClass > ClientReceive 
 */

public class Ex04_TCP_Chatt_Client {
	Socket socket;
	public Ex04_TCP_Chatt_Client() {
		try {
			socket = new Socket("192.168.0.200", 9999);
			System.out.println("Chatt Server와 연결 되었습니다");
			
			new ClientSend().start();
			new ClientReceive().start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Inner class
	class ClientSend extends Thread {
		@Override
		public void run() {
			BufferedReader br = null;
			PrintWriter pw = null;

			try {
				br = new BufferedReader(new InputStreamReader(System.in)); // scanner 대체
				pw = new PrintWriter(socket.getOutputStream(), true); // true : auto flush()

				while (true) {
					String data = br.readLine(); // sc.nextLine()과 같다
					if (data.equals("exit")) break;
					pw.println(data); // 서버에게 메시지 보내기
									// dos.writeUTF(msg)와 같다
				}
				System.out.println("ClientSend 작업 종료");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					pw.close();
					br.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}
	
	// Inner class
	class ClientReceive extends Thread {
		@Override
		public void run() {
			BufferedReader br = null;

			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data = null;

				while ((data = br.readLine()) != null) {
					System.out.println("Server에게 받은 메시지 : " + data);
				}
				System.out.println("ClientReceive 종료");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					br.close();				
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		Ex04_TCP_Chatt_Client client = new Ex04_TCP_Chatt_Client();
	}
}
