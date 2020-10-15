package edu.eci.arsw.petbook.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "pet")
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "idowner")
    private int idowner;

    @Column(name = "petname")
    private String petname;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "information")
    private String information;

    public Pet() {

    }

    public Pet(int idowner, String petname, Date birthdate, String information) {
        this.idowner = idowner;
        this.petname = petname;
        this.birthdate = birthdate;
        this.information = information;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdowner() {
        return idowner;
    }

    public void setIdowner(int idowner) {
        this.idowner = idowner;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
