package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "companyevent")
public class Event implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "eventname")
    private String name;

    @Column(name = "isdonaton")
    private boolean isDonaton;

    @Column(name = "address")
    private String address;

    @Column(name = "eventdate")
    private Date date;

    @Column(name = "eventhour")
    private Time hour;

    @Column(name = "information")
    private String information;

    @Column(name = "hostcompany")
    private int host;

    public Event(){ }

    public Event(String name, boolean isDonaton, String address, Date date, Time hour, String information, int host) {
        this.name = name;
        this.isDonaton = isDonaton;
        this.address = address;
        this.date = date;
        this.hour = hour;
        this.information = information;
        this.host = host;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
       return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public boolean isDonaton() {
        return isDonaton;
    }

    public void setDonaton(boolean donaton) {
        isDonaton = donaton;
    }

    public int getHost() {
        return host;
    }

    public void setHost(int host) {
        this.host = host;
    }

}