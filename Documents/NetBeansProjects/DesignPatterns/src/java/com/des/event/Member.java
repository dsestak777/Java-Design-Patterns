package com.des.event;

import java.util.Date;

public class Member {

	private String firstName;
	private String lastName;
	private int age;
	private Date expireDate;
	private String memberType;
	
	public Member (String firstName, String lastName, int age, Date expireDate, String memberType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.expireDate = expireDate;
		this.memberType = memberType;
		
	}
	
	
	
}
