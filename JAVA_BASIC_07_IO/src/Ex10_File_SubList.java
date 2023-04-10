import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex10_File_SubList {
	static int totalFiles = 0; // 전체
	static int totalDirs = 0;  // 전체
	
	static void printFileList(File dir) {
		System.out.println("Full path : " + dir.getAbsolutePath());
		
		List<Integer> subDir = new ArrayList<>();
		
		File[] files = dir.listFiles(); // 하위 자원 정보
		for(int i=0; i<files.length; i++) {
			String fileName = files[i].getName(); // 폴더명 또는 파일명
			if(files[i].isDirectory()) { // 폴더라면
				fileName = "[ DIR ]" + fileName;
				// Point
				subDir.add(i); // 폴더인 경우 index를 관리 >> ArrayList를 통해서
				// subDir[0] = 1
			}else {
				fileName = fileName + " / " + files[i].length() + "byte";
			}
		}
		
		// 폴더 개수
		// 파일 개수
		int dirNum = subDir.size(); // 현재 주어진 폴더의 하위 폴더 개수
		int fileNum = files.length - dirNum; // 현재 주어진 폴더의 파일 개수
		
		// 누적 개수(하위 폴더 총 자원)
		totalDirs += dirNum;
		totalFiles += fileNum;
		
		System.out.println("[Current DirNum] : " + dirNum);
		System.out.println("[Cuurent FileNum] : " + fileNum);
		System.out.println("===============================");
		/**
		 * Point(하위 폴더 안에 또다른 하위 폴더가 존재할 때)
		 * [0] >> a.txt
		 * [1] >> aaa 폴더 >> a-1 폴더, a-2 폴더
		 * [2] >> bbb 폴더 >> b-1 폴더, b.txt, b-1.jpg
		 * [3] >> java.jpg
		 */
		for(int i=0; i<subDir.size(); i++) { // 폴더들의 개수
			int index = subDir.get(i);
			printFileList(files[index]); // 재귀호출
		}
	}
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java [실행할 파일명] [경로명]");
			System.out.println("예시 : java Ex10_File_SubList C:\\Douzone\\Temp");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다");
			System.exit(0);
		}
		
		// 위 두가지 조건을 통과했다면
		// 정상적인 경로이고 폴더가 있다는 뜻
		printFileList(f);
		System.out.println("누적 총 파일 수 : " + totalFiles);
		System.out.println("누적 총 폴더 수 : " + totalDirs);
	}
}
