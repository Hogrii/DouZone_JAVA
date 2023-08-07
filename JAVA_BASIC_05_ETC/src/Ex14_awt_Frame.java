import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */

class MyFrame extends Frame { // Frame -> java.awt 패키지에 있고, 도화지 만드는 클래스
	public MyFrame(String title) {
		super(title);
	}	
}

// 익명 타입을 쓰지 않는 경우
// 직접 만들어야 한다 -> 재사용이 필요하다면 이렇게 쓰는게 더 좋다
class BtnClickHandler implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("나 클릭");
	}	
}

public class Ex14_awt_Frame {
	public static void main(String[] args) {
		MyFrame my = new MyFrame("Login");
		my.setSize(350, 300);
		my.setVisible(true);
		my.setLayout(new FlowLayout());
		
		Button btn1 = new Button("first btn");
		Button btn2 = new Button("second btn");
		Button btn3 = new Button("third btn");
		
		// 버튼에 이벤트
		// 이벤트 : 소스, 행위, 감지
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("인터페이스 익명 객체 구현");
			}
		});
		
		BtnClickHandler handler = new BtnClickHandler();
		btn2.addActionListener(handler);
		
		my.add(btn1);
		my.add(btn2);
		my.add(btn3);
	}
}
