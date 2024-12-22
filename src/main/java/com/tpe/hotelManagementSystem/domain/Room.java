package com.tpe.hotelManagementSystem.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_rooms")
public class Room {

    //6.adım..

    @Id
   private Long id;
    @Column(nullable =false)
    private String roomNumber;
    @Column (nullable =false)
    private int capacity;

    @ManyToOne
    @JoinColumn(nullable = false)//odanın hangi otele sahip olduğunu gösteren hotel id'sini room tablosundaki hotel_id sütununa bağlıyoruz.'
    private Hotel hotel;//odanın hangi otele sahip olduğunu gösteren hotel objesi oluşturuyoruz.

    //oda rezervayson listesi ;1-2-3
    //rez list 1 id li olanı çıkardım. ozaman tablodanda silelim.


    @OneToMany(mappedBy = "room", orphanRemoval = true)
    private List<Reservation>reservations=new ArrayList<>();

    public Room() {

    }

    public Room(Long id, String roomNumber, int capacity, Hotel hotel) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hotel = hotel;
    }
    //getter ve setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}




