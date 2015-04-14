package com.des.alertsystem;

import java.util.*;

public class SpecialEventAlert implements AlertObserver, DisplayElement {
	
	private static int SPECIAL_EVENT_ALERT = 4;
	private String location;
	private String date;
	private int type;
	private double discount;
	private String message;
	private AlertData alertData;

	public SpecialEventAlert(AlertData alertData) {
		this.alertData = alertData;
		alertData.registerObserver(this);
	}

	public void update(String location, String date, int type, double discount, String message) {
   
		if (alertData.getType() == SPECIAL_EVENT_ALERT) {
		display();
		
		} else {
			
			// ignore alert
		}
	}

	public void display() {
	
		System.out.println("Special Event Alert");
		System.out.println(alertData.getMessage());
		System.out.println("Location: " + alertData.getLocation());
		System.out.println("Date: " + alertData.getDate() +"\n");
		
	}
}
