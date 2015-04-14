package com.des.playoff;

public class Referee implements PlayoffCommand {
	
	private PlayoffIMediator mediator;
	private String sport;
	private int level;
	private int time;
	private String refName;
	
	public Referee(PlayoffIMediator mediator, String refName, String sport, int level, int time) {
		this.mediator = mediator;
		this.refName = refName;
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

	public String getRefName() {return refName;}
	public void setRefName(String refName) {this.refName = refName;}
	
	
}
