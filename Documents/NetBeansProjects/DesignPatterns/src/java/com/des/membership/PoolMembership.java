package com.des.membership;

public class PoolMembership extends OptionsDecorator {

	Membership membership;
	
	public PoolMembership (Membership membership) {
		
		this.membership = membership;
		
	}
	
	public String getDescription() {
		
		return membership.getDescription() + ",  + Pool Member ";
	}

	public double cost() {
		
		return membership.cost() + 25.00;
	}

	
	
}
