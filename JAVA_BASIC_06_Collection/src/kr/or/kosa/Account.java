package kr.or.kosa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
	private String accountNo;
	private String name;
	private long balance;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
	}
	
	public void deposit(long amount) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTrans = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
		DateTimeFormatter timeTrans = DateTimeFormatter.ofPattern("HH시mm분");
		String transactionDate = now.format(dateTrans);
		String transactionTime = now.format(timeTrans);
		System.out.println(amount + "원 입금하셨습니다.");
		
		this.transactions.add(new Transaction(amount, "deposit", transactionDate, transactionTime, this.balance));			
		this.balance += amount;
		System.out.println("현재 잔액은 " + balance + "원 입니다.");
	}
	
	public void withdraw(long amount) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTrans = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
		DateTimeFormatter timeTrans = DateTimeFormatter.ofPattern("HH시mm분");
		String transactionDate = now.format(dateTrans);
		String transactionTime = now.format(timeTrans);
		System.out.println(amount + "원 출금하셨습니다.");
		
		this.transactions.add(new Transaction(amount, "withdrow", transactionDate, transactionTime, this.balance));		
		this.balance -= amount;
		System.out.println("현재 잔액은 " + balance + "원 입니다.");
	}
	
	public long getBalance() {
		return balance;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public String getAccountNo() {
		return this.accountNo;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "[계좌번호 :" + accountNo + ", 소유자 명 : " + name + ", 잔액 : " + balance + "]";
	}	
}
