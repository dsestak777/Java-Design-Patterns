package com.des.membership;

public class GymMembership extends OptionsDecorator {

	Membership membership;
	
	public GymMembership (Membership membership) {
		
		this.membership = membership;
		
	}
	
	public String getDescription() {
		
		return membership.getDescription() + ",  + Gym Member ";
	}

	public double cost() {
		
		return membership.cost() + 20.00;
	}

	
	
}
