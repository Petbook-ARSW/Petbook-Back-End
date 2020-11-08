package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "donation")
public class Donation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "idrefuge")
    private int idrefuge;

    @Column(name = "idevent")
    private int idevent;

    @Column(name = "donationdate")
    private Date donationdate;

    @Column(name = "donationhour")
    private Time donationhour;

    @Column(name = "valor")
    private int valor;

    public Donation(){ }

    public Donation(int iduser, int idrefuge, int idevent, Date donationdate, Time donationhour, int valor) {
        this.iduser = iduser;
        this.idrefuge = idrefuge;
        this.idevent = idevent;
        this.donationdate = donationdate;
        this.donationhour = donationhour;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdrefuge() {
        return idrefuge;
    }

    public void setIdrefuge(int idrefuge) {
        this.idrefuge = idrefuge;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public Date getDonationdate() {
        return donationdate;
    }

    public void setDonationdate(Date donationdate) {
        this.donationdate = donationdate;
    }

    public Time getDonationhour() {
        return donationhour;
    }

    public void setDonationhour(Time donationhour) {
        this.donationhour = donationhour;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
