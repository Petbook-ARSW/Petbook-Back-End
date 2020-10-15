package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goal")
public class Goal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "eventid")
    private int donationId;

    @Column(name = "prize")
    private String prize;

    @Column(name = "state")
    private boolean state;

    @Column(name = "value_money")
    private int value_money;

    public Goal(){}

    public Goal(int donationId,String prize,Boolean state,int value_money){
        this.donationId=donationId;
        this.prize=prize;
        this.state=state;
        this.value_money=value_money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getValue_money() {
        return value_money;
    }

    public void setValue_money(int value_money) {
        this.value_money = value_money;
    }
}
