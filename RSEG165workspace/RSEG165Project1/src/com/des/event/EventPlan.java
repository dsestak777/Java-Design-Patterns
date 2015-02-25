package com.des.event;

import java.util.ArrayList;

public interface EventPlan {
	
	public void setEventType(String event);
	public void setLocation(String location);
	public void setAgeRange(String ageRange);
	public void setPrice(double price);
	public void setEventName (String name);
	public void setAttendees(ArrayList<Member> attendees2);

}
