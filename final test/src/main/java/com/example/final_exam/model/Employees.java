package com.example.final_exam.model;

import javax.persistence.*;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @Column(columnDefinition = "date", nullable = false)
    private String dateOfBirth;

    private Boolean gender;

    @ManyToOne
    @JoinColumn(name = "rooms_id", referencedColumnName = "id")
    private Rooms rooms;

    @ManyToOne
    @JoinColumn(name = "positions_id", referencedColumnName = "id")
    private Positions positions;

    private boolean flagDeleted;

    public Employees() {
    }

    public Employees(Long id, String code, String name, String dateOfBirth, Boolean gender, Rooms rooms, Positions positions, boolean flagDeleted) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.rooms = rooms;
        this.positions = positions;
        this.flagDeleted = flagDeleted;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }
}
