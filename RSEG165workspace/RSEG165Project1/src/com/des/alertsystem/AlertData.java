package com.des.alertsystem;

import java.util.*;

public class AlertData implements AlertSubject {
	private ArrayList observers;
	private String location;
	private String date;
	private int type;
	private double discount;
	private String message;
	
//	private float temperature;
//	private float humidity;
//	private float pressure;
	
	public AlertData() {
		observers = new ArrayList();
	}
	
	public void registerObserver(AlertObserver o) {
		observers.add(o);
	}
	
	public void removeObserver(AlertObserver o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			AlertObserver observer = (AlertObserver)observers.get(i);
			observer.update(location, date, type, discount, message);
		}
	}
	
	public void alertChanged() {
		notifyObservers();
	}
	
//	public void setMeasurements(float temperature, float humidity, float pressure) {
//		this.temperature = temperature;
//		this.humidity = humidity;
//		this.pressure = pressure;
//		alertChanged();
//	}
	
	public void setAlert(String location, String date, int type, double discount, String message) {
		this.location = location;
		this.date = date;
		this.type = type;
		this.discount = discount;
		this.message = message;
		alertChanged();
	}

	public String getLocation() {
		return location;
	}

	public String getDate() {
		return date;
	}

	public int getType() {
		return type;
	}

	public double getDiscount() {
		return discount;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	

}
