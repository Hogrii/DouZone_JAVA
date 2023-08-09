import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

/*
 * java api는 네트워크 작업을 지원하기 위해서
 * java.net package를 통해 다양한 클래스를 제공해준다
 * 
 * 1. 크로스 도메인 오류(java 코드 처리 : read)
 * 2. 크롤링(특정 페이지에서 원하는 정보 추출)
 * 
 * 샘플 : https://qi-b.qoo10cdn.com/partner/goods_image/7/2/1/8/356767218g.jpg
 */

public class Ex01_URLConnection {
	public static void main(String[] args) throws Exception {
		String urlStr = "https://qi-b.qoo10cdn.com/partner/goods_image/7/2/1/8/356767218g.jpg";
		
		URL url = new URL(urlStr); // 연결(인터넷상 주소)
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		
		URLConnection uc = url.openConnec tion();
		
		// URLConnection 연결된 주소에서 원하는 정보 추출하기
		int filesize = uc.getContentLength();
		
		System.out.println("파일 크기 : " + filesize);
		System.out.println("파일 형식 : " + uc.getContentType());
		
		// read 복제 ....
		FileOutputStream fos = new FileOutputStream("copyimage.jpg");
		
		// 파일 생성(빈), 프로젝트 폴더 default 경로
		byte[] buffer = new byte[4096];
		int n = 0;
		int count = 0;
		while((n=bis.read(buffer)) != -1) {
			fos.write(buffer, 0, n);
			fos.flush();
			System.out.println("n : " + n);
			count += 1; // while 반복 횟수
		}
		System.out.println();
		fos.close();
		bis.close();
	}
}
