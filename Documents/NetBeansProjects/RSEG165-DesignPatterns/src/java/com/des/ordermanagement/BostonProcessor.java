package com.des.ordermanagement;

import java.util.ArrayList;
import java.util.List;

public class BostonProcessor implements OrderChain {

	private OrderChain nextInChain;
//	private List<EquipmentItem> equipment = new ArrayList<>();

	public void setNext(OrderChain c) {
		nextInChain = c;
	}

	public void process(Order request) {
		//get inventory level
		int inventory = request.getEquipment().getBostonInv();
		
		//check distance from warehouses && inventory levels
		if (request.getDistance() <= 100 && request.getItemQuantity() <= inventory) {
			
					//calculate inventory reduction
					
					int newInv = inventory - request.getItemQuantity();
					
					//set new inventory levels
					request.getEquipment().setBostonInv(newInv);
					
					System.out.println ("Processing Order @ Boston Warehouse \n"  
							+ "Order Details " + request.toString());
					System.out.println ("New " + request.getEquipment().getDescription() + " Inventory Level @ Boston = " + newInv + "\n");
					
			
		} else {
			System.out.println ("Boston Warehouse not Closest Warehouses or Insufficient Inventory Forward Request to Next Warehouse!");
			nextInChain.process(request);
		}
	}
	
}
