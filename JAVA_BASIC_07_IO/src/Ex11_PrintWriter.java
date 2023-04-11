import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * 출력 형식을 지정 할 수 있는 보조 스트림
 * 1. printf
 * 2. String.format
 * 3. I/O 계열의 PrintWriter(파일의 출력을 정의(이쁘게))
 * 
 * 현업) 세금계산서, 지출결의서 출력, 휴가서, 품의서 >> 만들어주는(레포팅) >> 오즈, 크리스탈 레포트
 *
 */
public class Ex11_PrintWriter {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			/*
			// write
			PrintWriter pw = new PrintWriter("C:\\Douzone\\Temp\\homework.txt");
			pw.println("**************************************");
			pw.println("***             HOMEWORK           ***");
			pw.printf("%3s : %5d %5d %5d %5.1f","아무개", 100, 88, 90, (float)((100+88+90)/3));
			pw.println();
			pw.close();
			// 출력 형식을 이쁘게 정의하는 것일 뿐임..
			 */
			
			// read (Line) 문자
			fr = new FileReader("C:\\Douzone\\Temp\\homework.txt");
			br = new BufferedReader(fr);
			String s = "";
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
