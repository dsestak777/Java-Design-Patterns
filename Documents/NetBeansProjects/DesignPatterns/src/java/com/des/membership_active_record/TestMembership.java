package com.des.membership_active_record;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestMembership {
		static Membership mb;
                static Membership member1;
	
	public static void main(String[] args) {
                //create arraylist to hold member objects
		ArrayList<Membership> members = new ArrayList<>();
		
		//set expire date from 1 year from now
		Calendar calendar = new GregorianCalendar();
		Date currentDate = calendar.getTime();
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, 1);
		Date nextYear = calendar.getTime();
		java.sql.Date date = DBUtilities.getCurrentJavaSqlDate();
                
                //delete any existing tables and create new 
                DBUtilities.deleteTables();
                DBUtilities.createTables();
                
		//create new members
		Membership.addMember("Joe", "Jones", 25, date, true, true, false, false, false, false);
		mb.addMember("Sara", "Smith", 23, date, true, true, false, false, false, false);
		mb.addMember("Jane", "Doe", 42, date, false, false, false, false, false, false);
		
		//view all members
		members = mb.viewAllMembers();
                for (Membership member: members) {System.out.println(member.toString());}
		//edit member
		mb.editMember("Sara", "Smith", 23, date, true, true, true, false, true, false, 2);
		//check to see if member exists
		mb.doesMemberExist("Jane", "Doe");
		//delete member
		mb.deleteMember("Jane", "Doe");
		//check to see if member exists
		mb.doesMemberExist("Jane", "Doe");
		
                //view a specific member
		member1 = mb.viewMember("Sara", "Smith");
                System.out.println(member1.isHas24Hours());
		System.out.println(member1.toString());
		System.out.println("Membership Cost = " + mb.membershipCost(member1));
		
	}
}
