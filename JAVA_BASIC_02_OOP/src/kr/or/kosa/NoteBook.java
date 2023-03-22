package kr.or.kosa;

/*
노트북은 마우스를 가지고 있다 >> 부품정보 >> 별도의 마우스 관련 설계도 필요 >> 데이터 타입
마우스는 휠 1개, 버튼 2개, 좌표값을 가지고 있다
노트북은 색상을 가지고 있다
노트북은 생산연도를 가지고 있다

정보 >> 고유 정보(데이터), 상태 정보(데이터), 부품 정보(데이터)

class Mouse {
	int x;
	int y; ..
}
 */

public class NoteBook {
	// 노트북은 마우스를 가지고 있다 >> 일체형 >> memberfield로 가지면 안된다
//	public Mouse mouse = new Mouse(); >> 통합 제품, 라이프 사이클이 같다
	
	// 노트북은 마우스를 [필요에 따라] 가지고 있을 수 있다
	// 가진다 : 생성된 마우스의 주소값을 가질 수 있다(heap)
	// 라이프사이클이 다르면 각각 new를 해야 한다
	
	public void handleMouse(Mouse mouse) {
		mouse.setX(100);
		mouse.setY(200);
		mouse.getReadMouseData();
	}
	
	private String color;
//	public int year;
	private int year;
	
	/*
	   객체지향 언어의 특징 : 캡슐화(은닉화), 상속, 다형성, 추상화
	   
	   캡슐화 >> 직접 할당을 막고 간접 할당을 통해 제어(정보 보호) 
	    >> private(참조변수 입장에서 객체에 접근 했을 때 자원이 보이지 않으면 된다)
	   
	   1. 모든 member field는 캡슐화를 해야 한다
	   2. 직접 할당을 막고 간접 할당을 통해서 원하는 값으로 제어하기 위함
	   3. 간접 할당 : 개발자가 직접 논리를 제어(개입)하겠다
	   4. 간접적으로 접근할 수 있는 함수를 만들어야 한다 >> getter(read), setter(write)
	   
	 */
	
	// 함수 생성(특수한 목적의 함수 : private member field에 대해 간접적으로 read, write 할 수 있다)
	public int getYear() { // 읽기 전용(read)
		return year;
	}
	
	public void setYear(int data) { // 쓰기 전용(write)
		if(data<0) year = 1999; // 간접 할당
		else year = data;
	}
	
	public String getColor() {
		return color + " 색상 ";
	}
	
	public void setColor(String data) {
		color = data;
	}
	
	public void noteBookInfo() {
		System.out.printf("노트북 색상 : %s , 노트북 출시 연도 : %d \n", color, year);
		
	}
}