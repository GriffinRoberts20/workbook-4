package com.pluralsight;

public class Reservation {

    private String roomType;
    private float pricePerNight;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = weekend;
        if(roomType.equals("king")){
            this.pricePerNight =139f;
        } else if (roomType.equals("double")) {
            this.pricePerNight =124f;
        }
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setWeekend(boolean weekend) {
        this.isWeekend = weekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public float getReservationTotal(){
        if(isWeekend()){
            return this.getNumberOfNights()*this.getPricePerNight()*1.1f;
        }
        return this.getNumberOfNights()*this.getPricePerNight();
    }
}
