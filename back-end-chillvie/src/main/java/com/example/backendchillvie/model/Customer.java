package com.example.backendchillvie.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(length = 15)
    private String cardId;

    @Column(length = 15)
    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String email;

    @OneToOne
    @JoinColumn(name = "app_user_id",referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "kind_customer_id",referencedColumnName = "id")
    private KindCustomer kindCustomer;

    private double points;

    private boolean flagDeleted;

    public Customer() {
    }

    public Customer(Long id, String name, String cardId, String phoneNumber, LocalDate dateOfBirth, String email,
                    AppUser appUser, KindCustomer kindCustomer, double points, boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.appUser = appUser;
        this.kindCustomer = kindCustomer;
        this.points = points;
        this.flagDeleted = flagDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public KindCustomer getKindCustomer() {
        return kindCustomer;
    }

    public void setKindCustomer(KindCustomer kindCustomer) {
        this.kindCustomer = kindCustomer;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }
}
