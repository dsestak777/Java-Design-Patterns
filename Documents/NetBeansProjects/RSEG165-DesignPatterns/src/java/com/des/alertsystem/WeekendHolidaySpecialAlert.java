package com.des.alertsystem;

import java.util.*;

public class WeekendHolidaySpecialAlert implements AlertObserver, DisplayElement {
	
	private static int WEEKEND_HOLIDAY_SPECIAL_ALERT = 1;
	private String location;
	private String date;
	private int type;
	private double discount;
	private String message;
	private AlertData alertData;

	public WeekendHolidaySpecialAlert(AlertData alertData) {
		this.alertData = alertData;
		alertData.registerObserver(this);
	}

	public void update(String location, String date, int type, double discount, String message) {
		
		if (alertData.getType() == WEEKEND_HOLIDAY_SPECIAL_ALERT) {
		display();
		
		} else {
			
			// ignore alert
		}
	}

	public void display() {
	
		System.out.println("Weekend/Holiday Special Alert");
		System.out.println(alertData.getMessage());
		System.out.println("Location: " + alertData.getLocation());
		System.out.println("Date: " + alertData.getDate() +"\n");
		
	}
}
