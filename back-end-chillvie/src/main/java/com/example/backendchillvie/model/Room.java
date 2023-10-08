package com.example.backendchillvie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer quantityOfChair;

    private boolean maintenance;

    private boolean flagDeleted;

    public Room() {
    }

    public Room(Long id, String name, Integer quantityOfChair, boolean maintenance, boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.quantityOfChair = quantityOfChair;
        this.maintenance = maintenance;
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

    public Integer getQuantityOfChair() {
        return quantityOfChair;
    }

    public void setQuantityOfChair(Integer quantityOfChair) {
        this.quantityOfChair = quantityOfChair;
    }

    public boolean isMaintenance() {
        return maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDelete) {
        this.flagDeleted = flagDelete;
    }
}
