package com.des.rentals.domainmodel;

public class Equipment {
	
	private String name;
	private FeeModel feeModel;
	
	public Equipment (String name, FeeModel feeModel) {
		
		this.name = name;
		this.feeModel = feeModel;
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public FeeModel getFeeModel() {return feeModel;}
	public void setFeeModel(FeeModel feeModel) {this.feeModel = feeModel;}
	
}
