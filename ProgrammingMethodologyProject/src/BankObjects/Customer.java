package BankObjects;

import java.util.ArrayList;

public class Customer extends User {

	String id;
	String pw;
	String name;
	ArrayList<Account> accounts;
	
	public Customer(String id, String pw, String name) {
		super(id,pw);
		this.id = id;
		this.pw = pw;
		this.name = name;
		accounts = new ArrayList<Account>();
		// TODO Auto-generated constructor stub
	}

	public boolean identifyCustomer(String id, String pw) {
		if(getId().equals(id)&&getPw().equals(pw))
			return true;
		return false;
	}
	public ArrayList<String> getAccountId(){
		ArrayList<String> id = new ArrayList<String>();
		for(int i=0;i<accounts.size();i++)
			id.add(accounts.get(i).getAccountId()+" : "+accounts.get(i).getBalance());
		return id;
	}
	
	public ArrayList<String> getCustomerTransaction(){
		ArrayList<String> transactions  = new ArrayList<String>();
		for(int i=0;i<this.getAccounts().size();i++) 
			for(int j =0; j<this.getAccounts().get(i).getTransacInfo().size();j++)
				transactions.add(this.getAccounts().get(i).getTransacInfo().get(j).getTrascationInfo());
		return transactions;
	}
	
	public int getAllBalance() {
		int balance=0;
		for(int i=0;i<accounts.size();i++) {
			balance +=accounts.get(i).getBalance();
		}
		return balance;
	}
	public int getNumAccount() {
		return accounts.size();
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
