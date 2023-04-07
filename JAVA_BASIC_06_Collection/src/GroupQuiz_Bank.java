import java.util.ArrayList;

import kr.or.kosa.Account;
import kr.or.kosa.Bank;
import kr.or.kosa.Transaction;

public class GroupQuiz {
	public static void main(String[] args) {
		Bank bank = new Bank();
				
		bank.addAccount("10071", "백");
		bank.addAccount("890113", "택");
		bank.addAccount("0113", "택");
		bank.addAccount("987654321", "두팔");
		
		System.out.println("= 전체 계좌 목록 =");
		for(Account account : bank.getAccounts()) {
			System.out.println(account.toString());
		}
		System.out.println();
		
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println(bank.getAccount("890113"));
		Account account = bank.getAccount("890113");
		System.out.println();		
		
		account.deposit(200000);
		System.out.println();
		
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println(bank.getAccount("890113"));
		System.out.println();
		
		account.deposit(200000);
		System.out.println();
		
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println(bank.getAccount("890113"));
		System.out.println();
		
		System.out.println("= 해당 소유자명의 계좌 목록 =");
		ArrayList<Account> accountlist = bank.findAccounts("택");
		for(Account accounts : accountlist) {
			System.out.println(accounts.toString());
		}
		System.out.println();
		
		account.withdraw(5500);
		System.out.println();
		
		System.out.println("= 해당 계좌번호의 계좌정보 =");
		System.out.println(bank.getAccount("890113"));
		System.out.println();
		
		System.out.println("= 거래 내역 =");
		ArrayList<Transaction> transactionList = account.getTransactions();
		for(Transaction transaction : transactionList) {
			System.out.println(transaction);
		}
	}
}
