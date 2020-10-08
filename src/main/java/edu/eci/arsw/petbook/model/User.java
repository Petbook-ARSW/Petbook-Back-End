/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.petbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Angi
 */

@Entity
@Table(name = "petbookuser")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "pasword")
    private String pasword;

    @Column(name = "usertype")
    private String userType;

    @Column(name = "mail")
    private String mail;

    @Column(name = "numberphone")
    private Long numberPhone;

    @Column(name = "information")
    private String information;

    @Column(name = "birthdate")
    private Date birthdate;

    public User() {

    }

    public User(String userName, String password, String userType, String mail, Long numberPhone, String information, Date birthdate) {
        this.userName = userName;
        this.pasword = password;
        this.userType = userType;
        this.mail = mail;
        this.numberPhone = numberPhone;
        this.information = information;
        this.birthdate = birthdate;
        //System.out.println("entrooooooooooooooo");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(Long numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }
}
