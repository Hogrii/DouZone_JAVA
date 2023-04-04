package kr.or.kosa;

public class Transaction {
	private String transactionDate;
	private String transactionTime;
	private String kind;
	private long amount;
	private long balance;
	
	Transaction(long amount, String kind, String transactionDate, String transactionTime, long balance) {
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.kind = kind;
		this.amount = amount;
		if(kind.equals("deposit")) this.balance += balance + amount;
		if(kind.equals("withdrow")) this.balance += balance - amount;
	}
	
	public long getBalance() {
		return this.balance;
	}

	@Override
	public String toString() {
		return "[거래금액:" + amount + ", 잔액:" + balance + "/" + transactionDate + transactionTime + "]";
	}

}
