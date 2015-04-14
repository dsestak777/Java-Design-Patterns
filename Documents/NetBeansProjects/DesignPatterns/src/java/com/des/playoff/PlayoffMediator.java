package com.des.playoff;

import java.util.ArrayList;

public class PlayoffMediator implements PlayoffIMediator {

	private ArrayList<Field> fields;
	private ArrayList<Referee> referees;
	private Player player;
	public boolean fieldOK;
	public boolean refOK;
	Referee chosenRef;
	Field chosenField;
	
	public void registerFields(ArrayList<Field> fields) {
		this.fields = fields;
		
	}

	public void registerRefs(ArrayList<Referee> referees) {
		this.referees = referees;
		
	}
	
	public void registerPlayer(Player player) {
		this.player = player;
	}

	public boolean isFieldOK() {
		checkFields();
		return fieldOK;
	}

	public boolean isRefOK() {
		checkRefs();
		return refOK;
	}

	public void setFieldStatus(boolean status) {
		fieldOK = status;
	}

	public void setRefereeStatus(boolean status) {
		refOK = status;
	}

	public void checkFields() {
		
		fieldOK=false;
		
		for (int i=0; i<fields.size();i++) {
			 if (fields.get(i).getTime()==player.getTime() && fields.get(i).getSport().equalsIgnoreCase(player.getSport()) 
					 && fields.get(i).getLevel() == player.getLevel()) {
				  
				 fieldOK=true;
				 chosenField = fields.get(i);		
			 }
		}
		
	}

	public void checkRefs() {
		
		refOK=false;
		
		for (int i=0; i<referees.size();i++) {
			 if (referees.get(i).getTime()==player.getTime() && referees.get(i).getSport().equalsIgnoreCase(player.getSport()) 
					 && referees.get(i).getLevel() == player.getLevel()) {
				  
				 refOK=true;
				 chosenRef = referees.get(i);
				 
			 } 
			
		}
	}
	
	public void sendInvites() {
		System.out.println("Send invite to Player:");
		System.out.println("Name = " + player.getPlayerName() + " Time Zone = " + player.getTime() + " Level = " + player.getLevel());
		System.out.println("Send Reservation Notice to Field:");
		System.out.println("Field Name = " + chosenField.getFieldName() + " Sport = " + chosenField.getSport());
		System.out.println("Send invite to Referee:");
		System.out.println("Referee Name = " + chosenRef.getRefName());
		
	}

}
