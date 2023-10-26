package com.example.backendchillvie.service;

import com.example.backendchillvie.model.Movie;
import com.example.backendchillvie.projection.IMovieProjection;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> getMovieIsShowing();

    List<IMovieProjection> getListUpcomingMovie(String name);
    List<IMovieProjection> getListShowingMovie(String name);

    Optional<Movie> getMovieById(Long id);

}
