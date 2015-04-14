package com.des.alertsystem;

import java.util.*;

public class StoreDiscountAlert implements AlertObserver, DisplayElement {
	
	private static int STORE_DISCOUNT_ALERT = 3;
	private String location;
	private String date;
	private int type;
	private double discount;
	private String message;
	private AlertData alertData;

	public StoreDiscountAlert(AlertData alertData) {
		this.alertData = alertData;
		alertData.registerObserver(this);
	}

	public void update(String location, String date, int type, double discount, String message) {
		
		if (alertData.getType() == STORE_DISCOUNT_ALERT) {
		display();
		
		} else {
			
			// ignore alert
		}
	}

	public void display() {
	
		System.out.println("Store Discount Alert");
		System.out.println(alertData.getMessage());
		System.out.println("Store Discount Amount = " + alertData.getDiscount()+"%");
		System.out.println("Location: " + alertData.getLocation());
		System.out.println("Date: " + alertData.getDate() +"\n");
		
	}
}
