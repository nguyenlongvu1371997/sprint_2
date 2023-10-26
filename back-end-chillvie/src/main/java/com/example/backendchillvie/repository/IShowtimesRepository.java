package com.example.backendchillvie.repository;

import com.example.backendchillvie.model.Showtimes;
import com.example.backendchillvie.projection.IShowtimesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IShowtimesRepository extends JpaRepository<Showtimes,Long> {

    @Query(nativeQuery = true, value = "select id, time_show as timeShow from showtimes " +
            "where DATE(time_show) = curdate() and movie_id =:id")
    List<IShowtimesProjection> getShowtimesTodayByMovieId(@Param("id")Long id);

    Optional<Showtimes> getShowtimesByIdAndFlagDeletedIsFalse(Long id);
}
