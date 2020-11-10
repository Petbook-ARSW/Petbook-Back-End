package edu.eci.arsw.petbook.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "idpost")
    private int idpost;
    
    public Like(){}
    
    public Like(int iduser, int idpost){
        this.idpost = idpost;
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

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }
    
}
