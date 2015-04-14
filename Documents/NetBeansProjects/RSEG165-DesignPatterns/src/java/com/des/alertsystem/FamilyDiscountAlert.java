package com.des.alertsystem;

import java.util.*;

public class FamilyDiscountAlert implements AlertObserver, DisplayElement {
	
	private static int FAMILY_DISCOUNT_ALERT = 2;
	private String location;
	private String date;
	private int type;
	private double discount;
	private String message;
	private AlertData alertData;

	public FamilyDiscountAlert(AlertData alertData) {
		this.alertData = alertData;
		alertData.registerObserver(this);
	}

	public void update(String location, String date, int type, double discount, String message) {
		
		if (alertData.getType() == FAMILY_DISCOUNT_ALERT) {
		display();
		
		} else {
			
			// ignore alert
		}
	}

	public void display() {
	
		System.out.println("Family Discount Alert");
		System.out.println(alertData.getMessage());
		System.out.println("Family Discount Amount = " + alertData.getDiscount()+"%");
		System.out.println("Location: " + alertData.getLocation());
		System.out.println("Date: " + alertData.getDate() +"\n");
		
	}
}
