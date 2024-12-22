package com.tpe.hotelManagementSystem.service;


import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.exceptions.HotelNotFoundException;
import com.tpe.hotelManagementSystem.repository.HotelRepository;

import java.util.List;
import java.util.Scanner;

public class HotelService {
    private Scanner scannner= new Scanner(System.in);

    private final HotelRepository hotelRepository;
    //parameter constructor
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //1-c: save hotel
    public void saveHotel() {
    //Add a new hotel
        Hotel hotel = new Hotel();
        System.out.println("Enter Hotel ID:");
        hotel.setId( scannner.nextLong());
        scannner.nextLine();

        System.out.println("Enter Hotel Name:");
        hotel.setName( scannner.nextLine());

        System.out.println("Enter Hotel Location:");
        hotel.setLocation( scannner.next());

        hotelRepository.save(hotel);
        System.out.println("Hotel Saved Successfully.Hotel ID : "+hotel.getId());



    }
    //2-b: find hotel by id
    public Hotel findHotelById(Long id)  {
        Hotel foundhotel=hotelRepository.findById(id);
        try{//Id si verilen hotel
        if (foundhotel != null) {
            System.out.println("-------------------------------------------");
            System.out.println(foundhotel);
            System.out.println("-------------------------------------------");
            return foundhotel;
        } else {
            throw new HotelNotFoundException("Hotel not found by id: " + id);
        }
    }catch (HotelNotFoundException e) {
            System.out.println(e.getMessage);
        }finally {

        }
    return null;
    }

    //3-d: Tüm hotelleri getirme
    public void getAllHotels() {
        List <Hotel> allHotel = hotelRepository.findAll();//select * from tbl_hotel
        if (allHotels.isEmpty()){
            System.out.println("Hotel list is EMPTY");
        }else{
            System.out.println("---------------ALL HOTELS----------------------------");
            for (Hotel hotel : allHotel) {
                System.out.println(hotel);
            }
            System.out.println("---------------ALL HOTELS----------------------------");
        }
    }
}


