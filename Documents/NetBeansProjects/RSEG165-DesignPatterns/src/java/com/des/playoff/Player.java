package com.des.playoff;

public class Player implements PlayoffCommand {
	
	private PlayoffIMediator mediator;
	private String sport;
	private int level;
	private int time;
	private String playerName;
	
	public Player (PlayoffIMediator mediator, String playerName, String sport, int level, int time) {
		this.mediator = mediator;
		this.playerName = playerName;
		this.sport = sport;
		this.level = level;
		this.time = time;
	}
	
	public void play() {
		
		if (mediator.isFieldOK() && mediator.isRefOK()) {
			
			System.out.println("Match Found!!");
			mediator.sendInvites();
			
		} else{
			
			System.out.println("No available Options");
		}
		
	}

	public String getSport() {return sport;}
	public void setSport(String sport) {this.sport = sport;}

	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}

	public int getTime() {return time;}
	public void setTime(int time) {this.time = time;}

	public String getPlayerName() {return playerName;}
	public void setPlayerName(String playerName) {this.playerName = playerName;	}
	

}
