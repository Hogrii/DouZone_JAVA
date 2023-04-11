import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.or.kosa.UserInfo;

public class Ex16_ObjectDataInputStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);
			
			// 복원(조건 : 내가 객체 2개를 write했다는 사실을 알고 있어야한다)
			UserInfo r1 = (UserInfo)in.readObject(); // 객체 타입으로 다운캐스팅
			UserInfo r2 = (UserInfo)in.readObject();
			System.out.println(r1.toString());
			System.out.println(r2.toString());
		}catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않아요");
		}catch (EOFException e) {
			System.out.println("끝 " + e.getMessage());
		}catch (IOException e) {
			System.out.println("파일을 읽을 수 없어요");
		}catch (ClassNotFoundException e) {
			System.out.println("해당 객체가 존재하지 않아요");
		}catch (Exception e) {
			System.out.println("나머지 예외");
		}finally {
			try {
				in.close();
				bis.close();
				fis.close();
			}catch(Exception e2) {
				
			}
		}
	}
}
