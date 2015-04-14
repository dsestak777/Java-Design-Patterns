package com.des.ordermanagement;

import java.util.ArrayList;
import java.util.List;

public class HoustonProcessor implements OrderChain {

	private OrderChain nextInChain;

	public void setNext(OrderChain c) {
		nextInChain = c;
	}

	public void process(Order request) {

		//get inventory level
		int inventory = request.getEquipment().getHoustonInv();	
	
		//check distance from warehouses
		if (request.getDistance() <= 400 && request.getItemQuantity() <= inventory) {
			
					
					//calculate inventory reduction
					
					int newInv = inventory - request.getItemQuantity();
					
					//set new inventory levels
					request.getEquipment().setHoustonInv(newInv);
					
					System.out.println ("Processing Order @ Houston Warehouse \n"  
							+ "Order Details " + request.toString());
					System.out.println ("New " + request.getEquipment().getDescription() + " Inventory Level @ Houston = " + newInv + "\n");
				
			
		} else {
			System.out.println ("Houston Warehouse not Closest Warehouses or Insufficient Inventory Forward Request to Next Warehouse!");
			nextInChain.process(request);
		}
	}
	
}
