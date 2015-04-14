package com.des.membership;

public class AllCourtsMembership extends OptionsDecorator {

	Membership membership;
	
	public AllCourtsMembership (Membership membership) {
		
		this.membership = membership;
		
	}
	
	public String getDescription() {
		
		return membership.getDescription() + ",  + All Courts Member ";
	}

	public double cost() {
		
		return membership.cost() + 15.00;
	}

	
	
}
