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
import static javax.persistence.GenerationType.TABLE;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = "COACH")
public class Coach implements Serializable {
    private long coachID;
    private String coachName;
    private Set<Player> playerList = new HashSet<Player>();
    
    public Coach () {}
    
    public Coach (String coachName) {this.coachName = coachName;}    
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COACH_ID")
    public Long getCoachId() {return coachID;}

    public void setCoachId(Long coachID) {this.coachID = coachID;}
    
    @Column(name = "COACH_NAME")
    public String getCoachName() {return coachName;}

    public void setCoachName(String coachName) {this.coachName = coachName; }
    
    @OneToMany(mappedBy = "coachDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    public Set<Player> getPlayerList() {return playerList;}

    public void addToPlayerList(Player player) {
        player.setCoachDetails(this);
        this.playerList.add(player); }
    
    public void setPlayerList(Set<Player> playerList) {this.playerList = playerList;}
    
    public String toString () {return "Coach Name: " + getCoachName() + "Coach Id: " + getCoachId();}

}
