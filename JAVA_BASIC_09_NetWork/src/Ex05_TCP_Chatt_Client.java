import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

//J가 붙는건 Java swing 자원,, 순수 Java 코드로 만든 어플리케이션
public class Ex05_TCP_Chatt_Client extends JFrame implements ActionListener, Runnable {
	JTextArea txtArea; // 출력창(다중라인)
	JTextField txtInput; // 채팅 내용 입력창
	DataInputStream in;
	DataOutputStream out;

	public Ex05_TCP_Chatt_Client() {
		// 초기화
		// UI 구성
		this.setTitle("Multi 채팅");
		txtArea = new JTextArea(); // 출력창
		txtInput = new JTextField(); // 입력창
		JScrollPane sp = new JScrollPane(txtArea,
										 ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
										 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setAutoscrolls(true);
		txtArea.setBackground(Color.yellow);
		txtArea.setLineWrap(true); // 텍스트 자동 줄바꿈
		txtArea.setEditable(false); // 편집 안돼요~ 출력으로만 쓸거에요~
		
		txtInput.setText("이름 입력");
		txtInput.requestFocus(); // 포커스
		txtInput.selectAll(); // 전체영역 선택
		
		this.add(sp, "Center");
		this.add(txtInput, "South");
		this.setSize(400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이벤트를 걸지 않아도 내부적으로 자동으로 이벤트가 걸린다
		
		txtInput.addActionListener(this);
		
		// socket 생성, 설정
		try {
			Socket socket = new Socket("192.168.0.164", 9999);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			// 서버와 연결
			txtArea.append("서버에 접속 되었습니다 \n\r");
			
			// Thread 구동
			Thread client = new Thread(this);
			client.start();
		} catch (Exception e) {
			System.out.println("Chatt Client : " + e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // ActionListener Interface
		// TextField 입력하고 enter 처리가 이루어지면
		// actionPerformed가 자동으로 호출된다 -> txtInput.addActionListener(this);
		if(e.getSource().equals(txtInput)) {
			String msg = txtInput.getText();
			try {
				out.writeUTF(msg); // 서버로 출력
				txtInput.setText("");
			} catch (Exception e2) {
				System.out.println("actionPerformed : " + e2.getMessage());
			}
		}
	}

	@Override
	public void run() { // Runnable Interface
		try {
			String msg = in.readUTF();
			txtArea.append(msg + "\n\r");
			while(in != null) {
				msg = in.readUTF();
				txtArea.append(msg + "\n\r");				
			}
		} catch (Exception e) {
			System.out.println("접속중인 서버와 연결 종료");
			return;
		}
	}
	
	public static void main(String[] args) {
		Ex05_TCP_Chatt_Client client = new Ex05_TCP_Chatt_Client();
	}
}
