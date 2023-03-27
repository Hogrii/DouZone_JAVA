
public class Ex03_Array_For {
	public static void main(String[] args) {
		/*
		  Today Point
		  for문 >> 향상된 for문, 개선된 for문
		  JAVA : for(Type 변수명 : 배열 or Collection) {}
		  C#   : for(Type 변수명 in 배열 or Collection) {}
		  JavaScript : for(Type 변수명 in 배열 or Collection) {}
		 */
		
		int[] arr = {5, 6, 7, 8, 9};
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		
		// 개선된 for문
		for(int value : arr) {
			System.out.println(value);
		}
		System.out.println();
		
		// 개선된 for문으로 출력
		String[] strarr = {"A", "B", "C", "D", "FFFFFF"};
		for(String value : strarr) {
			System.out.println(value);
		}
	}
}
