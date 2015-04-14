package com.des.rentals.domainmodel;

public class MonthlyFee implements FeeModel {
	
	private static double rate = 75.00; 
	
	public double calcuateFee(int length) {
		
		double fee = (length/30) * rate;
		
		return fee;
		
	}

	
}
