import java.util.Stack;

import kr.or.kosa.MyStack;

public class Ex05_Stack_Queue {
	public static void main(String[] args) {
		// JAVA API가 제공하는 클래스
		
		// LIFO(Last In First Out)
		// stack의 실사용 사례 >> 동전 케이스, 휴대폰 화면(전환), 연탄갈기 등등		
		Stack stack = new Stack();
		stack.push("A"); // .push >> stack에 넣음
		stack.push("B");
		stack.push("C");
		
		System.out.println(stack.pop()); // .pop >> stack에서 뺌
		System.out.println(stack.pop());
		System.out.println(stack.pop()); // C, B, A
//		System.out.println(stack.pop()); // EmptyStackException
		System.out.println(stack.empty()); // .empty >> stack이 비어있는지 확인
		System.out.println();
	}
}
