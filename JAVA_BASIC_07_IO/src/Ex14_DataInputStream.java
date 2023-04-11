import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex14_DataInputStream {
	public static void main(String[] args) {
		// 파일 score.txt 학생 점수 기록
		// read 학생 점수 합계, 평균을 구하고 싶다
		
		int sum = 0;
		int score = 0;
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("score.txt");
			dis = new DataInputStream(fis);
			while(true) {
				score = dis.readInt(); // writeInt()로 Ex13에서 썻기 때문에 readInt()로 읽어야한다
				System.out.println("score int 파일 : " + score);
				sum += score;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
			System.out.println("sum의 결과 : " + sum);
		}finally {
			try {
				dis.close();
				fis.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
