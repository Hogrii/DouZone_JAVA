import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * Disk(File 처리 대상) >> DISK >> 입출력의 단위가 한 byte씩
 * 
 * 여러명의 학생을 한명씩 목적지에 보내는 것이 아니고
 * 여러명이 탈 수 있는 버스를 대여해서 한번에 보내고 처리하겠다
 * 
 * 버스 : Buffer >> FileInputStream, FileOutputStream 없이 독자적으로 사용이 불가
 * 1. I/O 성능 개선(접근 횟수를 줄인다)
 * 2. Line 단위 해석(엔터)
 * 
 * BufferedOutputStream(보조 스트림) >> 독자적인 작업 불가 >> File(Input, Output)Stream(주 스트림)
 */
public class Ex04_Stream_Buffer {
	public static void main(String[] args) {
		// BufferedOutputStream bos = new 
		// 무조건 생성할 때 생성자의 파라미터로 OutputStream의 추상 객체를 받아야 하기 때문에 독자적으로 사용이 불가
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt"); // 파일이 없으면 파일을 만든다(create)
			bos = new BufferedOutputStream(fos); // Buffer 탄생
			
			for(int i=0; i<10; i++) {
				bos.write('A'); // data.txt 파일에..
			}
//			bos.flush(); // 작은 용량이라도 강제로 보내고 싶다면 .flush()를 사용
			
			/*
			 * JAVA Buffer(8kb, 8192byte)
			 * 1. Buffer 안에 내용이 채워지면 스스로 출발(버퍼를 비우는 작업 진행)
			 * 2. 강제로 출발(buffer를 강제로 비우기 : .flush(), .close()) >> close()안에 flush()가 포함되어 있다
			 * 3. 개발 >> close()가 자원해제를 하면서 내부적으로 flush()를 돌림
			 */
		}catch(Exception e) {
			
		}finally {
			try {
				bos.close(); // .close() 사용시 내부적으로 .flush()를 자동으로 실행
				fos.close();
			}catch(Exception e) {
				
			}
		}
		
	}
}
