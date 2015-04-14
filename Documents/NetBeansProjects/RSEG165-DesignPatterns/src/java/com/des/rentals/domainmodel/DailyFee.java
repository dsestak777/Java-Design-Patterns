package com.des.rentals.domainmodel;

public class DailyFee implements FeeModel {
	
	private static double rate = 5.00; 
	
	public double calcuateFee(int length) {
		
		double fee = length * rate;
		
		return fee;
		
	}

	
}
