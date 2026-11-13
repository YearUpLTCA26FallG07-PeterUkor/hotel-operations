package com.pluralsight;

public class Reservation {
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;

        // calculate price from room type and weekend
        setPrice();
    }

    // calculate price
    public void setPrice() {
        // set price
        if (roomType.equalsIgnoreCase("king")) {
            price = 139;
        } else if (roomType.equalsIgnoreCase("double")) {
            price = 124;
        } else {
            throw  new IllegalArgumentException("Invalid room type");
        }

        // increase price by 10% if stay is over a weekend
        if (weekend) {
            price += (price / 100) * 10;
        }
    }

    public String getRoomType() {
        return roomType;
    }

    // recalculate price after changing weekend
    public void setRoomType(String roomType) {
        this.roomType = roomType;
        setPrice();
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    // recalculate price after changing weekend
    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
        setPrice();
    }

    public double getReservationTotal() {
        return price * numberOfNights;
    }
}
