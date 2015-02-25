package com.des.playoff;

import java.util.ArrayList;

public interface PlayoffIMediator {

	public void registerFields (ArrayList<Field> fields);
	
	public void registerRefs (ArrayList<Referee> referees);
	
	public void registerPlayer (Player player);
	
	public boolean isFieldOK();
	
	public boolean isRefOK();
	
	public void setFieldStatus(boolean status);
	
	public void setRefereeStatus(boolean status);
	
	public void checkFields();
	
	public void checkRefs();
	
	public void sendInvites();
}
