package com.example.final_exam.repository;

import com.example.final_exam.model.Rooms;
import com.example.final_exam.projection.IRoomsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRoomsRepository extends JpaRepository<Rooms, Long> {
    @Query(nativeQuery = true, value = "select r.id, e.id as manager_id,r.code, r.name , r.date_start, r.address, e.name as manager_name " +
            "from rooms r join employees e on r.id = e.rooms_id where e.positions_id = 2 and e.flag_deleted = false and r.flag_deleted = false ")
    List<IRoomsProjection> getAllRooms();

    @Query(nativeQuery = true, value = "select r.id,e.id as manager_id,r.code, r.name , r.date_start, r.address, e.name as manager_name " +
            "from rooms r join employees e on r.id = e.rooms_id " +
            "where e.positions_id = 2 and e.flag_deleted = false and r.flag_deleted = false and r.name like %:name%")
    List<IRoomsProjection> getAllRoomsByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "select r.id,e.id as manager_id,r.code, r.name , r.date_start, r.address, e.name as manager_name " +
            "from rooms r join employees e on r.id = e.rooms_id " +
            "where e.positions_id = 2 and e.flag_deleted = false and r.flag_deleted = false  and  e.name like %:name%")
    List<IRoomsProjection> getAllRoomsByManagerName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update rooms set flag_deleted = true where id = :id ")
    void deleteRoomById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into rooms(address, date_start, flag_deleted, code, name) \n" +
            "value(:address, :dateStart, false,:code, :name)")
    void createRoom(@Param("address")String address, @Param("dateStart")String dateStart,@Param("code")String code,@Param("name")String name);

    @Query(nativeQuery = true, value = "select id from rooms order by id desc limit 1")
    Long getNewestId();
}
