package com.des.ordermanagement;

public class EquipmentItem {
	
	private String description;
	private int itemNum;
	private int bostonInv;
	private int newYorkInv;
	private int houstonInv;
	private int chicagoInv;
	private int seattleInv;
	private int sanFranInv;
	private double price;
	
	public EquipmentItem() {
		
	}
	
	public EquipmentItem(String description, int itemNum, int bostonInv, int newYorkInv,
			int houstonInv, int chicagoInv, int seattleInv, int sanFranInv, double price) {
		
		this.description = description;
		this.itemNum = itemNum;
		this.bostonInv = bostonInv;
		this.newYorkInv = newYorkInv;
		this.houstonInv = houstonInv;
		this.chicagoInv = chicagoInv;
		this.seattleInv = seattleInv;
		this.sanFranInv = sanFranInv;
		this.price = price;
		
	}

	

	@Override
	public String toString() {
		return "EquipmentItem [description=" + description + ", itemNum="
				+ itemNum + ", bostonInv=" + bostonInv + ", newYorkInv="
				+ newYorkInv + ", houstonInv=" + houstonInv + ", chicagoInv="
				+ chicagoInv + ", seattleInv=" + seattleInv + ", sanFranInv="
				+ sanFranInv + ", price=" + price + "]";
	}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	public int getItemNum() {return itemNum;}
	public void setItemNum(int itemNum) {this.itemNum = itemNum;}

	public int getBostonInv() {return bostonInv;}
	public void setBostonInv(int bostonInv) {this.bostonInv = bostonInv;}

	public int getNewYorkInv() {return newYorkInv;}
	public void setNewYorkInv(int newYorkInv) {this.newYorkInv = newYorkInv;}

	public int getHoustonInv() {return houstonInv;}
	public void setHoustonInv(int houstonInv) {this.houstonInv = houstonInv;}

	public int getChicagoInv() {return chicagoInv;}
	public void setChicagoInv(int chicagoInv) {this.chicagoInv = chicagoInv;}

	public int getSeattleInv() {return seattleInv;}
	public void setSeattleInv(int seattleInv) {this.seattleInv = seattleInv;}

	public int getSanFranInv() {return sanFranInv;}
	public void setSanFranInv(int sanFranInv) {this.sanFranInv = sanFranInv;}

	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}

		
}
