package BankObjects;

import java.util.ArrayList;

public class Bank {

	private ArrayList<Customer> customers;
	private int charge;
	private float interest;
	private String bankName;
	public Bank(String name) {
		this.customers = new ArrayList<Customer>();
		this.charge = 0;
		this.interest = 0;
		this.bankName = name;
		// TODO Auto-generated constructor stub
	}

	public boolean hasId(String id) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getId().equals(id))
				return true;
		}
		return false;
	}
	public ArrayList<String> getCustomersName(){
		ArrayList<String> names = new ArrayList<String>();
		for(int i=0;i<customers.size();i++)
			names.add(customers.get(i).getId()+" | "+customers.get(i).getName()+" : "+customers.get(i).getAllBalance());
		return names;
	}
	public Account getAccount(String id) {
		for(int i=0; i<customers.size();i++) 
			for(int j=0;j<customers.get(i).getAccounts().size();j++) 
				if(id.equals(customers.get(i).getAccounts().get(j).getAccountId()))
					return customers.get(i).getAccounts().get(j);		
		return null;
	}
	public ArrayList<String> getAllAccountName(){
		ArrayList<String> accountNames = new ArrayList<String>();
		for(int i=0; i<customers.size();i++) 
			for(int j=0;j<customers.get(i).getAccounts().size();j++) 
				accountNames.add(customers.get(i).getAccounts().get(j).getAccountId());
		
		return accountNames;
	}
	public ArrayList<String> getAllTranscation(){
		ArrayList<String> transactions = new ArrayList<String>();
		for(int i=0; i<customers.size();i++) 
			for(int j=0;j<customers.get(i).getAccounts().size();j++) 
				for(int k=0; k<customers.get(i).getAccounts().get(j).getTransacInfo().size();k++)
					transactions.add(customers.get(i).getAccounts().get(j).getTransacInfo().get(k).getTrascationInfo());
		
		return transactions;
		
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}

	
}
