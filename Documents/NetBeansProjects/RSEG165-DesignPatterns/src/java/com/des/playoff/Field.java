package com.des.playoff;

public class Field implements PlayoffCommand {
	
	private PlayoffIMediator mediator;
	private String sport;
	private int level;
	private int time;
	private String fieldName;
	
	public Field(PlayoffIMediator mediator, String fieldName, String sport, int level, int time) {
		this.mediator = mediator;
		this.fieldName = fieldName;
		this.sport = sport;
		this.level = level;
		this.time = time;
		
	}
	
	@Override
	public void play() {
			
	}

	public String getSport() {return sport;}
	public void setSport(String sport) {this.sport = sport;}

	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}

	public int getTime() {return time;}
	public void setTime(int time) {this.time = time;}

	public String getFieldName() {return fieldName;}
	public void setFieldName(String fieldName) {this.fieldName = fieldName;}
	
	
}
