package com.des.ordermanagement;

import java.util.ArrayList;
import java.util.List;

public class ChicagoProcessor implements OrderChain {

	private OrderChain nextInChain;

	public void setNext(OrderChain c) {
		nextInChain = c;
	}

	public void process(Order request) {

		//get inventory level
		int inventory = request.getEquipment().getChicagoInv();	
	
		//check distance from warehouses
		if (request.getDistance() <= 300 && request.getItemQuantity() <= inventory) {
			
					
					//calculate inventory reduction
					
					int newInv = inventory - request.getItemQuantity();
					
					//set new inventory levels
					request.getEquipment().setChicagoInv(newInv);
					
					System.out.println ("Processing Order @ Chicago Warehouse \n"  
							+ "Order Details " + request.toString());
					System.out.println ("New " + request.getEquipment().getDescription() + " Inventory Level @ Chicago = " + newInv + "\n");
				
			
		} else {
			System.out.println ("Chicago Warehouse not Closest Warehouses or Insufficient Inventory Forward Request to Next Warehouse!");
			nextInChain.process(request);
		}
	}
	
}
