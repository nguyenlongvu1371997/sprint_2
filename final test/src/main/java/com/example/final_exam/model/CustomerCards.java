package com.example.final_exam.model;

import javax.persistence.*;

@Entity
public class CustomerCards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardCode;

    @ManyToOne
    @JoinColumn(name = "rooms_id", referencedColumnName = "id")
    private Rooms rooms;

    private String cardId;

    private String name;

    @Column(columnDefinition = "date", nullable = false)
    private String dateOfBirth;

    private boolean gender;

    @Column(columnDefinition = "date", nullable = false)
    private String dateStart;

    @Column(columnDefinition = "date", nullable = false)
    private String dateEnd;

    private boolean flagDeleted;

    public CustomerCards() {
    }

    public CustomerCards(Long id, String cardCode, Rooms rooms, String cardId, String name, String dateOfBirth, boolean gender, String dateStart, String dateEnd, boolean flagDeleted) {
        this.id = id;
        this.cardCode = cardCode;
        this.rooms = rooms;
        this.cardId = cardId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.flagDeleted = flagDeleted;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
