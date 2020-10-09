package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "participants")
public class Participant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "idevent")
    private int idevent;

    public Participant() {
    }

    public Participant(int iduser, int idevent) {
        this.idevent = idevent;
        this.iduser = iduser;
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

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }
}
