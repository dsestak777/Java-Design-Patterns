package com.des.rentals.domainmodel;

import java.util.Date;

public class Revenue {

	private double amount;
	private Date date;
	private boolean isRec;
	
	public Revenue (double amount, Date date) {
		this.amount = amount;
		this.date = date;
		
	}
	
	public double getAmount () {
		
		return amount;
	}
	
	public boolean isRecognizable () {
		
		return isRec;
	}
}
