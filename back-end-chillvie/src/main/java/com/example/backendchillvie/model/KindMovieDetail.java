package com.example.backendchillvie.model;

import javax.persistence.*;

@Entity
public class KindMovieDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "kind_movie_id", referencedColumnName = "id")
    private KindMovie kindMovie;

    public KindMovieDetail() {
    }

    public KindMovieDetail(Long id, Movie movie, KindMovie kindMovie) {
        this.id = id;
        this.movie = movie;
        this.kindMovie = kindMovie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public KindMovie getKindMovie() {
        return kindMovie;
    }

    public void setKindMovie(KindMovie kindMovie) {
        this.kindMovie = kindMovie;
    }
}
