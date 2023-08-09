import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex03_TCP_Echo_Server {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("접속 대기중이츄 ....");
		Socket socket = serverSocket.accept();
		System.out.println("연결 완료되었츄 !!");
		
		/*
		 * Client server로 write 데이터를 server가 받아서 그대로 다시 Client에게 전송
		 * Server : read, write
		 * Client : write, read
		 * 
		 * 생성한 socket으로부터 input, output stream을 모두 얻어야 한다
		 */
		
		// read
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		// write
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		while(true) {
			String clientMsg = dis.readUTF();
			System.out.println("클라이언트가 보냈츄!! : " + clientMsg);
			
			if(clientMsg.equals("exit")) break;
			
			// Echo(메아리)
			dos.writeUTF(clientMsg);
			dos.flush(); // close() 해도 되는데 바로바로 내용을 던질거라서 flush()를 쓰겠다
		}
		System.out.println("클라이언트가 서버 종료 요청(exit)을 보냈츄!!");
		System.out.println("자원들을 종료하겠츄!!");
		dos.close();
		out.close();
		dis.close();
		in.close();
		socket.close();
		serverSocket.close();
	}
}
