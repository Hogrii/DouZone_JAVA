import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Dir_Format {
	public static void main(String[] args) {
		File dir = new File("C:\\Douzone\\Temp");
		File[] files = dir.listFiles();
		
		for(int i=0; i<files.length; i++) {
			File file = files[i];
		
			String name = file.getName(); // 폴더명 또는 파일명
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mma");
			String attribute = "";
			String size = "";
			
			if(files[i].isDirectory()) { // 폴더
				attribute = "< DIR >";
			}else { // 파일 >> a.txt ..
				size = file.length() + "byte";
				attribute = file.canRead()   ? "R" : ""; // canRead() 읽기만 가능하니?
				attribute += file.canWrite() ? "W" : "";
				attribute += file.isHidden() ? "H" : "";
			}
			System.out.printf("%s %3s %10s %s \n",
					sdf.format(new Date(file.lastModified())),
					attribute,
					size,
					name);
			// lastModified() >> 마지막 수정날짜
		}
	}
}
