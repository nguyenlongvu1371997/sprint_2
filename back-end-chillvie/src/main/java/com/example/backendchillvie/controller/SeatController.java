package com.example.backendchillvie.controller;

import com.example.backendchillvie.projection.ISeatProjection;
import com.example.backendchillvie.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/seat")
public class SeatController {
    @Autowired
    private ISeatService iSeatService;

    @GetMapping("/showtime")
    public ResponseEntity<ISeatProjection[][]> getSeatByShowtimeId(@RequestParam("id")Long id){
        ISeatProjection[][] arr = iSeatService.getSeatByShowtimeId(id);
        return new ResponseEntity<>(arr, HttpStatus.OK);
    }


}
