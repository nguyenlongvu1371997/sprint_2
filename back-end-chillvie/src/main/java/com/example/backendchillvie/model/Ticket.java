package com.example.backendchillvie.model;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @Column(name = "under_22")
    private boolean under22;

    private Double price;

    public Ticket() {
    }

    public Ticket(Long id, Seat seat, Customer customer, boolean under22, Double price) {
        this.id = id;
        this.seat = seat;
        this.customer = customer;
        this.under22 = under22;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isUnder22() {
        return under22;
    }

    public void setUnder22(boolean under22) {
        this.under22 = under22;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
