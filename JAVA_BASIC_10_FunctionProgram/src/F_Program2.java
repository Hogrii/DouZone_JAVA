import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/** 
 * 
 * java는 객체지향 언어이기 때문에 기본적으로 함수형 프로그래밍이 불가능하다 
 * 
 * JDK8 Stream API 제공 .. 람다식을 이용
 * 
 * 함수형 인터페이스 등을 지원 .. java를 이용해서 javascript에서 사용했던 함수형을 API를 통해서 제공
 * 그 대표가 Stream API는 데이터를 추상화하고 처리하는데 자주 사용하는 함수를 정의해 두었다
 * ex) select * from emp where sal > 2000 and ename = '길동' and ..
 * 
 * 위에서 쓰는 방식을 자바에서도 추상화된 함수를 구현 할 수 있다 >>  Stream API 구현 람다식 ..
 * 표준화, 재사용성을 높일 수 있다
 *
 */

public class F_Program2 {
	public static void main(String[] args) {
		String[] nameArr = {"Hulk", "Captain", "IronMan"};
		List<String> nameList = Arrays.asList(nameArr);
		
		/*
		  아래 코드는 좋은 코드이지만..
		  만약 더 간결하고 가독성을 높게 만들되 원본 데이터에 변형을 가하지 않는 방법이 있다면..?
		  
		  Java Stream API 원본의 데이터 변경 없이 간결한 형태의 코드 작성 방법을 갖고 있다
		 */
		
		Arrays.sort(nameArr);
		Collections.sort(nameList);
		
		for(String str : nameArr) {
			System.out.println(str);
		}
		
		for(String str : nameList) {
			System.out.println(str);
		}
		
		/*
		  Java Stream API를 사용해서 리팩토링을 해보자
		 */
		
		// 1. 원본 데이터가 아닌 별도의 데이터 집합을 만든다
		// stream은 Collection을 보조하는 녀석
		
		Stream<String> arrayStream = Arrays.stream(nameArr);
		Stream<String> nameStream = nameList.stream();
		
		// 복사된 데이터를 정렬해서 출력
		arrayStream.sorted().forEach(System.out :: println);
		nameStream.sorted().forEach(System.out :: println);
		
		// Stream API를 사용하면 코드의 라인수도 줄이고,, 가독성도 높인다
	}
}
