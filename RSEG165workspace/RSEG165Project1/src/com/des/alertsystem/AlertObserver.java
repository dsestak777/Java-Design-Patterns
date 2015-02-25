package com.des.alertsystem;

public interface AlertObserver {
	public void update(String location, String date, int type, double discount, String message);
}
