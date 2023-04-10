import java.io.File;

public class Ex08_File_Dir {
	public static void main(String[] args) {
//		System.out.println(args[0]); // Run -> Run Configurations -> Arguments에서 값을 넘겨주면 값이 넘어옴
		if(args.length != 1) { // args.length != 1은 하나도 입력된게 없다는 뜻
			System.out.println("사용법 : java 파일명 [디렉토리명]");
			System.exit(0); // 강제종료
		}
		
		// java Ex08_File_Dir C:\\Douzone\\Temp
		
		File f = new File(args[0]); // File("C:\\Douzone\\Temp")
		if(!f.exists() || !f.isDirectory()) {
			// 존재하지 않거나 디렉토리가 아니라면
			System.out.println("유효하지 않은 경로입니다");
			System.exit(0);
		}
		
		// 실제 존재하는 경로이고 폴더라면
		// Point
		File[] files = f.listFiles(); // [햄스터.dir][a.txt][ebichu.gif][file.txt][new.txt]
		System.out.println(files.length);
		for(int i=0; i<files.length; i++) {
			String name = files[i].getName(); // 파일명, 폴더명
			System.out.println(files[i].isDirectory() ? "[DIR]" + name : name);
		}
	}
}
