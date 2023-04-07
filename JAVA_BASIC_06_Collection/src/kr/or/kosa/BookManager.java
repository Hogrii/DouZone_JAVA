package kr.or.kosa;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class BookManager {
	Scanner sc = new Scanner(System.in);
	Book book = new Book();
	HashMap<Integer, Book> hashBook = new HashMap<>();
	
	public void addBook() {
		System.out.print("추가할 도서 ISBN:");
		int ISBN = Integer.parseInt(sc.nextLine());
		System.out.print("도서 제목:");
		String bookName = sc.nextLine();
		System.out.print("가격:");
		int bookPrice = Integer.parseInt(sc.nextLine());
		
		hashBook.put(ISBN, new Book(bookName, bookPrice));
		System.out.println("ISBN:" + ISBN + " 이름:" + bookName + " 가격:" + bookPrice + " 생성하였습니다.");
	}
	
	public void deleteBook() {
		System.out.print("삭제할 도서:");
		int ISBN = Integer.parseInt(sc.nextLine());
		hashBook.remove(ISBN);
		System.out.println("삭제하였습니다");
	}
	
	public void searchBook() {
		System.out.print("검색할 도서 ISBN:");
		int ISBN = Integer.parseInt(sc.nextLine());
		String bookName = hashBook.get(ISBN).getBookName();
		int bookPrice = hashBook.get(ISBN).getBookPrice();
		System.out.println("검색 결과>>ISBN"+ISBN + "이름:" + bookName + " 가격:" + bookPrice);
		System.out.println();
	}
	
	public void listBook() {
		System.out.println("도서 목록");
		System.out.println("도서 수:" + hashBook.size());
		for(Entry<Integer, Book> bookEntry : hashBook.entrySet()) {
			System.out.println("ISBN:" + bookEntry.getKey() + " 이름:" + bookEntry.getValue().getBookName() + " 가격:" + bookEntry.getValue().getBookPrice());
		}
	}
	
	public void listISBN() {
		System.out.println("ISBN 목록");
		System.out.println("도서 수:" + hashBook.size());
		for(Entry<Integer, Book> bookEntry : hashBook.entrySet()) {
			System.out.println("ISBN:" + bookEntry.getKey());
		}
	}
	
	public void Run() {
		while(true) {
			System.out.println("1: 추가, 2: 삭제, 3: 검색, 4: 도서 목록, 5: ISBN 목록, 0: 종료");
			String menuNum = sc.nextLine();
			if(menuNum.equals("1")) {
				addBook();
			}else if(menuNum.equals("2")) {
				deleteBook();
			}else if(menuNum.equals("3")) {
				searchBook();
			}else if(menuNum.equals("4")) {
				listBook();
			}else if(menuNum.equals("5")) {
				listISBN();
			}else if(menuNum.equals("0")) {
				System.out.println("종료합니다..");
				System.exit(0);
			}
		}
	}
}
