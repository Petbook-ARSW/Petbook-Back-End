package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "datehour")
    private Timestamp datehour;

    public Notification() {
    }

    public Notification(int id, String description, int iduser, int datehour) {
        this.id = id;
        this.description = description;
        this.iduser = iduser;
        this.datehour = new Timestamp(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Timestamp getDatehour() {
        return datehour;
    }

    public void setDatehour(Timestamp datehour) {
        this.datehour = datehour;
    }
}
