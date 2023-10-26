package com.example.backendchillvie.service;

import com.example.backendchillvie.projection.ITicketProjection;
import com.example.backendchillvie.repository.ICustomerRepository;
import com.example.backendchillvie.repository.ISeatRepository;
import com.example.backendchillvie.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    ITicketRepository iTicketRepository;
    @Autowired
    ISeatRepository iSeatRepository;

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Boolean getTicket(List<Long> list, Long id) {
        if(!checkTicket(list, id)){
            return false;
        }
        Double price = 50.0;

        Long idCustomer = iCustomerRepository.getCustomerIdByAppUser(id);

        for (Long idSeat : list) {
            iSeatRepository.setSeatAvailable(idSeat);
            iTicketRepository.createSeat(idSeat,idCustomer,price);
        }
        return true;
    }

    @Override
    public Boolean checkTicket(List<Long> list, Long id) {
        for (Long idSeat : list) {
            if (!iSeatRepository.checkAvailableOfSeat(idSeat)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<ITicketProjection> getListTicketByCustomerId(Long id) {
        Long idCustomer = iCustomerRepository.getCustomerIdByAppUser(id);
        return iTicketRepository.getListTicketByCustomerId(idCustomer);
    }
}
