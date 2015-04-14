package com.des.membership;

public class FamilyMembership extends OptionsDecorator {

	Membership membership;
	
	public FamilyMembership (Membership membership) {
		
		this.membership = membership;
		
	}
	
	public String getDescription() {
		
		return membership.getDescription() + ",  + All Courts Member ";
	}

	public double cost() {
		
		return membership.cost() + 15.00;
	}

	
	
}
