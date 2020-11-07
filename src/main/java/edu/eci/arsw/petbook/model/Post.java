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

    @Column(name = "photo")
    private String photo;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "descriptio")
    private String descriptio;

    public Post() {

    }

    public Post(int iduser, String photo, Date birthdate, String descriptio) {
        this.iduser = iduser;
        this.photo = photo;
        this.birthdate = birthdate;
        this.descriptio = descriptio;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public void setDescriptio(String descriptio) {
        this.descriptio = descriptio;
    }
}