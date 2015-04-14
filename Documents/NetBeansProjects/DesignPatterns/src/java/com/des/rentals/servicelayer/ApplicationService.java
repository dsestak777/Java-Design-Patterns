package com.des.rentals.servicelayer;

import com.des.rentals.domainmodel.*;

public abstract class ApplicationService {

	
	ApplicationService as;
	
	
	public static RentalFeeService getRentalFeeService() {
		
		return RentalFeeService.getInstance();
	}
		
	
	
	
}
