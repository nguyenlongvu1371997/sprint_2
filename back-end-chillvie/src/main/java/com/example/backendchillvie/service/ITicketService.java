package com.example.backendchillvie.service;

import com.example.backendchillvie.projection.ITicketProjection;

import java.util.List;

public interface ITicketService {
    Boolean getTicket(List<Long> list, Long id);

    Boolean checkTicket(List<Long> list, Long id);

    List<ITicketProjection> getListTicketByCustomerId(Long id);

}
