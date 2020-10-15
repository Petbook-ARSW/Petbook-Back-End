package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "raffle")
public class Raffle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "raffledate")
    private Date date;

    @Column(name = "rafflehour")
    private Time time;

    @Column(name = "idgoal")
    private int idgoal;

    @Column(name = "ganador")
    private int ganador;

    @Column(name = "eventid")
    private int donationId;

    public Raffle(){}

    public Raffle(Date date,Time time,int idgoal,int ganador,int donationId){
        this.date=date;
        this.time=time;
        this.idgoal=idgoal;
        this.ganador=ganador;
        this.donationId=donationId;
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getIdgoal() {
        return idgoal;
    }

    public void setIdgoal(int idgoal) {
        this.idgoal = idgoal;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
}
