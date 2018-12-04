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
