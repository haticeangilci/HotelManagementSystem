package com.tpe.hotelManagementSystem.exceptions;

public class HotelNotFoundException extends Throwable {
    public boolean getMessage;

    public HotelNotFoundException(String message) {
        super(message);//called parent's constructed

    }
}
