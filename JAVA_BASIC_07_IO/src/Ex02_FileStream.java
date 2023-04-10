import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Today Point
 * 
 * Byte 데이터를 read / write 대상이 >> File(a.txt)
 * 
 * FileInputStream FileOutputStream
 * 
 * 이미지, 엑셀 >> read, write
 * 
 * File >> 1.txt, 1.data(read, write)
 * 
 * I/O 자원은 개발자가 직접적으로 자원에 해제 워드 파일 작업 중에 같은 파일을 열었을 때의 상황.. >> 기존 파일을 닫아야 한다 >>
 * Close() >> 강제된 예외 처리를 사용하는 I/O 클래스는 강제로 예외처리를 요구하는 코드가 많다
 */

public class Ex02_FileStream {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		String path = "C:\\Douzone\\Temp\\a.txt";
		
		try {
			fis = new FileInputStream(path); // Unhandled exception type FileNotFoundException -> try-catch
			fos = new FileOutputStream("C:\\Douzone\\Temp\\new.txt", true);
			// 현재 Temp 폴더 안에 new.txt 파일이 없다
			/**
			 * FileOutputStream
			 * 1. write 파일이 존재하지 않으면 >> 자동으로 파일을 생성한다(create 기능)
			 * 
			 * 2.1 fos = new FileOutputStream("C:\\Douzone\\Temp\\new.txt", false);
			 * false >> 기존에 파일이 있다면 override(덮어쓰기)를 한다
			 * 
			 * 2.2 fos = new FileOutputStream("C:\\Douzone\\Temp\\new.txt", true);
			 * true >> 기존에 파일이 있다면 append(내용추가)를 한다
			 */
			int data = 0;
			while((data = fis.read()) != -1) { 
//				System.out.println("정수 : " + data + " : " + (char)data);
				fos.write(data); // 출력 스트림 // C:\\Douzone\\Temp\\new.txt
								 // new.txt에 HELLO가 쓰여짐
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 정상, 비정상적이든
			// 함수가 강제로 return을 하더라도
			// finally는 강제로 실행된다
			// 자원 해제 코드 >> I/O자원들은 garbage collector가 관리하지 않기 때문
			// close() 명시적 >> 소멸자 호출
			
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
