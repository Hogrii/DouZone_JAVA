package kr.or.kosa;

/*
JAVA API 직접 구현해보기
1. stack 저장공간(Array : 고정배열 10개방), 저장공간 타입(Object)
2. 위치정보 : 저장되는 값이 있는 위치(index) hin) 전자제품 매장 cart 사용해서 처리
3. 기능 : push(), pop(), boolean empty(), boolean full()
 */
public class MyStack {
	private Object[] stackArr; // 저장소
	private int top;

	public MyStack(int maxSize) {
		this.stackArr = new Object[maxSize];
		this.top = 0;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean isFull() {
		return top == stackArr.length;
	}

	public void push(Object obj) {
		if(isFull()) {
			System.out.println("stack is full");
		}else {
			this.stackArr[this.top++] = obj;			
		}		
	}

	public Object pop() {
		Object value = null;
		if(isEmpty()) {
			System.out.println("stack is empty");
		}else {
			value = this.stackArr[--this.top];
		}
		return value;
	}
}
