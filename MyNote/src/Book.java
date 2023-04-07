
import java.util.Scanner;

public class Book {
	Scanner sc = new Scanner(System.in);
	private int ISBN;
	private String bookName;
	private int bookPrice;
	
	public Book() {
		
	}
	
	public Book(String bookName, int bookPrice) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	
	public String getBookName() {
		return this.bookName;
	}
	
	public int getBookPrice() {
		return this.bookPrice;
	}
}
