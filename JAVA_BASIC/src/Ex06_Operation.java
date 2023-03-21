
public class Ex06_Operation {
	public static void main(String[] args) {
		// 대입 연산자
		// +=, -=, *=, /=
		
		int sum = 0;
		sum += 1; // sum = sum + 1;
		sum -= 1; // sum = sum - 1;
		System.out.println("sum : " + sum);
		
		/*
		  if(조건식) {}
		  
		  if(조건식) {} else {}
		  
		  if(조건식) {} else if(조건식) {} else if(조건식) {} ... else {}
		  
		  간단한 학점 계산기
		  
		  학점 : A+, A-, B+, B-, ..., F
		  판단기준 : 90이상 A(다시 판단 95 이상 A+ 이하 A-), 80 B, 70 C, 나머지 F
		 */
		
		int score = 94;
		String grade = ""; // A+, A-, B+, B-, C, F
		System.out.println("당신의 점수는 : " + score);
		
		if(score>=90) {
			grade = "A";
			/*
			if(score>=95) grade += "+";
			else grade += "-";
			 */
			grade = (score >= 95) ? (grade += "+") : (grade += "-");
		}else if(score>=80) {
			grade = "B";
			if(score>=85) grade += "+";
			else grade += "-";
		}else if(score>=70) {
			grade = "C";
			if(score>=75) grade += "+";
			else grade += "-";
		}else {
			grade = "F";
		}
		System.out.println("당신의 학점은 : " + grade);
		
		for(char i='A'; i<='Z'; i++) {
			System.out.println(i);
		}
		
		for(int i=65; i<=90; i++) {
			System.out.println((char)i + " ");
		}
		System.out.println(); // 엔터 처리
		
		for(int i=1; i<=100; i++) {
			System.out.print(i + " ");
			if(i%10 == 0) {
				System.out.println();
			}
		}
		
		// 입사시험(가장 많이 나오는 문제)
		// 구구단(행, 열)
		for(int i=2; i<10; i++) {
			for(int j=2; j<10; j++) {
//				System.out.print(i+"*"+j+"="+i*j+"\t");
				System.out.printf("%d*%d=%d\t", i,j,i*j);
			}
			System.out.println();
		}
	}
}
