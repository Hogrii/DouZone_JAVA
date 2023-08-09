import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP 서버
 * 현재 실행되고 있는 프로세스(서버)와 프로세스(클라이언트) 연결
 * 
 * 서버 192.168.0.172
 */

public class Ex02_TCP_Server {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("접속 대기중이츄 ...");
		Socket socket = serverSocket.accept(); // 클라이언트 요청이 오면 접속
		System.out.println("클라이언트가 접속했츄!"); // 소켓과 소켓이 연결
		
		// 연결
		// 서버 : 클라이언트(read, write)
		// 소켓과 소켓 -> TCP를 통해..
		// 소켓 (input, output stream)
		
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos =new DataOutputStream(out);
		dos.writeUTF("진호의 PC !!");
		
		System.out.println("서버를 종료하겠츄!");
		
		// 자원 해제
		dos.close();
		out.close();
		socket.close();
		serverSocket.close();
	}
}
