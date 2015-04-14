package com.des.event;

import java.util.ArrayList;

public class SummerCampBuilder implements EventBuilder {
	
	private Event event;

	public SummerCampBuilder () { this.event = new Event(); }
	
	public void buildEventType() {event.setEventType("Summer Camp");}
	
	public void buildEventName(String name) {event.setEventName(name);}

	public void buildLocation(String location) {event.setLocation(location);}

	public void buildAgeRange(String age) {event.setAgeRange(age);}

	public void buildPrice(Double price) {event.setPrice(price);}

	public void buildAttendees(ArrayList attendees2) {event.setAttendees(attendees2);}
	
	public Event getEvent() { return this.event;}

	
	

}
