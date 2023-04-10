import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GroupQuiz_Dos {

	static String defaultPath = "C:" + File.separator;
	static String path = defaultPath;

	public static void main(String[] args) {

		System.out.println("Bitamp Microsoft Windows DOS 명령어 [Version 1.1]");
		System.out.println("2020 Bitcamp. All rights reserved\n");

		Scanner sc = new Scanner(System.in);

		String[] input = null;
		File file = new File(path);

		while (true) {
			System.out.print(path + ">");
			input = sc.nextLine().trim().split(" ");
			// input배열에 띄어쓰기 기준으로 각 방에 저장, 첫 번째 방 전에 공란 방지

			if (input[0].equalsIgnoreCase("exit")) { // 오직 exit로만 Dos 종료 가능
				System.out.println("Exit");
				System.exit(0);
				return;
			}

			switch (input[0].toLowerCase()) {
			case "dir":
				searchDirectory(file);
				break;
			case "cd":
			case "cd..":
			case "cd\\":
			case "cd/":
				changeDirectory(input);
				break;
			case "md":
			case "mkdir":
				makeDirectory(input);
				break;
			case "ren":
			case "rename":
				renameDirectory(input);
				break;
			case "move":
				moveToFile(input);
				break;
			default:
			}
		}
	}

	private static void searchDirectory(File dir) {
		for(int i=0; i<dir.length(); i++) {
			System.out.print(dir.getName() + " ");
		}
		System.out.println();
	}
	
	private static void moveToFile(String[] input) {
		Path file = Paths.get(input[1]);
		Path newFile = Paths.get(input[2]);

		try {
			Path newFilePath = Files.move(file, newFile);
			System.out.println(newFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void makeDirectory(String[] input) {
		File folder = new File(input[1]);

		folder.mkdir();
	}

	private static void renameDirectory(String[] input) {
		System.out.println(input);
		File file = new File(input[1]);
		File newFile = new File(input[2]);
		file.renameTo(newFile);

	}
	
	public static void changeDirectory(String[] input) {
		File file = null;
		if (input[0].equalsIgnoreCase("cd")) {
			if (input.length <= 1) {
				System.out.println(path);
			} else if (input.length == 2) {
				String tempPath = path;
				if (!path.equals(defaultPath)) {
					tempPath += File.separator + input[1];
				} else {
					tempPath += input[1];
				}

				file = new File(tempPath);
				if (file.isDirectory()) {
					path = tempPath;
				} else {
					System.out.println("지정된 경로를 찾을 수 없습니다");
				}
			}

		} else if (input[0].equalsIgnoreCase("cd..")) {
			if (input.length <= 1) {
				int pos = path.lastIndexOf(File.separator);
				if (!path.equals(defaultPath) && pos > 2) {
					path = path.substring(0, pos);
				} else {
					path = path.substring(0, pos + 1);
				}
			} else {
				System.out.println("지정된 경로를 찾을 수 없습니다");
			}
		}
	}
}
