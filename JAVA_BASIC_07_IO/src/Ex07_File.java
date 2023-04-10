import java.io.File;

/**
 * 파일, 폴더를 다루는 클래스 학습
 * C# : 파일(File), 폴더(Directory)
 * 
 * JAVA : File(파일생성, 삭제 .. 폴더 생성, 삭제) >> 하나의 클래스로
 * >> a.txt 생성, 수정, 삭제, 정보 read
 * >> Temp 생성, 수정, 삭제, 정보 read
 * 
 * 경로
 * 절대경로 : C:\\, D:\\ >> C:\\Douzone\\Temp\\a.txt
 * 상대경로 : 현재 파일을 중심으로 >> ../ >> /
 */

public class Ex07_File {
	public static void main(String[] args) {
		String path = "C:\\Douzone\\Temp\\file.txt";
		
		File f = new File(path); // 경로를 입력해줘야 한다
		
		// File 클래스는 다양한 정보 취득이 목적
		System.out.println("파일 존재 여부 (파일, 폴더) : " + f.exists()); // 파일이 실제로 존재하는지 물어본다 .exists();
		System.out.println("너 폴더니? : " + f.isDirectory()); // 폴더면 true
		System.out.println("너 파일이니? : " + f.isFile()); // 파일이면 true
		
		System.out.println("파일명 : " + f.getName()); // 전체 경로에서 파일 이름만 뽑아온다 // 파일명 : file.txt
		
		System.out.println("절대경로 : " + f.getAbsolutePath()); // 절대경로 : C:\Douzone\Temp\file.txt
		
		System.out.println("파일크기 : " + f.length() + "byte");
		System.out.println("부모경로 : " + f.getParent()); // f의 상위 폴더 // 부모경로 : C:\Douzone\Temp
	}
}
