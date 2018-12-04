package BankObjects;

public class Manager extends User {

	private String id;
	private String pw;
	private Bank bank;
	public Manager(String id, String pw) {
		super(id,pw);
		this.id = id;
		this.pw = pw;
		// TODO Auto-generated constructor stub
	}
	public void makeBank(String bankName) {
		this.bank = new Bank(bankName);
	}
	
	public boolean login(String id, String pw) {
		if(this.id.equals(id)&&this.pw.equals(pw))
			return true;
		return false;
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
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	

	
}
