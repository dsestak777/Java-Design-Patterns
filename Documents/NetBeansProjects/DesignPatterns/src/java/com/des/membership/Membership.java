package com.des.membership;

import java.util.Date;

public abstract class Membership {
	
	private String firstName;
	private String lastName;
	private int age;
	private Date expireDate;
	private boolean hasPool;
	private boolean hasGym;
	private boolean hasAllCourts;
	private boolean hasEquipment;
	private boolean has24Hours;
	private boolean hasFamily;
	String memberType = "unknown membership type";
	
	public abstract double cost();
	
	public String getDescription () {
		
		return "Membership Description: " + memberType;
	}
	
	public String toString() {return firstName + " " + lastName + " " + age + " "+ expireDate + " ";}
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	public Date getExpireDate() {return expireDate;}
	public void setExpireDate(Date expireDate) {this.expireDate = expireDate;	}
	public boolean isHasPool() {return hasPool;}
	public void setHasPool(boolean hasPool) {this.hasPool = hasPool;}

	public boolean isHasGym() {return hasGym;}
	public void setHasGym(boolean hasGym) {this.hasGym = hasGym;}

	public boolean isHasAllCourts() {return hasAllCourts;}
	public void setHasAllCourts(boolean hasAllCourts) {this.hasAllCourts = hasAllCourts;}

	public boolean isHasEquipment() {return hasEquipment;}
	public void setHasEquipment(boolean hasEquipment) {this.hasEquipment = hasEquipment;}

	public boolean isHas24Hours() {return has24Hours;}
	public void setHas24Hours(boolean has24Hours) {this.has24Hours = has24Hours;}

	public boolean isHasFamily() {return hasFamily;}
	public void setHasFamily(boolean hasFamily) {this.hasFamily = hasFamily;}
}
