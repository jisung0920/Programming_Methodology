package BankObjects;

import java.sql.Date;

public class Transaction {
	private Date time;
	private int amount;
	private String depositId;
	private String withdrawId;
	public Transaction(Date time, int amount, String depositId, String withdrawId) {
		this.time = time;
		this.amount = amount;
		this.depositId = depositId;
		this.withdrawId = withdrawId;
	}

	
	public String getTransactionInfo() {
		String record;
		record =this.time + "|" + this.amount+"|"+this.withdrawId+"->"+this.depositId;
		return record;
	}

	
	
	public Date getTime() {
		return time;
	}



	public void setTime(Date time) {
		this.time = time;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public String getDepositId() {
		return depositId;
	}



	public void setDepositId(String depositId) {
		this.depositId = depositId;
	}



	public String getWithdrawId() {
		return withdrawId;
	}



	public void setWithdrawId(String withdrawId) {
		this.withdrawId = withdrawId;
	}

	
}
