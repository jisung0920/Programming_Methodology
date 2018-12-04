package BankObjects;

import java.util.ArrayList;

public class Customer extends User {

	String id;
	String pw;
	String name;
	ArrayList<Account> accounts;
	
	public Customer(String id, String pw, String name) {
		super(id,pw);
		this.name = name;
		accounts = new ArrayList<Account>();
		// TODO Auto-generated constructor stub
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
