import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.CopyEmp;
import kr.or.kosa.Emp;

class Product {
	int price;
	int bonuspoint;
	
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product {
	KtTv() { // 부모의 생성자를 호출
		super(500);
	}
	
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product {
	Audio() { // 부모의 생성자를 호출
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product {
	NoteBook() { // 부모의 생성자를 호출
		super(150);
	}
	
	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex07_Generic_Product {
	public static void main(String[] args) {
		// 1. Array 사용해서 카트 만들기 >> KtTv, Audio, NoteBook을 담을 수 있는 카트 만들기
		Product[] cart = new Product[3]; 
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		// 단점 >> 방(배열)의 크기를 설정해야 한다는 단점이 있다
		
		// 2. ArrayList를 사용해서 카트 만들기
		List<Product> pcart = new ArrayList<>();
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new NoteBook());
		// 장점 >> 동적으로 방(배열)의 크기를 확장시킨다는 장점이 있다
		// 출력
		for(Product product : pcart) {
			System.out.println(product.toString());
		}
		
		// Emp
		// 3. ArrayList를 사용해서 사원 3명 만들기
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(100, "김유신", "장군"));
		empList.add(new Emp(200, "박씨", "IT"));
		empList.add(new Emp(300, "이씨", "영업"));
		
		// 사원의 정보를 toString()을 사용하지 않고 사번, 이름, 직종 출력
		// 3.1 개선된 for문 사용
		for(Emp emp : empList) {
			System.out.println("사번:" + emp.getEmpno() + ", 이름:" + emp.getEname() + ", 직종:" + emp.getJob());
		}
		System.out.println();
		
		// 3.2 일반 for문 사용
		for(int i=0; i<empList.size(); i++) {
			System.out.println("사번:" + empList.get(i).getEmpno() + ", 이름:" + empList.get(i).getEname() + ", 직종:" + empList.get(i).getJob());
		}
		System.out.println();
		
		// ArrayList를 사용해서 사원 3명을 만드세요 (CopyEmp)
		List<CopyEmp> copyEmpList = new ArrayList<>();
		copyEmpList.add(new CopyEmp(100, "김씨", 1000));
		copyEmpList.add(new CopyEmp(200, "이씨", 2000));
		copyEmpList.add(new CopyEmp(300, "박씨", 5000));	
		
		// 4.1 200번 사원의 급여를 6000으로 수정
		// 일반 for문 사용, getter, setter 이용
		for(int i=0; i<copyEmpList.size(); i++) {
			if(copyEmpList.get(i).getEmpno()==200) {
				copyEmpList.get(i).setSal(6000);
			}
		}
		
		// 4.2 300번 사원의 이름을 박씨 -> 궁금해씨로 수정하고 결과 출력
		// 개선된 for문 사용
		for(CopyEmp copyEmp : copyEmpList) {
			if(copyEmp.getEmpno() == 300) {
				copyEmp.setEname("궁금해씨");
			}
		}
		
		// 출력
		for(CopyEmp copyEmp : copyEmpList) {
			System.out.println("사번:" + copyEmp.getEmpno() + ", 이름:" + copyEmp.getEname() + ", 급여:" + copyEmp.getSal());
		}
		System.out.println();
	}
}