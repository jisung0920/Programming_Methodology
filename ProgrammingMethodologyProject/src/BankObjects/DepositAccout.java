package BankObjects;

public class DepositAccout extends Account {

	public DepositAccout(String accountId) {
		super(accountId+"-01");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean transfeAccount(Account to, int value, int charge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdrawAccount(int value) {
		// TODO Auto-generated method stub
		return false;
	}


}
