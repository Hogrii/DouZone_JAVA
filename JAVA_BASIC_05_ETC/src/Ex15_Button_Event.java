import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Btn_handler implements ActionListener { // 1. 인터페이스를 구현한 객체 사용
	// button을 클릭했을 때
	// id 입력값, pwd 입력값을 가져와서 유효성 검증을 하고 싶다
	private TextField txtid;
	private TextField txtpwd;
	
	public Btn_handler(TextField txtid, TextField txtpwd) {
		this.txtid = txtid; // 주소값
		this.txtpwd = txtpwd;
	}
	
	// 실행 함수
	@Override
	public void actionPerformed(ActionEvent e) { // 자바스크립트의 콜백함수라고 생각하면 좋다
		System.out.println(e.getSource());
		if(txtid.getText().equals("jinho")) {
			System.out.println("방가 : " + txtpwd.getText());
		}else {
			System.out.println("누구세요?");
		}
	}
}

class LoginForm extends Frame {
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm(String title) {
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
		
		btn_ok.addActionListener(new Btn_handler(txt_id, txt_pwd));
	}
}

public class Ex15_Button_Event {
	public static void main(String[] args) {
		LoginForm login = new LoginForm("로그인");
	}
}
