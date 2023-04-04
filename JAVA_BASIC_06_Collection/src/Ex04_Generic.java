import java.util.ArrayList;
import java.util.List;

// 교재 13장
/*
Today Point
jdk 1.5버전부터 지원

C#, JAVA >> 필수기능

1. 타입을 처음부터 강제
2. 타입 안정성(타입 강제)
3. 강제 형변환의 필요가 없다 >> ex) (Car)Object

 */
// 설계도를 만들 때
class MyGeneric<T> { // T : Type parameter의 약자
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
	
	T get() { // T : Type parameter(데이터 타입)
		return this.obj;
	}
}

class Person {
	int age = 100;
}

public class Ex04_Generic {
	public static void main(String[] args) {
		MyGeneric<String> mygen = new MyGeneric<String>();
		/*
		String obj;
		
		void add(String obj) {
			this.obj = obj;
		}
		
		String get() { // T : Type parameter(데이터 타입)
			return this.obj;
		}
		 */
		mygen.add("문자열");
		String str = mygen.get(); // 쉽게 데이터를 얻을 수는 있지만 확장성은 떨어진다
		System.out.println(str);
		System.out.println();
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add("홍길동");
		list.add(new Person());
		
		// 개선된 for문을 사용해서 Person 객체는 age 출력 나머지는 값을 출력
		for(Object obj : list) {
			if(obj instanceof Person) {
				Person p = (Person)obj;
				System.out.println(p.age);
			}else {
				System.out.println(obj);
			}
		}
		System.out.println();
		
		List<Person> plist = new ArrayList<>();
		plist.add(new Person());
		plist.add(new Person());
		for(Person p : plist) {
			System.out.println(p.age);
		}
	}
}
