package com.des.event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class EventTest {
	
	public static void main(String[] args) {
		SummerCampBuilder summerCampBuilder = new SummerCampBuilder();
		EventDirector director = new EventDirector(summerCampBuilder);
		
		SportsClinicBuilder sportsClinicBuilder = new SportsClinicBuilder();
		EventDirector director2 = new EventDirector(sportsClinicBuilder);
		
		ArrayList<Member> attendees = new ArrayList<>();
		
		//set expire date from 1 year from now
				Calendar calendar = new GregorianCalendar();
				Date currentDate = calendar.getTime();
				calendar.setTime(currentDate);
				calendar.add(Calendar.YEAR, 1);
				Date nextYear = calendar.getTime();
				
		//create Gym Members
		Member member1 = new Member("Jane", "Doe", 24, nextYear, "Basic");
		Member member2 = new Member("John", "Smith", 32, nextYear, "Basic + Pool + Gym");
		
		attendees.add(member1);
		attendees.add(member2);
		
		//create some Events
		director.constructEvent("Youth Camp", "Camp Yellowstone", "8 to 12 Years", 150.00, attendees);
		director2.constructEvent("Putting Clinic", "Palm Beach", "all ages", 200.00, attendees);
		
		Event event = director.getEvent();
		System.out.println (event.toString());
		
		Event event2 = director2.getEvent();
		System.out.println (event2.toString());
	}

}
