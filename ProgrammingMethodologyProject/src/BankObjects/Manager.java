package BankObjects;

public class Manager extends User {

	private Bank bank;
	public Manager(String id, String pw) {
		super(id,pw);
		// TODO Auto-generated constructor stub
	}
	public void makeBank(String bankName) {
		System.out.println("make bank");
		this.bank = new Bank(bankName);
	}
	
	public boolean login(String id, String pw) {
		if(this.id.equals(id)&&this.pw.equals(pw))
			return true;
		return false;
	}
	
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	

	
}
