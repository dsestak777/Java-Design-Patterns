package com.des.alertsystem;

public interface AlertSubject {
	public void registerObserver(AlertObserver o);
	public void removeObserver(AlertObserver o);
	public void notifyObservers();
}
