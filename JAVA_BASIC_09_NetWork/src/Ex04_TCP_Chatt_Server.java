import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 	Ex01 ~ Ex03은 하나의 Thread 가지고 작업(순차적 데이터 처리)
 * 
 *  Server : read, write
 *  Client : read, write
 *  read, write가 동시에 처리되지 않았다
 *  
 *  read, write를 동시에 .. >> Thread
 *  
 *  stack을 여러개 사용해서 작업 >> 1:1 통신(Server, Client간)
 *  read, write를 동시에 처리
 */

public class Ex04_TCP_Chatt_Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("접속 대기 중 ....");
			Socket socket = serverSocket.accept();
			System.out.println("Client 연결 완료");

			// 기존코드
			// read
			// InputStream in = socket.getInputStream();
			// DataInputStream dis = new DataInputStream(in);

			new ServerSend(socket).start();
			new ServerReceive(socket).start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

// write 전용 Thread
// socket >> OutputStream
class ServerSend extends Thread {
	Socket socket;

	public ServerSend(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// 기존코드
		// read
		// InputStream in = socket.getInputStream();
		// DataInputStream dis = new DataInputStream(in);

		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in)); // scanner 대체
			pw = new PrintWriter(socket.getOutputStream(), true);

			while (true) {
				String data = br.readLine(); // sc.nextLine()과 같다
				if (data.equals("exit"))
					break;
				pw.println(data); // 접속한 클라이언트에게 메시지 보내기
								// dos.writeUTF(msg)와 같다
			}
			System.out.println("ServerSend 작업 종료");
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

// read 전용 Thread
// socket : InputStream
class ServerReceive extends Thread {
	Socket socket;

	public ServerReceive(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = null;

			while ((data = br.readLine()) != null) {
				System.out.println("Client에게 받은 메시지 : " + data);
			}
			System.out.println("ServerReceive 종료");
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
