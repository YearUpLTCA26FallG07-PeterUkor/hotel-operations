package com.pluralsight;

public class Hotel {
    private String hotelName;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // initialize all member attributes with arguments
    public Hotel(String hotelName, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.hotelName = hotelName;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // initialize booked rooms with 0
    public Hotel(String hotelName, int numberOfSuites, int numberOfRooms) {
        this.hotelName = hotelName;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public boolean bookRoom(int roomCount, boolean suite) {

        // check whether the room type is available and update inventory
        if (suite) {

            if (roomCount > getAvailableSuites()) {
                return false;
            }
            bookedSuites += roomCount;

        } else {

            if (roomCount > getAvailableRooms()) {
                return true;
            }
            bookedBasicRooms += roomCount;
        }
        return true;
    }

    // calculate number of available rooms
    public int getAvailableRooms() {
        return numberOfRooms - numberOfSuites - bookedBasicRooms;
    }

    // calculate number of available suites
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }


}
