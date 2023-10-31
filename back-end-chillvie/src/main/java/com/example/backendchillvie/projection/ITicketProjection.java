package com.example.backendchillvie.projection;

public interface ITicketProjection {
    Long getId();
    Long getCustomer();
    String getRoom();
    String getSeat();

    String getTimeShow();
    String getNameMovie();

    String getPicture();

    Double getPrice();
}
