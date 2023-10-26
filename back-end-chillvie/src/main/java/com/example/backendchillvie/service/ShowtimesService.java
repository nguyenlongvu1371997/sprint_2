package com.example.backendchillvie.service;

import com.example.backendchillvie.model.Showtimes;
import com.example.backendchillvie.projection.IShowtimesProjection;
import com.example.backendchillvie.repository.IShowtimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimesService implements IShowtimesService{
    @Autowired
    private IShowtimesRepository iShowtimesRepository;
    @Override
    public List<IShowtimesProjection> getShowtimesTodayByMovieId(Long id) {
        return iShowtimesRepository.getShowtimesTodayByMovieId(id);
    }

    @Override
    public List<IShowtimesProjection> getShowtimesNextDayByMovieId(Long id) {
        return iShowtimesRepository.getShowtimesNextDayByMovieId(id);
    }

    @Override
    public List<IShowtimesProjection> getShowtimesDayAfterTomorrowByMovieId(Long id) {
        return iShowtimesRepository.getShowtimesDayAfterTomorrowByMovieId(id);
    }

    @Override
    public Optional<Showtimes> getShowtimeById(Long id) {
        return iShowtimesRepository.getShowtimesByIdAndFlagDeletedIsFalse(id);
    }
}
