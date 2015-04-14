package com.des.membership;

public class EquipmentMembership extends OptionsDecorator {

	Membership membership;
	
	public EquipmentMembership (Membership membership) {
		
		this.membership = membership;
		
	}
	
	public String getDescription() {
		
		return membership.getDescription() + ",  + Equipment Member ";
	}

	public double cost() {
		
		return membership.cost() + 10.00;
	}

	
	
}
