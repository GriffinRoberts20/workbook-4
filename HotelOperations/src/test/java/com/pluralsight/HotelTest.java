package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;
class HotelTest {

    @org.junit.jupiter.api.Test
    void bookRoom() {

        Hotel hotel=new Hotel("wow",10,50);

        hotel.bookRoom(3,true);

        assertEquals(7,hotel.getAvailableSuites());

    }

    @org.junit.jupiter.api.Test
    void getAvailableSuites() {
    }

    @org.junit.jupiter.api.Test
    void getAvailableRooms() {
    }
}