package com.des.event;

import java.util.ArrayList;
import java.util.List;

public class Event implements EventPlan {

	private String eventType ;
	private String eventName;
	private String location;
	private String ageRange;
	private double price;
	private ArrayList<Member> attendees = new ArrayList<>();
	
	public Event() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "Event [eventType= "+ eventType + ", eventName=" + eventName + ", location=" + location
				+ ", ageRange=" + ageRange + ", price=" + price
				+ ", attendees=" + attendees + "]";
	}

	public String getEventType () {return eventType;}
	public void setEventType(String event) {this.eventType = event;}

	public String getLocation() {return location;}
	public void setLocation(String location) {this.location = location;	}

	public String getAgeRange() {return ageRange;}
	public void setAgeRange(String ageRange) {this.ageRange = ageRange;}

	public double getPrice() {return price;	}
	public void setPrice(double price) {this.price = price;	}

	public String getName() {return eventName;}
	public void setEventName (String eventName) {this.eventName = eventName;	}
	
	public ArrayList<Member> getAttendees() {return attendees;}
	public void setAttendees(ArrayList<Member> attendees2) {this.attendees = attendees2;}

	public void addMember (Member attendee) {attendees.add(attendee);}
	public void removeMember (Member attendee) {attendees.remove(attendee);
	
	}



	
	
}
