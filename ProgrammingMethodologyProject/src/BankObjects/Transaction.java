package BankObjects;

import java.sql.Date;

public class Transaction {
	private Date time;
	private int amount;
	private String depositId;
	private String withdrawId;
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String record;
		record =this.time + "|" + this.amount+"|"+this.withdrawId+"->"+this.depositId;
		return record;
	}
}