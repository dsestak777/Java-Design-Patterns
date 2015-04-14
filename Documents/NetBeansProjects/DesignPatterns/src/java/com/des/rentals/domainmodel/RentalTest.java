package com.des.rentals.domainmodel;

import java.util.ArrayList;
import java.util.Date;

import com.des.rentals.servicelayer.*;

public class RentalTest {
	static ApplicationService as;
	
	public static void main (String[] blargs) {
	//Get the date
	Date date = new Date();
	//create arraylist to hold inventory	
	ArrayList<Equipment> equipInventory = new ArrayList<>();
	
	//create a member
	Membership member = new Membership ("Joe", "Smith"); 
	
	//create fee model instances
	FeeModel dailyFee = new DailyFee();
	FeeModel weeklyFee = new WeeklyFee();
	FeeModel monthlyFee = new MonthlyFee();
	
	//create equipment inventory items
	Equipment tennisRacket = new Equipment ("Tennis Racket", dailyFee);
	Equipment badminitinRacket = new Equipment ("Badmintin Racket", dailyFee);
	Equipment skis = new Equipment ("Skis", weeklyFee);
	Equipment skates = new Equipment ("Skates", monthlyFee);
	
	//add items to inventory
	equipInventory.add(tennisRacket);
	equipInventory.add(badminitinRacket);
	equipInventory.add(skis);
	equipInventory.add(skates);
	
	//create new rental
	Rental rental1 = new Rental(tennisRacket, member, date, 4);
	System.out.println(rental1.toString());
	double rentalFee = ApplicationService.getRentalFeeService().calculateRevenue(rental1);
	System.out.println("Rental Fee = " + rentalFee);
	
	}
}
