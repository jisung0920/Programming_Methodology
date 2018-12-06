package BankObjects;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import BankSystems.InputProcesser;

public abstract class Account {

	public String accountId;
	public int balance;
	public ArrayList<Transaction> transacInfo;
	public Account(String accountId) {
		this.accountId = accountId;
		this.balance = 0;
		transacInfo = new ArrayList<Transaction>();
	
	}
	
	
	public String getAllTransaction() {
		String tranInfo = "";
		for(int i=0;i<transacInfo.size();i++)
			tranInfo += transacInfo.get(i).getTrascationInfo()+ "\n";
		return tranInfo;
	}
	public boolean transfeAccount(Account to,int value,int charge) {
		if(value+charge>getBalance())
			return false;
		this.setBalance(getBalance()-(value+charge));
		to.setBalance(value+getBalance());		
		transacInfo.add(new Transaction(2, new Date(), value, getAccountId(),to.getAccountId()));
		
		return true;
		
	}
	public boolean withdrawAccount(int value) {
		if(value>getBalance())
			return false;
		this.setBalance(getBalance()-value);
		transacInfo.add(new Transaction(1, new Date(), value, getAccountId()));
		
		return true;	
	}
	public boolean depositAccount(int value) {
		if(getBalance()+value>100000000)
			return false;
		this.setBalance(value+getBalance());
		transacInfo.add(new Transaction(0, new Date(), value, getAccountId()));
		return true;
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
