package com.des.ordermanagement;

import java.util.ArrayList;
import java.util.List;

public class NewYorkProcessor implements OrderChain {

	private OrderChain nextInChain;
//	private List<EquipmentItem> equipment = new ArrayList<>();

	public void setNext(OrderChain c) {
		nextInChain = c;
	}

	public void process(Order request) {

		//get inventory level
		int inventory = request.getEquipment().getNewYorkInv();	
	
		//check distance from warehouses
		if (request.getDistance() <= 200 && request.getItemQuantity() <= inventory) {
			
					
					//calculate inventory reduction
					
					int newInv = inventory - request.getItemQuantity();
					
					//set new inventory levels
					request.getEquipment().setNewYorkInv(newInv);
					
					System.out.println ("Processing Order @ New York Warehouse \n"  
							+ "Order Details " + request.toString());
					System.out.println ("New " + request.getEquipment().getDescription() + " Inventory Level @ New York = " + newInv + "\n");
				
			
		} else {
			System.out.println ("New York Warehouse not Closest Warehouses or Insufficient Inventory Forward Request to Next Warehouse!");
			nextInChain.process(request);
		}
	}
	
}
