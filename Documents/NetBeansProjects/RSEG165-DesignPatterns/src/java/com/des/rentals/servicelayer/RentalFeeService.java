package com.des.rentals.servicelayer;

import com.des.rentals.domainmodel.*;

//singleton pattern
public class RentalFeeService extends ApplicationService {

	private static RentalFeeService uniqueInstance;
	private double revenue;
	
	
	private RentalFeeService() {}
	
	//make synchronized for multithreading
	public static synchronized RentalFeeService getInstance() {
		
		//lazy loader pattern
		if (uniqueInstance == null) {
			
			uniqueInstance = new RentalFeeService();
		}
		
		return  uniqueInstance;
	}
	
	public double calculateRevenue(Rental rental) {
		
			
		
			revenue = rental.getEquipment().getFeeModel().calcuateFee(rental.getLengthOfRental());
			
			return revenue;
		}

	


}
