package com.example.backendchillvie.service;

import com.example.backendchillvie.model.Movie;
import com.example.backendchillvie.projection.IMovieProjection;
import com.example.backendchillvie.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService{
    @Autowired
    private IMovieRepository iMovieRepository;
    @Override
    public List<Movie> getMovieIsShowing() {
        return iMovieRepository.getMoviesByIsShowingIsTrueAndFlagDeletedIsFalse();
    }

    @Override
    public List<IMovieProjection> getListUpcomingMovie(String name) {
        return iMovieRepository.getListUpcomingMovie(name);
    }

    @Override
    public List<IMovieProjection> getListShowingMovie(String name) {
        return iMovieRepository.getListShowingMovie(name);
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return iMovieRepository.getMoviesByIdAndFlagDeletedIsFalse(id);
    }
}
