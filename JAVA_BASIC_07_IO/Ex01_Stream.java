import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * IO(input/output)
 * 
 * Stream(통로)
 * 데이터 종류 : 이미지, 파일, 문자
 * 
 * JAVA API >> 클래스를 제공 받는다
 * I/O 기본 단위는 Byte
 * 
 * 추상 클래스
 * InputStream, OutputStream(추상함수 ... 재정의)
 * 
 * 당신이 Byte 데이터 작업을 하고 싶다면
 * InputStream을 상속 구현하는 클래스를 사용해라
 * 
 * 대상이
 * 1. Memory : ByteArrayInputStream
 * 2. File   : FileInputStream(**중요)
 * 
 * 당신이 Byte 데이터 작업을 하고 싶다면
 * OutputStream을 상속 구현하는 클래스를 사용해라
 * 
 * 대상이
 * 1. Memory : ByteArrayOutputStream
 * 2. File   : FileOutputStream(**중요)
 * 
 * 사실 지금까지 Array, Collection을 통해서 메모리기반 작업을 진행 해왔다
 */
public class Ex01_Stream {
	public static void main(String[] args) {
		
		// byte (-128~127) 정수를 저장하는 타입
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null; // 현재 메모리를 가지고 있지 않아요
		
		// 빨대 >> memory >> read, write
		ByteArrayInputStream input = null;   // 빨대(통로) 입력
		ByteArrayOutputStream output = null; // 빨대(통로) 출력
		
		input = new ByteArrayInputStream(inSrc); // input 대상 : inSrc >> read
		output = new ByteArrayOutputStream(); // write, 출력을 뱉을 때 사용
		
		System.out.println("outSrc before : " + Arrays.toString(outSrc)); // null
		
		// 공식같은 로직(암기)
		int data = 0;
		while((data = input.read()) != -1) { // .read()는 읽을 값이 없으면 -1을 리턴한다
//		while(input.read() != -1) {
			System.out.println("data : " + data); // 1, 2, 3, 4, 5, 6, 7, 8, 9
			
			// read() 함수는 내부적으로 next()를 포함하고 있다
			// 위 while문에서 이미 데이터를 읽기 때문에 한칸씩 건너서 출력되는 것
			// 따라서 next()를 막기 위해 data에 담아서 출력해야 한다
//			System.out.println(input.read()); // 1, 3, 5, 7, 9
			
			// read 한 데이터를 다른 Stream을 사용해서 출력
			output.write(data); // 출력통로(빨대) 안에 데이터를 담고 있는 것
			// .write()의 대상이 data가 아니라 output 자기 자신(ByteArrayoutputStream)이다
		}
		
		outSrc = output.toByteArray(); // 자신이 가지고 있는 데이터를 Byte[]로 바꾸어서 주소를 outSrc에 전달
		System.out.println("outSrc after : " + Arrays.toString(outSrc));
		
	}
}
