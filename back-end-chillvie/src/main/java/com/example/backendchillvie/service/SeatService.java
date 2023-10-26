package com.example.backendchillvie.service;

import com.example.backendchillvie.projection.ISeatProjection;
import com.example.backendchillvie.repository.ISeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatService implements ISeatService{
    @Autowired
    private ISeatRepository iSeatRepository;


    @Override
    public ISeatProjection[][] getSeatByShowtimeId(Long id) {
       List<ISeatProjection> list = iSeatRepository.getSeatByShowtimeId(id);
        ISeatProjection[][] arr= new ISeatProjection[6][10];
        for (ISeatProjection element:list) {
            char c = element.getName().charAt(0);

            int number = Integer.parseInt(element.getName().substring(1,element.getName().length()));
            switch (c){
                case 'A':
                    arr[0][number-1]=element;
                    break;
                case 'B':
                    arr[1][number-1]=element;
                    break;
                case 'C':
                    arr[2][number-1]=element;
                    break;
                case 'D':
                    arr[3][number-1]=element;
                    break;
                case 'E':
                    arr[4][number-1]=element;
                    break;
                case 'F':
                    arr[5][number-1]=element;
                    break;
                default:
                    break;

            }
        }
        return arr;
    }


}
