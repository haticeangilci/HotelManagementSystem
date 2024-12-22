package com.tpe.hotelManagementSystem.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_reservations")  //rezervasyonların tablosu
public class Reservation {
    //bu sınıf, bir rezervasyonun özelliklerini ve ilişkilerini içeriyor.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate checkInDate;
    @Column(nullable = false)
    private LocalDate checkOutDate;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Guest guest;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Room room;

    //getter and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", room=" + room +
                '}';
    }
}
