package com.des.rentals.domainmodel;

public class WeeklyFee implements FeeModel {
	
	private static double rate = 25.00; 
	
	public double calcuateFee(int length) {
		
		double fee = (length/7) * rate;
		
		return fee;
		
	}

	
}
