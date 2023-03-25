package Chapter06_Class;

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		// s1 변수에 의해 참조된 Student 객체는 heap 메모리에 올라가게 되고
		// s1 변수는 heap 메모리에 올라간 Student 객체의 주소값을 갖게 된다.
		
		Student s2 = new Student();
		System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
		// s2 변수에 의해 참조된 Student 객체는 heap 메모리에 올라가게 되고
		// s2 변수는 heap 메모리에 올라간 Student 객체의 주소값을 갖게 된다.
		
		System.out.println(s1 == s2);
		// s1 변수와 s2 변수는 각각 heap 메모리에 올라간 다른 Student 객체의 주소값을 가지고 있기 때문에
		// s1 == s2는 false가 된다.
		
		Student s3 = s2;
		// s3 변수는 heap 메모리에 올라간 s2의 Student 객체 주소를 갖게 된다.
		
		System.out.println(s2 == s3);
		// s2 변수와 s3 변수는 heap 메모리에 올라간 같은 Student 객체의 주소값을 가지고 있기 때문에
		// s2 == s3는 true가 된다.
	}
}
