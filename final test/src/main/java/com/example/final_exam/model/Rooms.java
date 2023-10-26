package com.example.final_exam.model;

import javax.persistence.*;

@Entity
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "date", nullable = false)
    private String dateStart;

    private String name;

    private String address;

    private String code;

    private boolean flagDeleted;

    public Rooms(String dateStart, String name, String address, String code) {
        this.dateStart = dateStart;
        this.name = name;
        this.address = address;
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Rooms() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
