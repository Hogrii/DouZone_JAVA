import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import kr.or.kosa.UserInfo;

/**
 * 파일을 기반으로 작업
 * 파일에 객체를 직렬화 방식으로 write
 */
public class Ex15_ObjectDataOutputStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null; // 직렬화 객체
		
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			// 직렬화
			// 파일에 write 할때 직렬화
			out = new ObjectOutputStream(bos);
			
			// 객체 생성 -> 완제품
			UserInfo u1 = new UserInfo("홍길동", "super", 100);
			UserInfo u2 = new UserInfo("scott", "tiger", 50);
			
			// 직렬화
			out.writeObject(u1); // UserInfo 객체를 줄을 세워서 write
			out.writeObject(u2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				out.close();
				bos.close();
				fos.close();
				System.out.println("파일 생성 -> buffer -> 직렬화 -> 파일 write");
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
