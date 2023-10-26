package com.example.backendchillvie.repository;

import com.example.backendchillvie.model.Movie;
import com.example.backendchillvie.projection.IMovieProjection;
import com.example.backendchillvie.service.IMovieService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> getMoviesByIsShowingIsTrueAndFlagDeletedIsFalse();

    Optional<Movie> getMoviesByIdAndFlagDeletedIsFalse(Long id);

    @Query(nativeQuery = true,value = "select m.id as id, m.name as name, m.director as director, m.actor as actor,\n" +
            "m.release_date as releaseDate, m.note as note, m.trailer as trailer, m.showing_time as showingTime,\n" +
            "l.name as label, m.is_showing as isShowing, m.picture as picture\n" +
            "from movie m join label l on m.label_id = l.id\n" +
            "where release_date > date_format(CURRENT_DATE(), '%Y-%m-%d') \n" +
            "and is_showing = false and m.flag_deleted = false and m.name like %:name%")
    List<IMovieProjection> getListUpcomingMovie(@Param("name")String name);

    @Query(nativeQuery = true, value = "select m.id as id, m.name as name, m.director as director, m.actor as actor,\n" +
            "m.release_date as releaseDate, m.note as note, m.trailer as trailer, m.showing_time as showingTime,\n" +
            "l.name as label, m.is_showing as isShowing, m.picture as picture\n" +
            "from movie m join label l on m.label_id = l.id\n" +
            "where is_showing = true and m.flag_deleted = false\n" +
            "and m.name like %:name%")
    List<IMovieProjection> getListShowingMovie(@Param("name")String name);
}
