package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "coment")
public class Coment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "idpost")
    private int idpost;

    @Column(name = "mesage")
    private String mesage;

    public Coment() {
    }

    public Coment(int iduser, int idpost, String mesage) {
        this.idpost = idpost;
        this.iduser = iduser;
        this.mesage = mesage;
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

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
}