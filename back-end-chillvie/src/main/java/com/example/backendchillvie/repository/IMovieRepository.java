package com.example.backendchillvie.repository;

import com.example.backendchillvie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

}
