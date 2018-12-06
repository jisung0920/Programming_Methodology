package BankObjects;

public class WithdrawAccount extends Account {

	public WithdrawAccount(String accountId) {
		super(accountId+"-02");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean depositAccount(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
