package com.example.backendchillvie.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String director;
    private String actor;
    private LocalDate releaseDate;
    @Column(columnDefinition = "longText")
    private String note;

    private String trailer;

    private Integer showingTime;
    @ManyToOne
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private Label label;

    private boolean isShowing;

    private boolean flagDeleted;

    public Movie() {
    }

    public Movie(Long id, String name, String director, String actor, LocalDate releaseDate, String note,
                 String trailer, Integer showingTime, Label label, boolean isShowing, boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actor = actor;
        this.releaseDate = releaseDate;
        this.note = note;
        this.trailer = trailer;
        this.showingTime = showingTime;
        this.label = label;
        this.isShowing = isShowing;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Integer getShowingTime() {
        return showingTime;
    }

    public void setShowingTime(Integer showingTime) {
        this.showingTime = showingTime;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }
}
