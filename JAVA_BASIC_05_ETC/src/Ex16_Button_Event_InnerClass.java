import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class LoginForm2 extends Frame {
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm2(String title) {
		super(title);
		lbl_id = new Label("ID:", Label.RIGHT);
		lbl_pwd = new Label("PWD:", Label.RIGHT);
		
		txt_id = new TextField(10);
		txt_pwd = new TextField(10);
		txt_pwd.setEchoChar('#'); // 입력되는 값을 #으로 가려준다
		btn_ok = new Button("login");
		
		this.setLayout(new FlowLayout()); // 순서(add())
		this.setSize(500, 100);
		this.setVisible(true);
		
		this.add(lbl_id);
		this.add(txt_id);
		this.add(lbl_pwd);
		this.add(txt_pwd);
		this.add(btn_ok);		

		// inner Class
		class Btn_handler implements ActionListener { // 1. 인터페이스를 구현한 객체 사용
			// button을 클릭했을 때
			// id 입력값, pwd 입력값을 가져와서 유효성 검증을 하고 싶다
			
			// 장점 : outer class의 자원 사용이 용이하다
			
			// 실행 함수
			@Override
			public void actionPerformed(ActionEvent e) { // 자바스크립트의 콜백함수라고 생각하면 좋다
				String id = txt_id.getText().trim();
				String pwd = txt_pwd.getText().trim();
				
				System.out.println(e.getSource());
				if(id.equals("jinho")) {
					System.out.println("방가 : " + pwd);
				}else {
					System.out.println("누구세요?");
				}
			}
		}
		btn_ok.addActionListener(new Btn_handler());
		this.addWindowListener(new WindowListener() { // WindowListener 인터페이스를 이용해 익명 객체 사용
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// 창을 닫는 메소드
				e.getWindow().setVisible(false);
				e.getWindow().dispose(); // 소멸자 호출
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

public class Ex16_Button_Event_InnerClass {
	public static void main(String[] args) {
		LoginForm2 login = new LoginForm2("로그인");
	}
}
