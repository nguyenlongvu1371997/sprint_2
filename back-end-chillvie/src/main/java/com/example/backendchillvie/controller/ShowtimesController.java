package com.example.backendchillvie.controller;

import com.example.backendchillvie.model.Showtimes;
import com.example.backendchillvie.projection.IShowtimesProjection;
import com.example.backendchillvie.service.IShowtimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
@RequestMapping("/api/showtimes")
public class ShowtimesController {
    @Autowired
    private IShowtimesService iShowtimesService;

    @GetMapping("/movie")
    public ResponseEntity<List<IShowtimesProjection>> getShowtimesTodayByMovieId(@RequestParam("id")Long id){
        List<IShowtimesProjection> list = iShowtimesService.getShowtimesTodayByMovieId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/showtime")
    public ResponseEntity<Showtimes> getShowtimeById(@RequestParam("id")Long id){
        Optional<Showtimes> ojb = iShowtimesService.getShowtimeById(id);
        if(ojb.isPresent()){
            return new ResponseEntity<>(ojb.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
