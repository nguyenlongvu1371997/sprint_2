package com.example.final_exam.service;

import com.example.final_exam.model.Rooms;
import com.example.final_exam.projection.IRoomsProjection;
import com.example.final_exam.repository.IEmployeesRepository;
import com.example.final_exam.repository.IRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomsService implements IRoomsService{
    @Autowired
    private IRoomsRepository iRoomsRepository;
    @Autowired
    private IEmployeesRepository iEmployeesRepository;
    @Override
    public List<IRoomsProjection> getAllRooms() {
        return iRoomsRepository.getAllRooms();
    }

    @Override
    public List<IRoomsProjection> getAllRoomsByName(String name) {
        return iRoomsRepository.getAllRoomsByName(name);
    }

    @Override
    public List<IRoomsProjection> getAllRoomsByManagerName(String name) {
        return iRoomsRepository.getAllRoomsByManagerName(name);
    }

    @Override
    public void deleteRoomById(Long id) {
        iRoomsRepository.deleteRoomById(id);
    }

    @Override
    public void createRoom(Rooms rooms, Long id) {
        iRoomsRepository.createRoom(rooms.getAddress(),rooms.getDateStart(),rooms.getCode(),rooms.getName());
        Long newestId = iRoomsRepository.getNewestId();
        iEmployeesRepository.updateEmployee(newestId,id);

    }
}
