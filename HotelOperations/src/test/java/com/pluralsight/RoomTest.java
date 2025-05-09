package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    //isDirty
    @org.junit.jupiter.api.Test
    void checkInIsDirtyTrue(){
        Room room=new Room(2,50);

        room.checkIn();

        assertTrue(room.isDirty());
    }

    //isOccupied
    @org.junit.jupiter.api.Test
    void checkInIsOccupiedTrue(){
        Room room=new Room(2,50);

        room.checkIn();

        assertTrue(room.isOccupied());
    }

    //isDirty
    @org.junit.jupiter.api.Test
    void checkOutIsDirtyFalse(){
        Room room=new Room(2,50);

        room.checkIn();

        room.checkOut();

        assertFalse(room.isDirty());
    }

    //isOccupied
    @org.junit.jupiter.api.Test
    void checkOutIsOccupiedFalse(){
        Room room=new Room(2,50);

        room.checkIn();

        room.checkOut();

        assertFalse(room.isOccupied());
    }

    //isDirty
    @org.junit.jupiter.api.Test
    void cleanRoomIsDirtyFalse() {
        Room room = new Room(2, 50, true, true);

        room.cleanRoom();

        assertFalse(room.isDirty());
    }

    @org.junit.jupiter.api.Test
    void isAvailableTrue(){
        Room room=new Room(2,50);

        assertTrue(room.isAvailable());
    }

    @org.junit.jupiter.api.Test
    void isAvailableFalse(){
        Room room=new Room(2,50);

        room.checkIn();

        assertFalse(room.isAvailable());
    }
}