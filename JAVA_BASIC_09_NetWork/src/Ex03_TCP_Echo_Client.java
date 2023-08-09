import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ex03_TCP_Echo_Client {
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("192.168.0.200", 9999);
		System.out.println("서버와 연결되었츄!!");
		
		// read
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		// write
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("서버에 전송할 내용을 입력하시츄!! : ");
			String msg = sc.nextLine();
			
			// 서버 전송
			dos.writeUTF(msg);
			dos.flush();
			
			if(msg.equals("exit")) break;
			
			// 서버로부터 전달 받은 메시지
			String serverMsg = dis.readUTF();
			System.out.println("메아리가 오츄!! : " + serverMsg);
		}
		System.out.println("클라이언트를 종료하겠츄!!");
		
		dis.close();
		dos.close();
		socket.close();
	}
}
