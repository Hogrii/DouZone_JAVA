import kr.or.kosa.Mouse;
import kr.or.kosa.NoteBook;

public class Ex04_Modifier {
	public static void main(String[] args) {
		
		/*
		NoteBook notebook = new NoteBook();
		notebook.color = "blue";
		notebook.year = -2023; // 직접 할당의 단점 >> 원하지 않는 값이 들어올 수 있다
							   // public의 단점
		System.out.println("년도 : " + notebook.year);
		 */
		
		NoteBook notebook = new NoteBook();
		notebook.setColor("blue");
		notebook.setYear(-2023); // The field NoteBook.year is not visible
		notebook.noteBookInfo();
		System.out.println(notebook.getYear());
		System.out.println(notebook.getColor());
		
		/////////////////////////////////////////
		NoteBook mynote = new NoteBook();
		Mouse mouse = new Mouse();
		
		// 마우스 필요해? 연결 해줄게
		mynote.handleMouse(mouse); // 마우스의 주소값을 전달
	}
}
