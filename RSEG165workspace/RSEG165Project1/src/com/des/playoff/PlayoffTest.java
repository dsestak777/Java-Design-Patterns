package com.des.playoff;

import java.util.ArrayList;
import java.util.List;

public class PlayoffTest {

	
	public static void main(String[] args) {
		//create arraylists for available referees and fields
		ArrayList<Field> fields = new ArrayList<>();
		ArrayList<Referee> referees = new ArrayList<>();
		
		PlayoffIMediator mediator = new PlayoffMediator();
	
		//create new player
		Player newPlayer = new Player(mediator, "Dave", "soccer", 1, 1);
		
		//create sport fields
		Field field1 = new Field(mediator, "Field1", "football", 2, 1);
		Field field2 = new Field(mediator, "Field2", "soccer", 1, 1);
		Field field3 = new Field(mediator, "Field3", "tennis", 2, 3);
		
		//create referees
		Referee referee1 = new Referee(mediator, "Tom", "tennis", 2, 3);
		Referee referee2 = new Referee(mediator, "Joe", "soccer", 1, 1);
		Referee referee3 = new Referee(mediator, "Terry", "football", 2, 1);
		
		//add to arraylists
		fields.add(field1);
		fields.add(field2);
		fields.add(field3);
		referees.add(referee1);
		referees.add(referee2);
		referees.add(referee3);
		
		//register everything with the mediator
		mediator.registerPlayer(newPlayer);
		mediator.registerFields(fields);
		mediator.registerRefs(referees);
		
		//use mediator to find if any games available meeting players criteria
		newPlayer.play();	
		
		
	}

}
