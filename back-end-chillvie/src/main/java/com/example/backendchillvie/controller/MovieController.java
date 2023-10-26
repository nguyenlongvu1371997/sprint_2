package com.example.backendchillvie.controller;

import com.example.backendchillvie.model.Movie;
import com.example.backendchillvie.projection.IMovieProjection;
import com.example.backendchillvie.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private IMovieService iMovieService;

    @GetMapping("/showing")
    public ResponseEntity<List<Movie>> getMovieIsShowing(){
        List<Movie> list = iMovieService.getMovieIsShowing();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/showing-movie")
    public ResponseEntity<List<IMovieProjection>> getListShowingMovie(@RequestParam("name")String name){
        if(name==null){
            name="";
        }
        List<IMovieProjection> list = iMovieService.getListShowingMovie(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/upcoming-movie")
    public ResponseEntity<List<IMovieProjection>> getListUpcomingMovie(@RequestParam("name")String name){
        if(name==null){
            name="";
        }
        List<IMovieProjection> list = iMovieService.getListUpcomingMovie(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getMovieById(@RequestParam("id")Long id){
        Optional<Movie> movie = iMovieService.getMovieById(id);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>("notOk", HttpStatus.BAD_REQUEST);
    }
}
