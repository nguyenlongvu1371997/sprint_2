package com.example.final_exam.controller;

import com.example.final_exam.model.Rooms;
import com.example.final_exam.projection.IRoomsProjection;
import com.example.final_exam.service.IRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/rooms")
@RestController
public class RoomsController {
    @Autowired
    private IRoomsService iRoomsService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllRooms(){
        List<IRoomsProjection> list = iRoomsService.getAllRooms();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/list/name")
    public ResponseEntity<?> getAllRoomsByName(@RequestParam("name") String name){
        List<IRoomsProjection> list = iRoomsService.getAllRoomsByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/list/manager-name")
    public ResponseEntity<?> getAllRoomsByManagerName(@RequestParam("name") String name){
        List<IRoomsProjection> list = iRoomsService.getAllRoomsByManagerName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoomById(@RequestParam("id")Long id){
        iRoomsService.deleteRoomById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestParam("name")String name,
                                        @RequestParam("id") Long id,@RequestParam("code")String code,
                                        @RequestParam("date")String date,@RequestParam("address")String address){
        System.out.println(id);
        System.out.println(date);
        System.out.println(name);
        Rooms rooms = new Rooms(date,name,address,code);
        iRoomsService.createRoom(rooms,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
