package com.example.backendchillvie.repository;

import com.example.backendchillvie.model.Seat;
import com.example.backendchillvie.projection.ISeatProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface ISeatRepository extends JpaRepository<Seat, Long> {
    @Query(nativeQuery = true,value = "select * from seat where showtime_id = :id")
    List<ISeatProjection> getSeatByShowtimeId(@Param("id")Long id);

    @Query(nativeQuery = true, value = "select available from seat where id = :id")
    Boolean checkAvailableOfSeat(@Param("id")Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update seat set available=false where id = :id")
    void setSeatAvailable(@Param("id")Long id);


}
