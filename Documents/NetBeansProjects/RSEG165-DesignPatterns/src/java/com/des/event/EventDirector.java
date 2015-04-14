package com.des.event;

import java.util.ArrayList;

public class EventDirector {

	private EventBuilder eventBuilder;
	
	
	public EventDirector(EventBuilder eventBuilder) {
		this.eventBuilder = eventBuilder;
	}
	
	public Event getEvent () {return this.eventBuilder.getEvent();}
	
	public void constructEvent(String name, String location, String ages,
			Double cost, ArrayList attendees) {
		
		eventBuilder.buildEventType();
		eventBuilder.buildEventName(name);
		eventBuilder.buildLocation(location);
		eventBuilder.buildAgeRange(ages);
		eventBuilder.buildPrice(cost);
		eventBuilder.buildAttendees(attendees);
		
	}
}
