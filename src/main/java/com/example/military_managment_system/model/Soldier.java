package com.example.military_managment_system.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Soldier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String regNo;
    private String nationalId;
    private String firstName;
    private String lastName;
    private String Rank;
    private String Nationality;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String gender;
    private String email;

    public Soldier() {
    }

    public Soldier(String regNo,String nationality,Long id, String firstName, String lastName, String rank, Date dob, String gender, String email ,String nationalId) {
        this.regNo = regNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Rank = rank;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.nationalId=nationalId;
        this.nationalId=nationalId;
        this.id=id;

    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


