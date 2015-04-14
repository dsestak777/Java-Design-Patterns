package com.des.alertsystem;

import java.util.*;

public class AlertTest {

	public static void main(String[] args) {
		
		AlertData alertData = new AlertData();
	
		CurrentAlertDisplay currentDisplay = new CurrentAlertDisplay(alertData);
		
		//Register observers 
		WeekendHolidaySpecialAlert weekendAlert = new WeekendHolidaySpecialAlert(alertData);
		FamilyDiscountAlert familyAlert = new FamilyDiscountAlert(alertData);
		StoreDiscountAlert storeAlert = new StoreDiscountAlert(alertData);
		SpecialEventAlert specialEventAlert = new SpecialEventAlert(alertData);
		ClosureAlert closureAlert = new ClosureAlert(alertData);
		
		//send out alerts 
		alertData.setAlert("Pool #1 & #2", "March 15 & 16, 2015", 1, 0, "Free Weekend Pool Access!!");
		alertData.setAlert("NESA", "April 20, 2015", 2, 25, "Special Family Membership Discount!!");
		alertData.setAlert("NESA Equipment Store", "June 8, 2015", 3, 20, "20% OFF ALL ITEMS SALE!!");
		alertData.setAlert("NESA Golf Course", "July 10, 2015", 4, 0, "Special Putting Clinic Event");
		alertData.setAlert("Pool #2", "February 15, 2015", 5, 0, "Pool Closed for Maintenance");
		
	}
}
