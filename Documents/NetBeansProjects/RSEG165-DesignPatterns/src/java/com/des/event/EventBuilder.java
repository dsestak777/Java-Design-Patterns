package com.des.event;

import java.util.ArrayList;

public interface EventBuilder {

	public void buildEventType();
	public void buildEventName(String name);
	public void buildLocation(String location);
	public void buildAgeRange(String age);
	public void buildPrice(Double price);
	public void buildAttendees(ArrayList attendees);
	public Event getEvent();
	
}
