package BankObjects;

import java.util.ArrayList;

public class Account {

	private String accountId;
	private int balance;
	private ArrayList<Transaction> transacInfo;
	public Account(String accountId) {
		this.accountId = accountId;
		this.balance = 0;
		transacInfo = new ArrayList<Transaction>();
	
	}
	
	
	public String getAllTransaction() {
		String tranInfo = "";
		for(int i=0;i<transacInfo.size();i++)
			tranInfo += transacInfo.get(i).getTransactionInfo()+ "\n";
		return tranInfo;
	}
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public ArrayList<Transaction> getTransacInfo() {
		return transacInfo;
	}
	public void setTransacInfo(ArrayList<Transaction> transacInfo) {
		this.transacInfo = transacInfo;
	}
	
	
}
