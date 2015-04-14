package com.des.ordermanagement;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

	
	public static void main(String[] args) {
		//create arraylist for inventory
		List<EquipmentItem> equipment = new ArrayList<>();
		
		//configure Chain of Responsibility
		OrderChain o1 = new BostonProcessor();
		OrderChain o2 = new NewYorkProcessor();
		OrderChain o3 = new ChicagoProcessor();
		OrderChain o4 = new HoustonProcessor();
		OrderChain o5 = new SeattleProcessor();
		OrderChain o6 = new SanFranProcessor();
		o1.setNext(o2);
		o2.setNext(o3);
		o3.setNext(o4);
		o4.setNext(o5);
		o5.setNext(o6);

		//configure warehouse inventory
		EquipmentItem basketball = new EquipmentItem ("basketball",1, 10,20,30,40,50,60, 10.00);
		EquipmentItem tennisracket = new EquipmentItem ("tennis racket",2, 60,50,40,30,20,10, 50.00);
		
		equipment.add(basketball);
		equipment.add(tennisracket);
		
		//process order calling chain of responsibility
		o1.process(new Order(99, 5, basketball));
		o1.process(new Order(99, 15, basketball));
		o1.process(new Order(101, 5, tennisracket));
		//order with a 50% discount
		o1.process(new Order(299, 10, tennisracket, 50));
		//try order that is too large
		o1.process(new Order(101, 500, tennisracket));
		
	}

}
