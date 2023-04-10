import java.io.BufferedReader;
import java.io.FileReader;

public class Ex06_Reader_Writer_Buffer {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");
			br = new BufferedReader(fr);
			// Buffer의 장점 : 라인 단위 처리가 가능
			String line = "";
			for(int i=0; (line = br.readLine()) != null; i++) {
//				System.out.println(line); // .java 파일을 그대로 다 읽어온다
				if(line.indexOf(";") != -1) {
					System.out.println(line); // ;이 있는 라인만 출력
				}
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
