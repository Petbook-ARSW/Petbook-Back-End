package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "picture")
    private byte [] picture;

    @Column(name = "description")
    private String description;

    @Column(name = "uploaddate")
    private Date date;

    public Post() {

    }

    public Post(int iduser, byte [] picture, String description, java.util.Date date ) {
        this.iduser = iduser;
        this.picture = picture;
        this.description = description;
        this.date = new Date(date.getTime());
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}