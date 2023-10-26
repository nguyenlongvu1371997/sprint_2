package com.example.final_exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean flagDeleted;

    public Positions(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Positions(Long id, String name, boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.flagDeleted = flagDeleted;
    }

    public Positions() {
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
}
