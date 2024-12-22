package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Room;
import com.tpe.hotelManagementSystem.repository.RoomRepository;

import java.util.Scanner;

//service classları kendi repository classları ile görüşür.

public class RoomService {
    private Scanner scanner = new Scanner (System.in);

    private final RoomRepository roomRepository;

    private final HotelService hotelService;

    public RoomService(RoomRepository roomRepository, HotelService, hotelService HotelService hotelService){
        this.roomRepository = roomRepository;
        this.hotelService = this.hotelService;
    }
    //4-b: alınan bilgiler ile odayı kaydetme
    public void saveRoom(){
        Room room =new Room();
        System.out.println("Enter room ID: ");
        room.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter room number: ");
        room.setRoomNumber(scanner.next());
        scanner.nextLine();

        System.out.println("Enter room capacity: ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();


        System.out.println("Enter hotel ID: ");
        Long hotelId = scanner.nextLong();
        scanner.nextLine();

        //id si verilen oteli bulmak için...
        //hotelrepository.findById(olmayanOtelin)=null
        //tekrar kontrol yapmaya gerek yok
        //hotelservice

        Hotel hotel =hotelService.findHotelById(hotelId);
        if(hotel==null){
            room.setHotel(hotel);


            //hotel.getRooms().add(room);//mappedby tarafından yapıldı
            roomRepository.save(room);
            System.out.println("Room is saved succesfully.Room id: "+room.getId());
        }else {
            System.out.println();
        }







    }







}
