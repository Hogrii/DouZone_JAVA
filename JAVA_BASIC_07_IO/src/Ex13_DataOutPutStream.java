import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * 보조 스트림
 * DataOutPutStream
 * DataInputStream
 * 
 * 장점
 * JAVA가 지원하는 8가지 기본타입별로 write, read 가능
 * 단 조건은 DataOutPutStream >> DataInputStream 서로 호환 가능
 * 
 * -----------------------------------------------------
 * 성적.txt >> 단점 : 규칙을 아주 잘~~ 정의 해야함
 * 100, 99, 60, 50
 * 50, 55, 30, 100
 * Line 단위 read >> split >> 타입 변환 >> Array >> read 연산
 */
public class Ex13_DataOutPutStream {
	public static void main(String[] args) {
		int[] score = {100, 60, 55, 95, 50};
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("score.txt"); // 출력할 때 파일이 없으면 알아서 만들어줌 >> OutputStream
			dos = new DataOutputStream(fos);
			for(int i=0; i<score.length; i++) {
				dos.writeInt(score[i]); // 정수값 그대로 write
				// 조건 : Byte로 write하기 때문에 파일은 반드시
				// DataInputStream을 통해서만 읽을 수 있다
				// 채팅 -> dos.writeUTF(null); 이용..
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
				fos.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
