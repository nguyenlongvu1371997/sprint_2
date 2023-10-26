package com.example.final_exam.service;

import com.example.final_exam.model.Rooms;
import com.example.final_exam.projection.IRoomsProjection;

import java.util.List;

public interface IRoomsService {
    List<IRoomsProjection> getAllRooms();

    List<IRoomsProjection> getAllRoomsByName(String name);

    List<IRoomsProjection> getAllRoomsByManagerName(String name);

    void deleteRoomById(Long id);

    void createRoom(Rooms rooms, Long id);
}
