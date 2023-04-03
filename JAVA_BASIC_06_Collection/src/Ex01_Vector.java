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


 */
public class Ex01_Vector {
	public static void main(String[] args) {
		
	}
}
