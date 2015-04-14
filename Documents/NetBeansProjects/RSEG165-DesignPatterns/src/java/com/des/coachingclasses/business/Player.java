/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.des.coachingclasses.business;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author dsestak
 */
@Entity 
@Table(name="PLAYER")
public class Player implements Serializable {
    private int playerID;
    private String playerName;
    private String className;
    private Coach coachDetails;
    
    public Player () {}
    
    public Player (String playerName, String className) { 
        this.playerName = playerName;
        this.className = className; }    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PLAYER_ID")
    public int getPlayerId() {return this.playerID;}

    public void setPlayerId(int playerID) {this.playerID = playerID;}
    
    @Column(name = "PLAYER_NAME") 
    public String getPlayerName() {return this.playerName;}

    public void setPlayerName(String name) {this.playerName = name;}
    
    @Column(name = "CLASS_NAME") 
    public String getClassName() {return this.className;}

    public void setClassName(String name) {this.className = name;}

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COACH_ID", nullable=false)
    public Coach getCoachDetails() {return coachDetails;}

    public void setCoachDetails(Coach coachDetails) {this.coachDetails = coachDetails;}
    
    public String toString() {
        return "Player Id : " + this.getPlayerId() + "\t, Player Name : " + this.getPlayerName()
                + ", Class Name: " + this.getClassName() +
                " Coach Details: Coach Id:" + getCoachDetails().getCoachId() + " , Coach Name: "
                + getCoachDetails().getCoachName();
    }
}
