package com.des.membership;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RunMembership {

	
	public static void main(String[] args) {
		//set expire date from 1 year from now
		Calendar calendar = new GregorianCalendar();
		Date currentDate = calendar.getTime();
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, 1);
		Date nextYear = calendar.getTime();
		
		//create a basic membership
		Membership membership = new NESAMembership();
		membership.setFirstName("Jane");
		membership.setLastName("Doe");
		membership.setAge(24);
		membership.setExpireDate(nextYear);
		
		System.out.println(membership.toString() + membership.getDescription() + " Total Cost = $" + membership.cost());
		
		//create a membership including pool & gym
		Membership membership2 = new NESAMembership();
		
		membership2= new PoolMembership (membership2);
		
		membership2 = new GymMembership (membership2);
		membership2.setFirstName("John");
		membership2.setLastName("Smith");
		membership2.setAge(32);
		membership2.setExpireDate(nextYear);
		membership2.setHasPool(true);
		
		System.out.println(membership2.toString() + membership2.getDescription() + " Total Cost = $" + membership2.cost());
		

	}

}
