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

    @Column(name = "valor")
    private int valor;

    public Goal(){}

    public Goal(int donationId,String prize,Boolean state,int valor){
        this.donationId=donationId;
        this.prize=prize;
        this.state=state;
        this.valor=valor;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
