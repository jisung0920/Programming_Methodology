package BankObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private int type;
	/* 0 : deposit
	 * 1 : withdraw
	 * 2 : transfer */
	private Date time;
	private int amount;
	private String myId,toId;
	public Transaction(int type,Date date,int amount,String from, String to) {
		this.type = type;
		this.time = date;
		this.amount = amount;
		this.myId = from;
		this.toId = to;
		// TODO Auto-generated constructor stub
		
	}
	public Transaction(int type,Date date,int amount,String myId) {
		this.type = type;
		this.time = date;
		this.amount = amount;
		this.myId = myId;
	}

	public String getTrascationInfo() {
		SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm:ss");
		String information = myId.substring(0,9) +" | "+dateformat.format(this.time) +" | "+this.amount+ " | ";
		if(this.type==0) {
			return information+":입";
		}else if(this.type==1) {
			return information+":출";			
		}
		else
			return information+":이체"+" - "+this.toId;
	}
	
}
