package com.des.rentals.domainmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.des.rentals.servicelayer.*;

public class Rental implements Serializable{
	private Equipment equipment;
	private Membership member;
	private Date whenRented;
	private Long id;
	private int lengthOfRental;
	
//	private List revenueRecognition = new ArrayList();

	public Rental (Equipment equipment, Membership member, Date whenRented, int lengthOfRental ) {
		
		this.equipment = equipment;
		this.member = member;
		this.whenRented = whenRented;
		this.lengthOfRental = lengthOfRental;
		
	}
	
	@Override
	public String toString() {
		return "Rental [equipment=" + equipment.getName() + ", member=" + member.getFirstName() + " " + member.getLastName() 
				+  ", whenRented=" + whenRented
				+ ", lengthOfRental= " + lengthOfRental + " days]";
	}

	public Equipment getEquipment() {return equipment;}
	public int getLengthOfRental() {return lengthOfRental;}
	
	
}
