package com.des.membership;

public class AllHoursMembership extends OptionsDecorator {

	Membership membership;
	
	public AllHoursMembership (Membership membership) {
		
		this.membership = membership;
		
	}
	
	public String getDescription() {
		
		return membership.getDescription() + ",  + All Hours Member ";
	}

	public double cost() {
		
		return membership.cost() + 5.00;
	}

	
	
}
