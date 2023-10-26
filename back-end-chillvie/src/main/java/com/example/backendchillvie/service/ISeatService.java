package com.example.backendchillvie.service;

import com.example.backendchillvie.projection.ISeatProjection;

import java.util.List;

public interface ISeatService {
    ISeatProjection[][] getSeatByShowtimeId(Long id);


}
