package kr.or.kosa;
/*
책은 이름과 가격정보를 가지고 있다
책이 출판되면 반드시 책 이름과 책 가격정보를 가지고 있어야 한다 >> 무조건 2개를 가지고 만들어져야 한다
책의 이름과 가격정보는 특정 기능을 통해서만 볼 수 있고, 출판된 이후에는 수정 할 수 없다(책 가격, 이름)
책 이름과 가격정보는 각각 확인 할 수 있다
 */
public class Book {
	private String name;
	private int price;
	
	public Book(String str, int num) {
		name = str;
		price = num;
	}
	
	public void getDisplayInfo() {
		System.out.println("책 이름 : " + name + " , 책 가격 : " + price);
	}
	
	public void getBookName() {
		System.out.println("책 이름 : " + name);
	}
	
	public void getBookPrice() {
		System.out.println("책 가격 : " + price);
	}
}
