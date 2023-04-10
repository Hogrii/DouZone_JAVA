import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex03_Stream_ImageCopy {
	public static void main(String[] args) {
		String oriFile = "C:\\Douzone\\Temp\\ebichu.gif";
		String targetFile = "copy.gif";
		// default 경로 : C:\Douzone\Java\Labs\JAVA_BASIC_07_IO
		// >> 경로를 따로 적어주지 않으면 프로젝트 폴더가 default 경로가 된다
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(oriFile);
			fos = new FileOutputStream(targetFile);
			
			int data = 0;
			while((data = fis.read()) != -1) {
				fos.write(data); // byte 값
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();				
			}catch (Exception e) {
				
			}
		}
	}
}
