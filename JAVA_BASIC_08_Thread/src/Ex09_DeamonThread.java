
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 자동 저장 ...");
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				break;
			}
			save();
		}
	}
}

public class Ex09_DeamonThread {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true); // autoSaveThread를 데몬 스레드로 만든다
		autoSaveThread.start();
		// main thread 종료 .. 데몬도 종료
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("메인 스레드 종료 ...");
	}
}
