package com.des.ordermanagement;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private int distance;
	private int itemQuantity;
	private EquipmentItem equipment;
	private double discount = 0.00;  //default no discount
    NumberFormat nf = NumberFormat.getCurrencyInstance();
	
	public Order() {}
	
	//no discount order
	public Order(int distance, int itemQuantity, EquipmentItem equipment) {
		
		this.distance = distance;
		this.itemQuantity = itemQuantity;
		this.equipment = equipment;
	}

	//no discount order
	public Order(int distance, int itemQuantity, EquipmentItem equipment, double discount) {
			
		this.distance = distance;
		this.itemQuantity = itemQuantity;
		this.equipment = equipment;
		this.discount = discount;
	}
	
	public String toString() {
		
		return "Item Ordered = " + equipment.getDescription() + " Item Quantity = " + itemQuantity + " Distance = " + distance
				+ " Discount = " + discount + "% Total Order Cost = " + nf.format(getTotal());
	
	}
	
	public double getTotal() {
		
		return equipment.getPrice() * itemQuantity * ((100-discount)/100);
	}
	
	public int getDistance() {return distance;}
	public void setDistance(int distance) {this.distance = distance;}

	public int getItemQuantity() {return itemQuantity;}
	public void setItemQuantity(int itemQuantity) {this.itemQuantity = itemQuantity;}

	public EquipmentItem getEquipment() {return equipment;}
	public void setEquipment(EquipmentItem equipment) {this.equipment = equipment;}

	public double getDiscount() {return discount;}
	public void setDiscount(double discount) {this.discount = discount;}


}
