package com.des.alertsystem;

import java.util.ArrayList;
	
public class CurrentAlertDisplay implements AlertObserver, DisplayElement {
	private ArrayList observers;
	private String location;
	private String date;
	private int type;
	private double discount;
	private String message;
	
//	private float temperature;
//	private float humidity;
	private AlertSubject alertData;
	
	public CurrentAlertDisplay(AlertSubject alertData) {
		this.alertData = alertData;
		alertData.registerObserver(this);
	}
	
	public void update(String location, String date, int type, double discount, String message) {
		this.location = location;
		this.date = date;
		this.type = type;
		this.discount = discount;
		this.message = message;
		display();
	}
	
	public void display() {
	//	System.out.println("Current conditions: " + temperature 
	//		+ "F degrees and " + humidity + "% humidity");
	}

	
}
