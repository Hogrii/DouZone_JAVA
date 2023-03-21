package kr.or.kosa;

/*
class == 설계도 == 데이터 타입(사용자 정의 타입)

설계도(종이) >> 구체화(메모리에 올리는 행위) >> 구체화된 자원 >> 객체(Object), instance

설계도 : field(고유, 상태, 부품(더 나뉘어질 수 있다)) + method(기능, 행위) + constructor(생성자 함수)

 */

public class Person {
	// member field, instance variable(객체 변수, 주소값을 가진 변수)
	public String name; // 생성되는 객체마다 다른 값을 가지기 때문에 초기화 필요가 없다
						// default 값(null)
	public int age; // default 값(0)
	public boolean power; // default 값(false)
	
	/*
	   1. instance variable : 초기화 하지 않아도 된다 >> default값이 있기 때문
	      변수가 처음으로 값을 할당 받는 것 >> 초기화
	   2. age memeber field를 초기화 하고 싶어! : public int age = 1;
	      >> 필요하다면 당연 초기화 가능! >> 대신 만들어지는 모든 객체의 age는 1
	   
	   Today Point : why 초기화를 잘 하지 않을까? >> 다 나이가 다르기 떄문
	   
	 */
	
	// method
	public void personPrint() {
		System.out.printf("이름은 %s 나이는 %d 파워는 %s 입니다 \n", name, age, power);
	}
}
