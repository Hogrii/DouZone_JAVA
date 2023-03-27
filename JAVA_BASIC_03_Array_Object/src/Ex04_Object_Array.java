
class Person{
	String name;
	int age;
	
	// 만약 사람을 만들 때 이름, 나이를 강제하고 싶으면 >> 생성자를 쓰면 된다
//	Person(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
	
	void print() {
		System.out.println(this.name + " : " + this.age);
	}
}

public class Ex04_Object_Array {
	public static void main(String[] args) {
		int[] intarr = new int[10]; // 0
		boolean[] boolarr = new boolean[5]; // false(default)
		
		Person p = new Person(); // local 참조 변수 p >> p라는 변수는 주소값을 가진다
		p.name = "홍길동";
		p.age = 40;
		
		// Person 타입의 사람 3명을 만드세요
		// heap 메모리에 객체를 3개 만들기
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		
		Person[] persons = new Person[3]; // 방만 만들고 아무도 살지는 않다(null)
		System.out.println(persons); // [LPerson;@75a1cd57
		System.out.println(persons[0]); // null
		System.out.println(persons[1]); // null
		System.out.println(persons[2]); // null
		
		// 비어있는 방에 Person 객체의 주소값을 넣어주면 된다
		persons[0] = new Person(); // 방에 주소값을 넣어주었다
		
		Person p5 = new Person();
		persons[1] = p5;
		
		persons[2] = new Person();
		
		persons[2].name = "김유신";
		persons[2].age = 100;
		
		System.out.println(persons[2].name);
		System.out.println(persons[2].age);
		
		// 초급자
		// 객체 배열에 방을 만드는 것(1. 선언)과 방을 채우는 것(2. 할당)은 별도다
		
		// 객체 배열 3가지 방법
		// 1. int[] arr = new int[10] // 선언, 할당을 다 했다
		Person[] parray = new Person[10]; // 선언만하고 할당은 안했다
		// parray[0] >> null
		// 방에 들어갈 주소도 만들어야 한다(Person 타입과 동일)
		for(int i=0; i<parray.length; i++) {
			parray[i] = new Person();
			System.out.println("주소값 : " + parray[i]);
		}
		
		// 2. int[] arr = new int[] {10, 20, 30};
		Person[] parray2 = new Person[] {new Person(), new Person(), new Person()};
		
		// 3. int[] arr = {10, 20, 30};
		Person[] parray3 = {new Person(), new Person(), new Person()};
	}
}
