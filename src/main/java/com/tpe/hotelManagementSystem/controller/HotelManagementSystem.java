package com.tpe.hotelManagementSystem.controller;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.exceptions.HotelNotFoundException;
import com.tpe.hotelManagementSystem.repository.HotelRepository;
import com.tpe.hotelManagementSystem.repository.RoomRepository;
import com.tpe.hotelManagementSystem.service.HotelService;
import com.tpe.hotelManagementSystem.service.RoomService;

import java.util.Scanner;

public class HotelManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    //ana menu kullanıcıya gösterilir ve seçimi alınır
    public static void displayHotelManagementSystemMenu() {
     //ana menü gösterilir ve kullanıcıdan bir seçim alınır
        //NOTE:SADECE 1'er tane service ve repo objeleri oluştrulur ve tüm uygulamada kullanılır.
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService =new HotelService(hotelRepository);

        RoomRepository roomRepository = new RoomRepository();
        RoomService roomService =new RoomService(roomRepository,hotelService);

        int choice;

        do{
            System.out.println("========== Hotel Management System ==========");
            System.out.println("1.Hotel Operations");
            System.out.println("2.Room Operations");
            System.out.println("3.Guest Operations");
            System.out.println("4.Reservation Operations");
            System.out.println("0.Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();// \n
            scanner.nextLine(); // eğer bir önceki kelimede enter'a bastıysa scanner'ın yeni bir kelime okumasına gerek kalması için

            switch (choice) {
                case 1://hotel Operations
                    displayHotelOperationsMenu(hotelService);
                    break;
                case 2://Room Operations
                    displayRoomOperationsMenu(roomService);
                    break;
                case 3://Guest Operations
                    displayGuestOperationsMenu();
                    break;
                case 4://Reservation Operations
                    displayReservationOperationsMenu();
                    break;
                case 0:
                    System.out.println("Good Bye...");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }while(choice !=0);
        }
//her bir kategori için ayrı metodlar oluşturalım:işlemleri gösteren ve seçimini alan
//hotel operations
private static void displayHotelOperationsMenu(HotelService hotelService) {

    System.out.println("Hotel Operation Menu");

    boolean exit = false;
    while (!exit) {
        System.out.println("==== Hotel Operations ====");
        System.out.println("1. Add a new hotel");
        System.out.println("2. Find Hotel By ID");
        System.out.println("3. Delete Hotel By ID");
        System.out.println("4. Find All Hotels");
        System.out.println("5. Update Hotel By ID");
        System.out.println("0. Return to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                //1-a:add new hotel
                hotelService.saveHotel();
                break;
            case 2:
                //2-find hotel by id
                System.out.println("Enter hotel ID");
                Long id = scanner.nextLong();
                scanner.nextLine();
                hotelService.findHotelById(id);

                break;
            case 3:
                //3-delete hotel by id


                break;
            case 4:
                //3-a:find all hotels
                hotelService.getAllHotels();
                break;
            case 5:
                //5-update hotel by id

                break;
            case 0:
                exit = true;
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

}

    //room operations
    private static void displayRoomOperationsMenu(RoomService roomService) {




        System.out.println("Room Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //1-a:add new room
                    roomService.saveRoom();

                    break;
                case 2:
                    //2-find room by id
                    //ÖDEV------------------------------------

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    //guest operations
    private static void displayGuestOperationsMenu() {
        System.out.println("Guest Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:

                    break;
            }
        }
    }

    //reservation operations
    private static void displayReservationOperationsMenu() {
        System.out.println("Reservation Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Reservation Operations ====");
            System.out.println("1. Add a new reservation");
            System.out.println("2. Find Reservation By ID");
            System.out.println("3. Find All Reservations");
            System.out.println("4. Delete Reservation By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:


                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


    }




}


