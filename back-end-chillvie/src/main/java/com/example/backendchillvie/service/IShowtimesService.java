package com.example.backendchillvie.service;

import com.example.backendchillvie.model.Showtimes;
import com.example.backendchillvie.projection.IShowtimesProjection;

import java.util.List;
import java.util.Optional;

public interface IShowtimesService {
    List<IShowtimesProjection> getShowtimesTodayByMovieId(Long id);
    List<IShowtimesProjection> getShowtimesNextDayByMovieId(Long id);
    List<IShowtimesProjection> getShowtimesDayAfterTomorrowByMovieId(Long id);

    Optional<Showtimes> getShowtimeById(Long id);
}
