package com.des.ordermanagement;

import java.util.ArrayList;
import java.util.List;

public class SanFranProcessor implements OrderChain {

	private OrderChain nextInChain;

	public void setNext(OrderChain c) {
		nextInChain = c;
	}

	public void process(Order request) {

		//get inventory level
		int inventory = request.getEquipment().getSanFranInv();	
	
		//check distance from warehouses
		if (request.getDistance() <= 600 && request.getItemQuantity() <= inventory) {
			
					
					//calculate inventory reduction
					
					int newInv = inventory - request.getItemQuantity();
					
					//set new inventory levels
					request.getEquipment().setSanFranInv(newInv);
					
					System.out.println ("Processing Order @ San Fran Warehouse \n"  
							+ "Order Details " + request.toString());
					System.out.println ("New " + request.getEquipment().getDescription() + " Inventory Level @ San Fran = " + newInv + "\n");
				
			
		} else {
			System.out.println ("Insufficient Inventory Order Could not be processed!");
		
		}
	}
	
}
