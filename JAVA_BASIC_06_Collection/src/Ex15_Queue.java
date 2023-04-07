import java.util.LinkedList;
import java.util.Queue;

import kr.or.kosa.Message;

public class Ex15_Queue {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();

		// 선입선출(FIFO) <-> 후입선출(LIFO)
		
		// 학사관리(수강신청, 드라이브스루)
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "홍길서"));
		messageQueue.offer(new Message("sendKakaotalk", "홍길남"));

		while (!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch (message.command) {
			case "sendMail":
				System.out.println(message.to + "님에게 메일을 보냅니다");
				break;
			case "sendSMS":
				System.out.println(message.to + "님에게 SMS을 보냅니다");
				break;
			case "sendKakaotalk":
				System.out.println(message.to + "님에게 카톡을 보냅니다");
				break;
			}
		}
	}
}
