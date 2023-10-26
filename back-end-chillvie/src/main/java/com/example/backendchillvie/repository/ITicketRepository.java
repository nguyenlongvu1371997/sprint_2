package com.example.backendchillvie.repository;

import com.example.backendchillvie.model.Ticket;
import com.example.backendchillvie.projection.ITicketProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket, Long> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into ticket(seat_id, customer_id,under_22, price) values " +
            "(:idSeat,:idCustomer,false,:price)")
    void createSeat(@Param("idSeat") Long idSeat, @Param("idCustomer") Long idCustomer, @Param("price") Double price);

    @Query(nativeQuery = true, value = "select t.id as id,t.customer_id as customer,r.name as room, s.name as seat,\n" +
            " st.time_show as timeShow, m.name as nameMovie, m.picture as picture \n" +
            "from ticket t \n" +
            "join seat s on t.seat_id = s.id \n" +
            "join showtimes st on s.showtime_id=st.id\n" +
            "join movie m on st.movie_id = m.id\n" +
            "join room r on st.room_id = r.id\n" +
            "where t.customer_id = :id")
    List<ITicketProjection> getListTicketByCustomerId(@Param("id") Long id);

}
