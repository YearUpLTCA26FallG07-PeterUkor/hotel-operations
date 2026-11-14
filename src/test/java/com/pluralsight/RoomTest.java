package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void shouldCheckInAvailableRoom() {
        // arrange
        int numberOfBeds = 1;
        double price = 124;
        boolean occupied = false;
        boolean dirty = false;
        Room room = new Room(numberOfBeds, price, occupied, dirty);

        // act
        room.checkIn();

        // assert
        assertFalse(room.isAvailable());
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void shouldNotCheckInDirtyRoom() {
        // arrange
        int numberOfBeds = 1;
        double price = 124;
        boolean occupied = false;
        boolean dirty = true;
        Room room = new Room(numberOfBeds, price, occupied, dirty);

        // act
        room.checkIn();

        // assert
        assertFalse(room.isAvailable());
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void housekeepingShouldNotCleanOccupiedRoom() {
        int numberOfBeds = 1;
        double price = 124;
        boolean occupied = false;
        boolean dirty = false;
        Room room = new Room(numberOfBeds, price, occupied, dirty);

        // act
        room.checkIn();
        room.cleanRoom();

        // assert
        assertTrue(room.isDirty());
    }

    @Test
    void roomShouldBeUnoccupiedAndDirtyAfterCheckout() {
        int numberOfBeds = 1;
        double price = 124;
        boolean occupied = false;
        boolean dirty = false;
        Room room = new Room(numberOfBeds, price, occupied, dirty);

        // act
        room.checkIn();
        room.checkOut();

        // assert
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

}