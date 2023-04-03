import java.util.Vector;

/*
Collection Framework
[다수의 데이터]를 다루는 [표준화된 인터페이스]를 구현하고 있는 [클래스 집합]

Collection 인터페이스 >> 상속 List >> 구현 ArrayList
Collection 인터페이스 >> 상속 Set >> 구현 HashSet

* ArrayList의 부모 타입은 List이다 -> (o) // 다형성 >> 부모 타입의 참조변수는 자식 타입의 주소값을 가질 수 있다
* Collection 인터페이스는 ArrayList의 부모 타입이다 -> (o)
* instanceof를 이용해서 검증 가능

Map 인터페이스 (key, value) >> 페어, 쌍의 배열 >> 구현 HashMap
key   -> 02, 031
value -> 서울, 경기

1. List(줄을 서시오)
순서가 있는 데이터 집합(번호표) .. 중복 허용 >> 순서(o), 중복(o) 데이터 집합
>> Tip) Array 관리 >> [홍길동][홍길동][홍길동][][] >> 방으로 관리하기 때문에 중복 데이터가 들어와도 관게 없다

1.1 Vector    (구버전) -> 동기화 보장 (o) >> Lock default
 >> 화장실로 생각.. 먼저 들어가서 문 잠궈버리면 다음 사람은 못들어간다
 >> 멀티 스레드 환경(Lock) -> 성능(x), 보안(o)
1.2 ArrayList (신버전) -> 동기화 보장 (x) >> Lock option
 >> 비빔밥이라고 생각.. 
 >> 멀티 스레드 환경(Lock) -> 성능(o), 보안(x)
** Vector는 학습용으로만
** ArrayList만 활용하자
---------------------------------------------------------
다수의 데이터를 다루는 방법(Array >> 정적, 고정)
***** 방의 개수가 한 번 정해지면 방의 크기는 변경 불가
정수 배열 만드는 3가지 방법
1. int[] arr = new int[3];
2. int[] arr2 = new int[] {1, 2, 3};
3. int[] arr3 = {1, 2, 3};

arr3으로 놀고 있는 데이터가 100건이 추가되면..
****** int[] arr4 = new int[100];을 새로 만들고 이사 해야한다(코드로 개발자가 직접 구현)
 >> 하지만 Collection은 이것을 자동으로 해주기 때문에 아주아주아주 중요
 
Array
1. 배열의 크기가 고정 : Car[] cars = {new Car(), new Car()} 2방이 2개
2. 접근 방법 : cars[0] .. cars[n] // n = lenghth-1

List 인터페이스를 구현하고 있는 ArrayList, Vector는
1. 배열의 크기가 동적으로 확장 또는 축소가 가능하다 >> 진실은 컴파일러가 새로운 배열을 만들고 데이터를 이동..
2. 순서를 유지(내부적으로 Array 사용), 중복값 허용
3. 중복값 허용(index를 통해서 제어)

 */
public class Ex01_Vector {
	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("초기 용량 : " + v.capacity()); // 정적 벡터의 크기
														// Object[] obj = new Object[10]
		System.out.println("값의 크기(개수) : " + v.size());
		
		v.add("AA"); // 순서 [0]
		v.add("BB"); // 순서 [1]
		v.add("CC"); // 순서 [2]
		v.add(10);
		System.out.println("size : " + v.size());
		System.out.println(v.toString()); // [AA, BB, CC, 10] >> 배열값을 찍도록 Override 했다

		// 배열의 개수
		// Array >> length() -> 방의 개수		// Car[0]
		// Collection >> size() -> 값의 개수	// get(0)
		
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i) + " "); // get(index) -> 배열 값이 리턴
		}
		System.out.println();
		
		// 개선된 for문
		for(Object value : v) {
			System.out.print(value + " ");
		}
		System.out.println();
		
		// 단점 : 작은 데이터(같은 타입의 데이터) >> 가장 큰 타입을 사용해 얻는게 불합리하다
		// 제너릭 >> 타입을 강제 >> Point
		Vector<String> v2 = new Vector<String>();
//		v2.add(10); // The method add(int, String) in the type Vector<String> is not applicable for the arguments (int)
		v2.add("hello"); // add(String e)로 타입을 강제할 수 있다
		v2.add("world");
		for(String str : v2) {
			System.out.println(str);
		}
		
		Vector v3 = new Vector<>();
		System.out.println(v3.capacity()); // 10
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		System.out.println(v3.capacity()); // 20 >> *2로 새로 만든 후 이사시킨 것
		
		// 편하게 동적으로 늘어나고 줄어든다고 생각
		// ** 면접때는 새로운 배열을 만들고 이사시키는 것이라고 이야기 해야한다..
	}
}
