package kr.or.kosa;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private int totalAccount;
	
	public void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
		this.totalAccount++;
	}
	
	public Account getAccount(String accountNo) {
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountNo().equals(accountNo)) {
				return accounts.get(i);
			}
		}
		return null;
	}

	public ArrayList<Account> findAccounts(String name) {
		ArrayList<Account> findAccountsByName = new ArrayList<Account>();
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getName().equals(name)) {
				findAccountsByName.add(accounts.get(i));
			}
		}
		return findAccountsByName;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public int getTotalAccount() {
		return totalAccount;
	}
	
	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + ", totalAccount=" + totalAccount + "]";
	}
}
